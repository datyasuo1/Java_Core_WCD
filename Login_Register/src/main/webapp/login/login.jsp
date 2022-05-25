<%@ page import="com.example.login_register.entity.Account" %>
<!DOCTYPE html>

<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%
        Account account = (Account) request.getAttribute("account");
        if(account == null){
            account = new Account();
        }
    %>
    <style>
        .error_code {
            color: #0d0d0d;
            font-size: 14px;
            border-top: 2px solid red;
            background: #f5f5f5;
            padding: 23px 30px 18px;
            margin-bottom: 50px;
        }
        .error_code ul {
            margin-left: 20px;
            margin-top: 10px;
        }
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
</head>
<body>

<form action="/login" method="post">
    <div class="container">
        <%
            if(account.getListErrors().size() > 0){
        %>
        <h6 class="error_code">

            Please enter information below
            <ul>
                <%for (int i = 0; i < account.getListErrors().size(); i++) {
                %>
                <li><%=account.getListErrors().get(i)%></li>
                <%
                    }%>
            </ul>
        </h6>
        <%}%>
        <h1>Login</h1>
        <p>Please fill in this form to create an account.</p>
        <hr>
        <label for="username"><b>User Name</b></label>
        <input type="text" placeholder="Enter username" name="username" id="username" required >

        <label for="psw"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" id="psw" required>
        <hr>
        <p>By creating an account you agree to our <a href="#">Terms & Privacy</a>.</p>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="container signin">
        <p>Already have an account? <a href="#">Sign in</a>.</p>
    </div>
</form>

</body>
</html>
