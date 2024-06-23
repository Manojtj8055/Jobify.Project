<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Applications</title>
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

<div class="container mt-5">
    <h2>Applications for Job ID: ${jobId}</h2>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Applicant ID</th>
                <th>Resume</th>
                <th>Applied On</th>
                <th>Resume File</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${applications}" var="application">
                <tr>
                    <td>${application.accId}</td>
                    <td>${application.resume}</td>
                    <td>${application.appliedOn}</td>
                    <td><a href="downloadResume?listId=${application.listId}" class="btn btn-primary">Download Resume</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
