<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Database Operations</title>
</head>
<body>
    <%-- Establish database connection and perform operations --%>
    <%@ page import="java.sql.*" %>
    <%@ page import="javax.sql.*" %>
    <%
        // Get form data
        String action = request.getParameter("action");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Database operations
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Connect to the database
            String url = "jdbc:mysql://localhost:3360/test";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);

            // Perform action based on the requested operation
            if (action != null) {
                if (action.equals("insert")) {
                    // Insert data into the database
                    String insertQuery = "INSERT INTO users (id, name, email) VALUES (?, ?, ?)";
                    preparedStatement = connection.prepareStatement(insertQuery);
                    preparedStatement.setInt(1, Integer.parseInt(id));
                    preparedStatement.setString(2, name);
                    preparedStatement.setString(3, email);
                    int insertedRows = preparedStatement.executeUpdate();

                    // Check if the insertion was successful
                    if (insertedRows > 0) {
                        out.println("<p>Insertion successful</p>");
                    } else {
                        out.println("<p>Insertion failed</p>");
                    }
                } else if (action.equals("delete")) {
                    // Delete data from the database
                    String deleteQuery = "DELETE FROM users WHERE id = ?";
                    preparedStatement = connection.prepareStatement(deleteQuery);
                    preparedStatement.setInt(1, Integer.parseInt(id));
                    int deletedRows = preparedStatement.executeUpdate();

                    // Check if the deletion was successful
                    if (deletedRows > 0) {
                        out.println("<p>Deletion successful</p>");
                    } else {
                        out.println("<p>Deletion failed</p>");
                    }
                }
            }

            // Display existing data from the database
            String selectQuery = "SELECT * FROM users";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(selectQuery);

            out.println("<h2>Existing Data</h2>");
            out.println("<table>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String userName = resultSet.getString("name");
                String userEmail = resultSet.getString("email");
                out.println("<tr><td>" + userId + "</td><td>" + userName + "</td><td>" + userEmail + "</td></tr>");
            }
            out.println("</table>");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    %>
</body>
</html>
