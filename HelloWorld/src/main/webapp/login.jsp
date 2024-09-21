<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%-- Bootstrap 5 --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <style>
        body {
            background-color: #1c1f2e; /* Dark blue background */
            font-family: 'Roboto', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .login-container {
            background-color: #2a2e45; /* Dark blue-gray background */
            padding: 40px;
            border-radius: 15px;
            max-width: 400px;
            width: 100%;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.5);
            text-align: center;
        }
        .login-container h2 {
            color: #fdd835; /* Bright yellow */
            font-weight: bold;
            margin-bottom: 25px;
            text-transform: uppercase;
        }
        .form-group label {
            color: #b0bec5; /* Light gray text */
            font-weight: 600;
        }
        .form-control {
            background-color: #1e2235; /* Dark input background */
            border: none;
            color: #f5f5f5; /* White text */
            padding: 12px;
            border-radius: 10px;
            margin-bottom: 15px;
            transition: background-color 0.3s ease;
        }
        .form-control:focus {
            background-color: #333a56; /* Lighter on focus */
            outline: none;
            box-shadow: none;
        }
        .btn-login {
            background-color: #fdd835;
            color: #000;
            font-weight: bold;
            border-radius: 25px;
            padding: 12px;
            width: 100%;
            transition: background-color 0.3s ease;
        }
        .btn-login:hover {
            background-color: #ffc400;
            color: #1c1f2e;
        }
        .cancelbtn {
            background-color: transparent;
            color: #fdd835;
            border: 1px solid #fdd835;
            border-radius: 25px;
            padding: 12px;
            width: 100%;
            margin-top: 10px;
            transition: background-color 0.3s ease, color 0.3s ease;
        }
        .cancelbtn:hover {
            background-color: #fdd835;
            color: #1c1f2e;
        }
        .psw {
            color: #fdd835;
            margin-top: 15px;
            font-size: 0.9em;
        }
        .psw a {
            color: #fdd835;
            text-decoration: none;
        }
        .psw a:hover {
            text-decoration: underline;
        }
        .signup-link {
            color: #b0bec5;
            margin-top: 20px;
            font-size: 0.9em;
        }
        .signup-link a {
            color: #fdd835;
            text-decoration: none;
        }
        .signup-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="login-container">
    <form action="http://localhost:8080/LTWEB/login" method="post">
        <c:if test="${alert != null}">
            <div class="alert alert-danger" role="alert">
                ${alert}
            </div>
        </c:if>

        <h2>Login</h2>

        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" class="form-control" placeholder="Enter Username" name="uname" required>
        </div>

        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" class="form-control" placeholder="Enter Password" name="psw" required>
        </div>

        <div class="form-group form-check text-start">
            <input class="form-check-input" type="checkbox" name="remember" checked>
            <label class="form-check-label" for="remember"><i class="fas fa-check-circle"></i> Remember me</label>
        </div>

        <button type="submit" class="btn btn-login">Login</button>
        <a href="javascript:history.back()" class="btn cancelbtn">Cancel</a>

        <div class="psw">
            <span><a href="http://localhost:8080/LTWEB/forgotpassword"><i class="fas fa-lock"></i> Forgot password?</a></span>
        </div>

        <div class="signup-link">
            Don't have an account? <a href="http://localhost:8080/LTWEB/signup">Sign Up here</a>
        </div>
    </form>
</div>

</body>
</html>
