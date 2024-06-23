<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Job Details</title>
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

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">Jobify.com</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">

        </ul>
    </div>
</nav>

<div class="container mt-5">
    <div class="card">
        <div class="card-body">
            <h2 class="card-title">Job Details</h2>
            <div class="card-text">
                <p><strong>Company:</strong> ${jobDetails.company}</p>
                <p><strong>Role:</strong> ${jobDetails.role}</p>
                <p><strong>Experience:</strong> ${jobDetails.experience}</p>
                <p><strong>Location:</strong> ${jobDetails.location}</p>
                <p><strong>Salary:</strong> ${jobDetails.salary}</p>
                <!-- Add more job details as needed -->
                
                <form action="apply" method="post" enctype="multipart/form-data">
                <input type="hidden" name="jobId" value="${jobDetails.id}">
                <input type="hidden" name="accId" value="${loggedInUserId}">
                <div class="form-group">
                <label for="resume">Upload Resume </label>
                <input type="file" class = "form-control-file" id="resume" name="resume">
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
