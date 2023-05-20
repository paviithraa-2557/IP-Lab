<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Travel Login</title>
</head>
<body>
    <%!
        boolean isValidCredentials(String uname, String pass) {
            // Username should be alphanumeric and between 5 to 10 characters
            boolean isValidUsername = uname.matches("[a-zA-Z0-9_]{5,10}");

            // Password should be at least 8 characters, contain at least one lowercase letter, one uppercase letter, and one digit
            boolean isValidPassword = pass.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$");
            
            return isValidUsername && isValidPassword;
        }
    %>

    <%
        // Get form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username != null && password != null) {
            if (isValidCredentials(username, password)) {
                // Display user details
                out.println("<section>");
                out.println("<h2>Welcome, " + username + "!</h2>");
                out.println("<p>Your user ID: 12345</p>");
                out.println("<p>Email: " + username + "@travelworld.com</p>");
                out.println("</section>");
            } else {
                // Invalid credentials, display error message
                out.println("<section>");
                out.println("<p>Invalid username or password. Please try again.</p>");
                out.println("</section>");
            }
        } 
    %>

</body>
</html>
