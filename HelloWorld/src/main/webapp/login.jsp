
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <%-- Bootstrap 4.5.2 CSS --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .login-container {
            margin-top: 80px;
            max-width: 400px;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .login-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-login {
            width: 100%;
            margin-top: 15px;
        }
        .cancelbtn {
            background-color: #dc3545;
            color: white;
        }
        .cancelbtn:hover {
            background-color: #c82333;
        }
        .psw {
            margin-top: 10px;
            text-align: right;
        }
        .psw a {
            text-decoration: none;
        }
        .psw a:hover {
            text-decoration: underline;
        }
        .signup-link {
            text-align: center;
            margin-top: 10px;
        }
        .signup-link a {
            text-decoration: none;
        }
        .signup-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="login-container">

        <form action="http://localhost:8080/LTWEB/login" method="post">
            <c:if test="${alert != null}">
                <div class="alert alert-danger" role="alert">
                        ${alert}
                </div>
            </c:if>

            <h2>Login</h2>

            <div class="form-group">
                <label>Username</label>
                <input type="text" class="form-control" placeholder="Enter Username" name="uname" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" class="form-control" placeholder="Enter Password" name="psw" required>
            </div>

            <div class="form-group form-check">
                <input class="form-check-input" type="checkbox" name="remember" checked>
                <label class="form-check-label">Remember me</label>
            </div>

            <button type="submit" class="btn btn-primary btn-login">Login</button>
            <button type="button" class="btn cancelbtn btn-login">Cancel</button>

            <div class="psw">
                <span><a href="http://localhost:8080/LTWEB/forgotpassword">Forgot password?</a></span>
            </div>

            <div class="signup-link">
                Don't have an account? <a href="http://localhost:8080/LTWEB/signup">Sign Up here</a>
            </div>
        </form>
    </div>
</div>

</body>
</html>
