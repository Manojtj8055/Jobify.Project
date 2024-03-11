<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
    <title>JobProvider</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
    <style>
        .header h1 {
            margin-top: 0; /* Add this to remove the top margin */
        }
        body {
            background: #e0e5ec;
        }
        h1 {
            position: relative;
            text-align: center;
            color: #353535;
            font-size: 50px;
            font-family: "Cormorant Garamond", serif;
        }

        p {
            font-family: 'Lato', sans-serif;
            font-weight: 300;
            text-align: center;
            font-size: 18px;
            color: #676767;
        }
        .frame {
            width: 90%;
            margin: 40px auto;
            text-align: center;
        }
        button {
            margin: 20px;
        }
        .custom-btn {
            width: 130px;
            height: 40px;
            color: #fff;
            border-radius: 5px;
            padding: 10px 25px;
            font-family: 'Lato', sans-serif;
            font-weight: 500;
            background: linear-gradient(45deg, #1fd1f9, #b621fe);
            cursor: pointer;
            transition: all 0.3s ease;
            position: absolute;
            right: 388px;
            top: 315px;
            box-shadow: inset 2px 2px 2px 0px rgba(255, 255, 255, .5), 7px 7px 20px 0px rgba(0, 0, 0, .1), 4px 4px 5px 0px rgba(0, 0, 0, .1);
            outline: none;
        }

        .btn-9 {
            border: none;
            transition: all 0.3s ease;
            overflow: hidden;
        }
        .btn-9:after {
            position: absolute;
            content: " ";
            z-index: -1;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: #1fd1f9;
            background-image: linear-gradient(315deg, #1fd1f9 0%, #b621fe 74%);
            transition: all 0.3s ease;
        }
        .btn-9:hover {
            background: transparent;
            box-shadow: 4px 4px 6px 0 rgba(255, 255, 255, .5), -4px -4px 6px 0 rgba(116, 125, 136, .2), inset -4px -4px 6px 0 rgba(255, 255, 255, .5), inset 4px 4px 6px 0 rgba(116, 125, 136, .3);
            color: #fff;
        }
        .btn-9:hover:after {
            -webkit-transform: scale(2) rotate(180deg);
            transform: scale(2) rotate(180deg);
            box-shadow: 4px 4px 6px 0 rgba(255, 255, 255, .5), -4px -4px 6px 0 rgba(116, 125, 136, .2), inset -4px -4px 6px 0 rgba(255, 255, 255, .5), inset 4px 4px 6px 0 rgba(116, 125, 136, .3);
        }
    </style>
</head>
<header>
    <link href="https://fonts.googleapis.com/css2?family=Lato&display=swap" rel="stylesheet">
</header>
<body>
    <div class="header">
        <h1>JOBIFY.com</h1>
        <!-- Add any additional header content as needed -->
    </div>
    <div class="limiter">
        <div class="container-login100">
            <div class="wrap-login100">
                
                <form action="jobSave" method="post">
                 
                    <span class="login100-form-title">
                        Job Description
                    </span>
                     <div class="wrap-input100 validate-input">
                        <input class="input100" type="hidden" name="id" value ="${jobRegisterDto.id}">
                    </div>
                    <div class="wrap-input100 validate-input">
                        <input class="input100" type="hidden" name="jobProviderEmail" value="<%=session.getAttribute("loggedInUserEmail")  %>">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Valid company is required">
                        <input class="input100" type="text" name="company" placeholder="Company Name" value="${jobRegisterDto.company}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Role is required">
                        <input class="input100" type="text" name="role" placeholder="Job Role" value="${jobRegisterDto.role}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="experience is required">
                        <input class="input100" type="number" name="experience" placeholder="Experience" value="${jobRegisterDto.experience}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="location is required">
                        <input class="input100" type="text" name="location" placeholder="Location of JOB" value="${jobRegisterDto.location}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Salary is required">
                        <input class="input100" type="number" name="salary" placeholder="CTC -per Annum" value="${jobRegisterDto.salary}">
                    </div>
                    <div class="wrap-input100 validate-input" data-validate="Password is required">
                        <input class="input100" type="text" name="skills" placeholder="Skills Required for Job" value="${jobRegisterDto.skills}">
                    </div>
                    <div class="container-login100-form-btn">
                        <button class="login100-form-btn" type="submit" value="">${editMode ? 'Update' : 'Register'}</button>
                        
                        <p class="text-danger small">${jobPosted}</p>
                        <p class="text-danger small">${jobPostedNew}</p>
                        <p class="text-danger small">${jobNotPosted}</p>
                    </div>
                
                </form>
                <button class="custom-btn btn-9" onclick="location.href='jobDisplay'" formaction="jobDisplay">Jobs Posted..!</button>
            </div>
        </div>
    </div>
    <!--===============================================================================================-->
    <script src="vendor/jquery/jquery-3.2.1.min.js"></script>
    <!--===============================================================================================-->
    <!--===============================================================================================-->
    <!--===============================================================================================-->
    <script src="js/main.js"></script>
</body>
</html>
