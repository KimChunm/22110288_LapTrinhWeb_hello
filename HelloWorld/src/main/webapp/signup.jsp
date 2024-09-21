
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <%-- Bootstrap 4.5.2 CSS --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .signup-container {
            margin-top: 80px;
            max-width: 400px;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        .signup-container h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-signup {
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
        .login-link {
            text-align: center;
            margin-top: 10px;
        }
        .login-link a {
            text-decoration: none;
        }
        .login-link a:hover {
            text-decoration: underline;
        }
        .error {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="signup-container">
        <form name="signupForm" action="http://localhost:8080/LTWEB/signup" method="post" id="signupForm">
            <h2>Sign Up</h2>

            <div class="form-group">
                <label>Username</label>
                <input type="text" class="form-control" placeholder="Enter Username" name="username" required>
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" class="form-control" placeholder="Enter Email" name="email" required>
            </div>

            <div class="form-group">
                <label>Password</label>
                <input type="password" id="password" class="form-control" placeholder="Enter Password" name="password" required>
            </div>

            <div class="form-group">
                <label>Repeat Password</label>
                <input type="password" id="repeatPassword" class="form-control" placeholder="Repeat Password" name="psw-repeat" required>
            </div>

            <div id="error-message" class="alert alert-danger" role="alert" style="display:none;"></div>

            <button type="submit" class="btn btn-primary btn-signup">Sign Up</button>

            <div class="login-link">
                Already have an account? <a href="./login">Login here</a>
            </div>
        </form>
    </div>
</div>

<script>
    document.getElementById('signupForm').addEventListener('submit', function(event) {
        const password = document.getElementById('password').value;
        const repeatPassword = document.getElementById('repeatPassword').value;
        const errorMessageDiv = document.getElementById('error-message');

        if (password !== repeatPassword) {
            event.preventDefault(); // Ngăn không cho form submit
            errorMessageDiv.textContent = 'Passwords do not match!';
            errorMessageDiv.style.display = 'block'; // Hiển thị lỗi
        } else {
            errorMessageDiv.style.display = 'none'; // Ẩn lỗi nếu khớp
        }
    });
</script>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
