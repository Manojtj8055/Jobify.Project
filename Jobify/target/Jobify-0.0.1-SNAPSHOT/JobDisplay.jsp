<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Sign In</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
<!--===============================================================================================-->	
	<link rel="icon" type="Image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->

</head>
<body>
<div class="header">
    <h1>JOBIFY.com</h1>
    <!-- Add any additional header content as needed -->
  </div>
<div>
<h2>Jobs Posted</h2>
</div>

<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				
			<c:if test="${not empty jobs}">
    <table class="table table-bordered">
        <thead>
            <tr>
                <th scope="col">Sl.no</th>
                <th scope="col">Company</th>
                <th scope="col">Role</th>
                <th scope="col">Experience</th>
                <th scope="col">Location</th>
                <th scope="col">Salary</th>
                <th scope="col">Skills</th>
                <th colspan="2">More Options</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="job" items="${jobs}" varStatus="status">
                <c:if test="${not job.deleted}">
                    <tr>
                        <td>${status.index + 1}</td> <!-- Use index+1 to start from 1 for Sl.no -->
                        <td>${job.company}</td>
                        <td>${job.role}</td>
                        <td>${job.experience}</td>
                        <td>${job.location}</td>
                        <td>${job.salary}</td>
                        <td>${job.skills}</td>
                        <td>
                            <form id="editForm${job.id}"  action="editSave" method="get">
                                <input type="hidden" name="editJobId" value="${job.id}">
                                <button type="submit" class="edit-button" onclick="editJob(${job.id})">Edit</button>
                            </form>
                        </td>
                        <td>
                            <form action="editSave" method="post" modelAttribute="jobRegisterEntity">
                                <input type="hidden" name="jobId" value="${job.id}"> 
                                <button type="submit" class="delete-button" style="font-size: 16px;">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:if>
            </c:forEach>
        </tbody>
    </table>
</c:if>

    	 <c:if test="${empty jobs}">
        <p>No jobs to display.</p>
    </c:if>
			
			</div>
		</div>
	</div>
	
	

	
<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script>
	function editJob(jobId) {

		document.getElementById("editForm" + jobId).submit()
	}
	</script>
<!--===============================================================================================-->
<!--===============================================================================================-->
	<script src="vendor/tilt/tilt.jquery.min.js"></script>
	<script >
		$('.js-tilt').tilt({
			scale: 1.1
		})	
	</script>
<!--===============================================================================================-->
	<script>
  /*   function sendOtp() {
        document.forms[0].action = "/forgotPassword";
        document.forms[0].submit();
    } */
</script>

</body>
</html>