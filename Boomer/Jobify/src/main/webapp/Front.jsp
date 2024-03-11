<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
    rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            color: #333;
            margin: 0;
            padding: 0;
        }

        header,
        footer {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: center;
        }

        header {
            text-align: left;
            font-size: 24px;
        }

        footer {
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        .main-container {
            display: flex;
            flex-wrap: wrap;
        }

        .image-section {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            background-color: #555;
            padding: 0px;
        }

        .login-section {
            flex: 2;
            padding: 20px;
        }

        img {
            max-width: 850px;
            height: 489px;
        }

        .login-form {
            max-width: 400px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-size: 14px;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 8px;
            font-size: 14px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #333;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        @media (max-width: 768px) {
            .main-container {
                flex-direction: column;
            }

            .image-section {
                order: 2;
            }

            .login-section {
                order: 1;
            }
        }
    </style>
</head>

<body>
    <header>
        <h1>JOBIFY.com</h1>
    </header>

    <div class="main-container">
        <div class="image-section">
            <img src="images/Job3.png"  alt="Logo" height="500" width="900">
        </div>

        <div class="login-section">
            <div class="login-form">
                <form action="jobify/save" method="post">
                    <div class="form-group">
                        <label for="username">Username :</label>
                        <input type="text" id="username" name="name" required>
                    </div>
                    <p>${notReading }</p>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password" required>
                    </div>
                    <p>${ passwordMissMatch}</p>    
                    <div class="form-group">
                        <label for="reenter-password">Re-Enter Password:</label>
                        <input type="password" id="reenter-password" name="confirmPassword" required>
                    </div>
                    <p>${ passwordMissMatch}</p>    
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="text" id="email" name="email" required>
                    </div>
                    <p>${ notChecking}</p>
                    <p>${emailFound}
                    
                     <div class="form-group">
                        <label for="phone">PhoneNumber:</label>
                        <input type="number" name="phoneNumber" required>
                    </div>
                    <p>${ numberMissmatch}</p>
                     <div >
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="accountType" id="inlineRadio1" value="jobseeker">
                            <label class="form-check-label" for="inlineRadio1">JobSeeker</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="accountType" id="inlineRadio2" value="jobprovider">
                            <label class="form-check-label" for="inlineRadio2">JobProvider</label>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <button type="submit">REGISTER</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <footer>
        <p>&copy; 2023 Your Website. All rights reserved.</p>
    </footer>
</body>

</html>
