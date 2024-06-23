package com.xworkz.jobify.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.xworkz.jobify.dto.JobRegisterDTO;
import com.xworkz.jobify.dto.JobRegisterEntity;
import com.xworkz.jobify.dto.JobifyDTO;
import com.xworkz.jobify.repository.JobifyRepositoryImpl;

@Service
public class JobRegisterServiceImpl implements JobRegisterService {

	@Autowired
	private JobifyRepositoryImpl repository;

	@Override
	public String saveJob(JobRegisterDTO dto, Model model, JobifyDTO dto2, String loggedInUserEmail) {
		if (dto != null && dto2 != null && loggedInUserEmail != null) {
			if (dto.getCompany() != null && !dto.getCompany().isEmpty()) {
				System.out.println("Company details entered");
				if (dto.getRole() != null && !dto.getRole().isEmpty()) {
					System.out.println("Role is specified");
					if (dto.getExperience() >= 0) {
						System.out.println("Experience is set");
						if (dto.getLocation() != null && !dto.getLocation().isEmpty()) {
							System.out.println("Location is placed");
							if (dto.getSalary() >= 100000) {
								System.out.println("Salary is fixed");
								if (dto.getSkills() != null && !dto.getSkills().isEmpty()) {
									System.out.println("Skills uploaded...");

									dto.setJobProviderEmail(loggedInUserEmail);

									JobRegisterEntity registerEntity = new JobRegisterEntity();
									BeanUtils.copyProperties(dto, registerEntity);
									registerEntity.setJobPosted(LocalDate.now());
									registerEntity.setStatus("Hiring");

									boolean flag = repository.saveJob(registerEntity);

									if (flag == true) {
										return "success";
									}

								} else {
									System.err.println("Skills not added");
								}
							} else {
								System.err.println("Salary is not uploaded ...???----");
							}
						} else {
							System.err.println("Location is not set...+++++");
						}
					} else {
						System.err.println("Experience not uploaded");
					}
				} else {
					System.err.println("Role not updated///.............");
				}
			} else {
				System.err.println("Company not entered....");
			}
		}
		return null;
	}

	public List<JobRegisterEntity> getJobsByJobProviderEmail(String jobProviderEmail) {
		System.out.println("Job fetched by " + jobProviderEmail);
		return repository.getJobsByJobProviderEmail(jobProviderEmail);

	}

	@Override
	public JobRegisterEntity getJobsById(Integer jobsId) {
		System.out.println("Job fetched by id " + jobsId);

		return repository.getJobsById(jobsId);

	}

	public String updateJobById(JobRegisterDTO dto, Model model, String loggedInUserEmail, JobRegisterEntity entity) {
		try {
			// Fetch the existing entity by ID
			JobRegisterEntity existingData = repository.getJobsById(entity.getId());

			System.err.println(existingData);
			// Check if the entity exists
			if (existingData != null) {
				// Update the fields with new values
				existingData.setCompany(dto.getCompany());
				existingData.setExperience(dto.getExperience());
				existingData.setLocation(dto.getLocation());
				existingData.setRole(dto.getRole());
				existingData.setSalary(dto.getSalary());
				existingData.setSkills(dto.getSkills());

				existingData.setUpdateBy(loggedInUserEmail);
				existingData.setUpdateOn(LocalDate.now());
				
				repository.updateExistingJob(existingData);
				model.addAttribute("jobPostedNew", "Edited Old Job");
				model.addAttribute("jobRegisterDto", new JobRegisterDTO());
				model.addAttribute("editMode", false);
				return "JobProvider";
			} else {
				// Handle the case where the entity with the given ID doesn't exist
				return "Job with ID " + entity.getId() + " not found";
			}
		} catch (Exception e) {
			// Handle exceptions
			e.printStackTrace();
			model.addAttribute("jobNotPosted", "Error updating job");
			return "JobProvider";
		}
	}

	public boolean jobIsExist(JobRegisterEntity entity, JobRegisterDTO dto, Model model) {
		JobRegisterEntity idExist = repository.getJobsById(entity.getId());
		System.out.println("Id from UI : -" + idExist);
		if (idExist != null) {

			if (idExist.getCompany().equals(dto.getCompany()) && idExist.getRole().equalsIgnoreCase(dto.getRole())
					&& idExist.getExperience().equals(dto.getExperience())) {
				model.addAttribute("newJob", "Update Successfull");
				return true;
			}

		}
		return false;

	}

	public boolean softDeleteJobById(Integer jobId, String jobProviderEmail, JobRegisterEntity entity) {

		try {
			System.out.println("Fecthed job is "+ jobId);
			JobRegisterEntity job = repository.getJobsById(jobId);

			System.out.println("Job Id Fetched : - " + job);

			if (job != null && jobProviderEmail.equals(job.getJobProviderEmail())) {
				job.setDeleted(true);
				job.setStatus("Stop");
				repository.saveJob(job);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

	}

	
	@Override
	public List<JobRegisterEntity> getAllActiveJobs() {
		return repository.allActiveJobs();
	}

	

	
//	@Override
//	public List<JobRegisterEntity> getAllActiveJobs(String loggedInUserEmail) {
//		
//		return repository.allActiveJobs(loggedInUserEmail);
//	}
//	
	

}