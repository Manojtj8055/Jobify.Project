<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Find by name</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f0f0f0; /* Bright background */
            color: #333;
            display: flex;
            flex-direction: column;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
        }

        h3 {
            background-color: #4CAF50;
            color: #fff;
            padding: 15px;
            text-align: center;
            margin: 0;
            width: 100%;
        }

        h1 {
            background-color: #fff;
            color: #333;
            padding: 20px;
            margin: 10px 0;
            text-align: center;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            width: 50vw; /* Adjusted width for better readability */
        }

        table {
            width: 50vw; /* Adjusted width for better readability */
            border-collapse: collapse;
            margin-top: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
        }

        th, td {
            padding: 15px;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }
    </style>
</head>
<body>
    <h3>Found Data...!</h3>
    <table border="30">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Brand</th>
            <th>Quantity</th>
        </tr>

        <tr>
            <td>${foundData.id}</td>
            <td>${foundData.name}</td>
            <td>${foundData.price}</td>
            <td>${foundData.brand}</td>
            <td>${foundData.quantity}</td>
        </tr>
    </table>
</body>
</html>
