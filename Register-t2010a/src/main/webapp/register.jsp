<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register Account</title>
    <link href="css.css" rel="stylesheet">

</head>
<body>
<form action="/register" method="post">
    <div class="imgcontainer">
        <img src="https://scr.vn/wp-content/uploads/2020/07/AVT-M%C3%88O-NAM-1024x1024.jpg" alt="Avatar" class="avatar" width="150" height="auto">
    </div>

    <div class="container">
        <label ><b>Username</b></label>
        <input type="text" placeholder="Enter Username" name="username" required>

        <label ><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>

        <button type="submit">Login</button>
        <button type="reset">Reset</button>
        <label>
            <input type="checkbox" checked="checked" name="remember"> Remember me
        </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
        <button type="button" class="cancelbtn">Cancel</button>
        <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
</form></body>
</html>