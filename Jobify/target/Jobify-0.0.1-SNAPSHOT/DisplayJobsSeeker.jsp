<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<title>Display Jobs For Seekers</title>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
        crossorigin="anonymous">
    
    <style>
        .card-border {
            border: 6px solid #000;
            position: relative;
            margin-bottom: 25px; /* Add margin between cards */
        }

        .card-body {
            padding: 15px; /* Add padding to card body */
        }

        .card-button {
            position: absolute;
            bottom: 5px;
        }

        .apply-button {
            left: 5px;
        }

        .view-details-button {
            right: 5px;
        }
        
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
        <a class="navbar-brand" href="Registers">Jobify.com</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <!-- Add any additional navigation links as needed -->
                <li class="nav-item">
                </li>
            </ul>
        </div>
    </nav>
    
    <br>

    <!-- Iterate through the list of hiring jobs -->
<div class="container">
    <div class="row">
        <c:forEach var="job" items="${activeJobs}" varStatus="loop">
            <div class="col-sm-4">
                <!-- Wrap the card inside an anchor tag -->
					<a href="JobDetails/${job.id}" class="card-link">
                    <div class="card card-border" style="width: 20rem;">
                        <div class="card-body">
                            <h3 class="card-title">${job.company}</h3>
                            <h4 class="card-subtitle mb-2 text-muted">${job.role}</h4>
                            <p class="card-text">${job.location}</p>
                        </div>
                    </div>
                </a>
            </div>
            <!-- Close the row div after every third card -->
            <c:if test="${loop.index % 3 == 2}">
                </div><div class="row">
            </c:if>
        </c:forEach>
    </div>
</div>
</body>
</html>
