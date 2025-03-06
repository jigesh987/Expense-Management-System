<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-5">
        <h2>Login to Expense Tracker</h2>

        <form action="login" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Username</label>
                <input type="text" class="form-control" id="username" name="username" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>

        <hr>

        <!-- Register Button -->
        <p class="mt-3">Don't have an account? 
            <a href="register" class="btn btn-success btn-sm">Register Here</a>
        </p>
    </div>
	<script type="text/javascript">
	    (function () {
	        window.history.forward();
	    })();
		    
	    window.onunload = function () {
	        null;
	    };
	</script>

</body>
</html>




