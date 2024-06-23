<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    
    <title>Display page for Seeker</title>
    
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
        <a class="navbar-brand" href="#">Jobify.com</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <br>
                           	  <p class="text-danger small">${Success}</p>

        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <!-- Add any additional navigation links as needed -->
                <li class="nav-item">
                </li>
            </ul>
        </div>
    </nav>
    
    <br>
    
    <h1>Welcome To Jobify You can search for Jobs here..</h1>
	<button type="submit" onclick = "location.href='activeJobs'" formaction="activeJobs" formmethod="GET">New Jobs..</button>
	
	
	
	
	
<script>

	let x = new XMLHttpRequest();
	
	let url = 'activeJobs';
	x.open("GET", url , true);
	
	x.onreadystatechange = function() {
		if(this.readyState == 4 && this.status == 200){
			console.log(this.responseText);
		}
	}
	x.send();

</script>

</body>
</html>
