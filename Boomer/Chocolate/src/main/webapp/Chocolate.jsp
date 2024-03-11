<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chocolate Form</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin: 10px;
        }

        input[type="text"],
        input[type="number"] {
            width: calc(100% - 20px); /* Adjusted width to account for padding */
            padding: 10px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
            display: block;
        }

        button {
            background-color: #4CAF50;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            width: calc(100% - 20px);
            display: block;
            margin-top: 10px;
        }

        button:hover {
            background-color: #45a049;
        }

        h2 {
            color: #333;
            margin-top: 20px;
            text-align: center;
        }

        p {
            color: #777;
        }
    </style>
</head>
<body>

	
    <form action="chocolate/save" method="post">
        <input type="text" name="name" placeholder="Name" required>
        <input type="number" name="price" placeholder="Price" required>
        <input type="text" name="brand" placeholder="Brand" required>
        <input type="number" name="quantity" placeholder="Quantity" required>
        <button type="submit">Submit</button>
    </form>

    ${exists}
    
    <br>

    <form action="chocolate/find" method="get">
        <input type="number" name="id" placeholder="Id" required>
        <button type="submit">Find</button>
    </form>

    <h2>${dto}</h2>

    <form action="chocolate/read" method="get">
        <button type="submit">Read All</button>
    </form>

    <form action="chocolate/findByName" method="get">
        <input type="text" name="name" placeholder="Chocolate Name" required>
        <button type="submit">Search</button>
    </form>

    <h2>${foundData} ${nameValid}</h2>

    <form action="chocolate/update" method="post">
        <input type="number" name="quantity" placeholder="Quantity" required>
        <input type="text" name="name" placeholder="Chocolate Name" required>
        <button type="submit">Update</button>
    </form>

    <h2>${update}</h2>

    <form action="chocolate/delete" method="get">
        <input type="number" name="id" placeholder="ID" required>
        <button type="submit">Delete</button>
    </form>

    <h2>${delete}</h2>

</body>
</html>
