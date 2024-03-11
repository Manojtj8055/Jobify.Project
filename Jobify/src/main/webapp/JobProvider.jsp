<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JobProvider</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
        integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
        crossorigin="anonymous">
    <style>
        body {
            background-color: #e0e5ec;
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

        .header h1 {
            margin-top: 5; /* Add this to remove the top margin */
        }

        .limiter {
            width: 100%;
            margin: 0 auto;
        }

        .container-login100 {
            width: 100%;
            margin: 10 auto;
            padding-left: 15px;
            padding-right: 15px;
        }

        .wrap-login100 {
            width: 100%;
            margin: 0 auto;
        }

        .wrap-login100 form {
            width: 100%;
            max-width: 700px; /* Adjust the maximum width as needed */
            margin: 100 auto;
            position: relative;
        }

        .form-control {
            display: block;
            align-content;
            width: 60%;
            height: calc(2.5em + 0.75rem + 4px);
            padding: 1.375rem 1.75rem;
            font-size: 1rem;
            font-weight: 400;
            line-height: 1.5;
            color: #495057;
        }

        .container-login100-form-btn {
            text-align: left;
        }

        .custom-btn {
            margin-top: 183px; /* Add margin to the button */
            position: absolute;
            right: 0;
            top: 0;
        }

        .text-danger.small {
            float: right;
            margin-top: 10px; /* Add margin to the error messages */
        }
        
        .login100-form-title{
        font-weight: bold;
        font-size: 50px;
        }
    </style>
</head>

<header>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
</header>

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

    <div class="header">
        <h1></h1>
        <!-- Add any additional header content as needed -->
    </div>
    <br>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">
                <form action="jobSave" method="post">
                    <span class="login100-form-title">
                        Job Description
                    </span>
                    <div class="wrap-input100 validate-input">
                        <input class="input100" type="hidden" name="id" value="${jobRegisterDto.id}">
                    </div>
                    <div class="wrap-input100 validate-input">
                        <input class="input100" type="hidden" name="jobProviderEmail" value="<%=session.getAttribute("loggedInUserEmail")  %>">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Valid company is required">
                        <input class="input100 form-control" type="text" name="company" placeholder="Company Name" value="${jobRegisterDto.company}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Role is required">
                        <input class="input100 form-control" type="text" name="role" placeholder="Job Role" value="${jobRegisterDto.role}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Experience is required">
                        <input class="input100 form-control" type="number" name="experience" placeholder="Experience" value="${jobRegisterDto.experience}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Location is required">
                        <input class="input100 form-control" type="text" name="location" placeholder="Location of JOB" value="${jobRegisterDto.location}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Salary is required">
                        <input class="input100 form-control" type="number" name="salary" placeholder="CTC -per Annum" value="${jobRegisterDto.salary}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Skills are required">
                        <input class="input100 form-control" type="text" name="skills" placeholder="Skills Required for Job" value="${jobRegisterDto.skills}">
                    </div>
                    <br>
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn btn btn-primary" type="submit" value="">${editMode ? 'Update' : 'Register'}</button>
                    </div>
                    </form>
                    <button class="custom-btn btn btn-info" onclick="location.href='jobDisplay'" formaction="jobDisplay" formmethod="GET">Jobs Posted..!</button>
                    <p class="text-danger small">${jobPosted}</p>
                    <p class="text-danger small">${jobPostedNew}</p>
                    <p class="text-danger small">${jobNotPosted}</p>
                
            </div>
        </div>
    </div>
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap scripts -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-dpNbZhBPhyUlbF0t5z0P2pVDBR9VH8RSpd+qQrJQsG5fUp4y/G7bKdRxx6bWIUf7"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
        integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+Wy60S9Br5tYBau+AiScaF1/+2J94a9LStY"
        crossorigin="anonymous"></script>
</body>

</html>
