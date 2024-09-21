
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Forgot Password</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .forgot-password-card {
      max-width: 450px;
      margin: 50px auto;
      background-color: #fff;
      border-radius: 10px;
      padding: 30px;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }
    .forgot-password-card h3 {
      text-align: center;
      margin-bottom: 20px;
    }
    .form-label {
      font-weight: bold;
    }
    .btn-reset {
      background-color: #007bff;
      color: white;
    }
    .btn-reset:hover {
      background-color: #0056b3;
    }
    .back-login-link {
      text-align: center;
      margin-top: 20px;
    }
    .back-login-link a {
      color: #dc3545;
      text-decoration: none;
    }
    .back-login-link a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>

<div class="forgot-password-card">

  <h3>Forgot Password</h3>

  <form action="http://localhost:8080/LTWEB/forgotpassword" method="post" id="resetPasswordForm">

    <!-- Alert if needed -->
    <div id="error-message" class="alert alert-danger" role="alert" style="display:none;"></div>

    <!-- Username input -->
    <div class="mb-3">
      <label for="username" class="form-label">Username</label>
      <input type="text" id="username" name="username" class="form-control" placeholder="Enter your username" required>
    </div>

    <!-- Email input -->
    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" id="email" name="email" class="form-control" placeholder="Enter your registered email" required>
    </div>

    <!-- New Password input -->
    <div class="mb-3">
      <label for="new_psw" class="form-label">New Password</label>
      <input type="password" id="new_psw" name="new_psw" class="form-control" placeholder="Enter new password" required>
    </div>

    <!-- Confirm New Password input -->
    <div class="mb-3">
      <label for="confirm_new_psw" class="form-label">Confirm New Password</label>
      <input type="password" id="confirm_new_psw" name="confirm_new_psw" class="form-control" placeholder="Confirm new password" required>
    </div>

    <!-- Submit button -->
    <div class="d-grid">
      <button type="submit" class="btn btn-reset btn-lg">Reset Password</button>
    </div>

    <!-- Back to login link -->
    <div class="back-login-link">
      <p class="small">Back to <a href="./login">Login</a></p>
    </div>

  </form>

</div>

<script>
  document.getElementById('resetPasswordForm').addEventListener('submit', function(event) {
    const newPassword = document.getElementById('new_psw').value;
    const confirmPassword = document.getElementById('confirm_new_psw').value;
    const errorMessageDiv = document.getElementById('error-message');

    if (newPassword !== confirmPassword) {
      event.preventDefault(); // Ngăn không cho form submit
      errorMessageDiv.textContent = 'Confirm New Password does not match with New Password.';
      errorMessageDiv.style.display = 'block'; // Hiển thị lỗi
    } else {
      errorMessageDiv.style.display = 'none'; // Ẩn lỗi nếu khớp
    }
  });
</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
