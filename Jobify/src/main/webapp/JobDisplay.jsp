<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>Sign In</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
        crossorigin="anonymous">
        
        
        <style>
         .navbar {
  background: linear-gradient(to right, violet, darkblue);
  padding: 11px; /* Add padding for better visibility */
}

.navbar-brand,
.navbar-nav .nav-link {
  color: #fff; /* You can change this color to your preferred text color */
  font-size: 2.5rem;
}
        
        
        </style>
</head>
<body>
       <nav class="navbar navbar-expand-lg navbar-light">
        <a class="navbar-brand" href="#">Jobify.com</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <!-- Add any additional navigation links as needed -->
                <li class="nav-item">
                    <a class="nav-link" href="#"></a>
                </li>
            </ul>
        </div>
    </nav>
    <br>
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
                                            <form id="editForm${job.id}" action="editSave" method="get">
                                                <input type="hidden" name="editJobId" value="${job.id}">
                                                <button type="submit" class="btn btn-primary"
                                                    onclick="editJob(${job.id})">Edit</button>
                                            </form>
                                        </td>
                                        <td>
                                            <form action="editSave" method="post" modelAttribute="jobRegisterEntity">
                                                <input type="hidden" name="jobId" value="${job.id}">
                                                <button type="submit" class="btn btn-danger"
                                                    style="font-size: 16px;">Delete</button>
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

    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <script>
        function editJob(jobId) {
            document.getElementById("editForm" + jobId).submit()
        }
    </script>
</body>
</html>
