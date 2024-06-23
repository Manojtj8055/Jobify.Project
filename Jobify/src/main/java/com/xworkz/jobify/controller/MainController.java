package com.xworkz.jobify.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Multipart;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.boot.model.relational.Loggable;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.jobify.dto.ApplyEntity;
import com.xworkz.jobify.dto.JobRegisterDTO;
import com.xworkz.jobify.dto.JobRegisterEntity;
import com.xworkz.jobify.dto.JobifyDTO;
import com.xworkz.jobify.dto.JobifyEntity;
import com.xworkz.jobify.service.ApplyService;
import com.xworkz.jobify.service.JobRegisterServiceImpl;
import com.xworkz.jobify.service.JobifyServiceImpl;

@ComponentScan("com.xworkz")
@Controller
@RequestMapping("/")
public class MainController {

	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(MainController.class);

	@Autowired
	private JobifyServiceImpl service;

	@Autowired
	private JobRegisterServiceImpl registerService;

	@Autowired
	private ApplyService applied;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(JobifyDTO dto, Model model) {
		System.out.println(dto);
		boolean saved = service.validateAndSave(dto, model);
		if (saved) {
			model.addAttribute("save", "Registered Succesfully");
			logger.debug("Processing save methid with DTO: {}", dto);
			return "Registers";
		} else

			System.out.println(dto);
		return "Error";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String email, @RequestParam String password, Model model, String forget,
			HttpServletRequest request) {
		JobifyEntity entity = service.login(email, password, model);
		if (forget.equalsIgnoreCase("forgetPassword")) {

			return "Forgot";
		}

		if (forget.equalsIgnoreCase("login")) {
			if (entity != null) {
				System.out.println("Entity is not null and going to fetch account data");

				System.out.println(" Accountype  is being fetched " + entity.getAccountType());

				request.getSession().setAttribute("loggedInUserEmail", email);
				if (entity.getAccountType().equals("JobSeeker")) {
					request.getSession().setAttribute("loggedInUserId", entity.getId());
					return "JobSeeker";
				} else if (entity.getAccountType().equals("JobProvider")) {
					System.out.println("jobprovider accountype is being fetched");
					return "JobProvider";
				}

			}

			System.out.println("Not fetching data ");
			return "SignIn";
		}
		return "SignIn";

	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(String email, @RequestParam String resetOtp, Model model, String reset,
			HttpSession session) {
		System.out.println(email);

		if (reset.equalsIgnoreCase("otp")) {
			JobifyEntity entity = service.forgotPassword(email, model);

			if (entity != null) {

				model.addAttribute("success", "OTP sent Successfully..");
				model.addAttribute("email", email);

				session.setAttribute("email", email);
				return "Forgot"; // Replace with the appropriate view name
			} else {
				model.addAttribute("email", email);
				model.addAttribute("error", "OTP Not Sent..");
				return "Forgot"; // Replace with the appropriate view name
			}
		}
		if (reset.equalsIgnoreCase("reset")) {
			System.out.println("Running reset otp" + email);
			boolean flag = service.verifyOtp(email, resetOtp);
			if (flag == true) {
				model.addAttribute("email", email);

				return "ResetPassword";
			}

		}
		model.addAttribute("email", email);
		model.addAttribute("error", "You have entered wrong OTP...! ");
		return "Forgot";
	}

	@RequestMapping(value = "/reset", method = RequestMethod.POST)
	public String resetPassword(@RequestParam String password, Model model, HttpSession session) {
		String email = (String) session.getAttribute("email");

		System.out.println("email to set new : - " + email);
		if (email != null) {
			boolean resetSuccessfull = service.resetAccount(email, password);

			if (resetSuccessfull) {
				System.out.println("Email fetched : -" + email);
				model.addAttribute("email", email);

				model.addAttribute("resetSuccess", "Password reset succelogimsfull, You can login using new Password");
				return "SignIn";
			} else {
				model.addAttribute("resetError", "Passowrd reset failed ,Please try agian...! ");
				return "Forgot";
			}

		}
		return "Forgot";
	}

	@RequestMapping(value = "/jobDisplay", method = RequestMethod.GET)
	public String fetchJobsByEmail(Model model, HttpServletRequest request) {
		String loggedInUserEmail = (String) request.getSession().getAttribute("loggedInUserEmail");
		if (loggedInUserEmail != null) {

			List<JobRegisterEntity> jobs = registerService.getJobsByJobProviderEmail(loggedInUserEmail); ////
			System.out.println("Number of Jobs Fetched: " + jobs.size());
			model.addAttribute("jobs", jobs);
			return "JobDisplay";
		} else {
			model.addAttribute("jobsno", "Jobs not Fetched");
			System.out.println("Jobs not Fetched : - -");
			return "JobProvider";
		}

	}

	@RequestMapping(value = "/editSave", method = RequestMethod.GET)
	public String editJob(@RequestParam(name = "editJobId", required = false) Integer jobId, Model model,
			HttpServletRequest request) {

		if (jobId != null) {
			JobRegisterEntity jobEntity = registerService.getJobsById(jobId);
			System.out.println("Job by id : - " + jobEntity);

			if (jobEntity != null) {
				System.out.println("JobEntity : - " + jobEntity);

				model.addAttribute("jobRegisterDto", jobEntity);
				model.addAttribute("editMode", true);
			}
		}
		return "JobProvider";
	}

	@RequestMapping(value = "/jobSave", method = RequestMethod.POST)
	public String handleJobOperations(@ModelAttribute("jobRegisterDto") JobRegisterDTO dto, Model model, JobifyDTO dto2,
			HttpServletRequest request, JobRegisterEntity entity) {

		String loggedInUserEmail = (String) request.getSession().getAttribute("loggedInUserEmail");
		dto.setJobProviderEmail(loggedInUserEmail);

		if (loggedInUserEmail != null) {

			System.out.println("loggedinby : - " + loggedInUserEmail);

			System.out.println("Entity ID : - " + entity.getId());

			if (entity != null && entity.getId() != null && entity.getId() > 0) {
				// If the ID is present in the entity, it's an update operation
				String updateJob = registerService.updateJobById(dto, model, loggedInUserEmail, entity);
				System.err.println("UPDATE Job : - " + updateJob);
				if (updateJob != null) {
					System.out.println("Updating Job Successfully ----");
					model.addAttribute("jobPostedNew", "Edited Old Job");
				} else {
					System.out.println("Updating Not Successful XXXX");
					model.addAttribute("jobNotPosted", "Job Not Edited / Uploaded ");
				}
			} else {
				// If the ID is not present in the entity, it's a registration operation

				System.err.println("Registering new job for edit option");

				String registerJob = registerService.saveJob(dto, model, dto2, loggedInUserEmail);
				if (registerJob != null) {
					System.out.println("Registering Job Successfully");
					model.addAttribute("jobPosted", "Job Posted Successfully...!");
				} else {
					System.out.println("Error Registering Job");
					model.addAttribute("jobNotPosted", "Error Registering Job...?");
				}
			}

			return "JobProvider";
		} else {
			System.out.println("User not logged in");
			model.addAttribute("jobNotPosted", "Job Not Posted..?");
			return "JobProvider";
		}
	}

	@RequestMapping(value = "/editSave", method = RequestMethod.POST)
	public String deleteJob(JobRegisterEntity entity, Model model,
			@RequestParam(name = "jobId", required = false) Integer jobId, HttpServletRequest request) {
		String loggedInUserEmail = (String) request.getSession().getAttribute("loggedInUserEmail");

		System.err.println("Email logged : - " + loggedInUserEmail);

		if (loggedInUserEmail != null) {
			boolean softDeleteSuccess = registerService.softDeleteJobById(jobId, loggedInUserEmail, entity);
			List<JobRegisterEntity> activeJobs = registerService.getAllActiveJobs();
			if (softDeleteSuccess) {
				System.out.println("Soft Delete Id : - " + softDeleteSuccess);
				model.addAttribute("TempDelete", "Deleted Successfully");
				model.addAttribute("jobs", activeJobs);

			} else {
				model.addAttribute("deleteError", "Not Deleted");
			}

			return "JobDisplay";
		} else {

			return "JobDisplay";
		}
	}

	@RequestMapping(value = "/activeJobs", method = RequestMethod.GET)
	public String displayActiveJobsToSeeker(JobRegisterEntity entity, Model model) {
		List<JobRegisterEntity> activeJobs = registerService.getAllActiveJobs();
		System.err.println("Active Job sFetched :-" + activeJobs.size());
		if (activeJobs != null) {
			List<JobRegisterEntity> hiringJobs = new ArrayList<JobRegisterEntity>();
			System.err.println("Hiring JobsFound : - " + hiringJobs.size());
			for (JobRegisterEntity job : activeJobs) {
				if ("Hiring".equalsIgnoreCase(job.getStatus())) {
					hiringJobs.add(job);
				}
			}
			model.addAttribute("activeJobs", hiringJobs);

		}

		return "DisplayJobsSeeker";
	}

	@RequestMapping(value = "/JobDetails/{id}", method = RequestMethod.GET)
	public String showJobDetails(@PathVariable Integer id, Model model, HttpServletRequest request) {
		int loggedInUserId = (int) request.getSession().getAttribute("loggedInUserId");
		JobRegisterEntity jobDetails = registerService.getJobsById(id);
		System.err.println("job found : " + jobDetails);
		if (jobDetails != null) {
			model.addAttribute("jobDetails", jobDetails);
			model.addAttribute("loggedInUserId", loggedInUserId);
			return "JobDetails";
		} else {
			return "DisplayJobsSeeker";
		}

	}

	@PostMapping("/JobDetails/apply")
	public String applyForJob(@RequestParam(value = "jobId", required = false) Integer jobId,
			@RequestParam(value = "accId", required = false) Integer accId,
			@RequestParam(value = "resume", required = false) MultipartFile resume, Model model) {
		try {

			String resumeFileName = resume.getOriginalFilename();
			System.out.println(resumeFileName);
//			System.out.println(resume.getResource().getFile().getPath());
			byte[] resumeData = resume.getBytes();
			boolean saved = applied.applicationsSave(jobId, accId, resumeFileName, resumeData);
			if (saved) {
				model.addAttribute("SUCCESFULLY APPLIED", "Success");
				return "JobSeeker";
			} else {
				return "error";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewApplications(@RequestParam("jobId") int jobId, Model model) {
        List<ApplyEntity> applications = applied.getApplicationByJobId(jobId);
        System.out.println("Applications found : - " + applications);
        model.addAttribute("applications", applications);
        model.addAttribute("jobId", jobId);
        return "ViewApplications"; // This should match the name of your JSP file
    }
}
