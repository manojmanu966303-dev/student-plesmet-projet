<%@ page import="com.placement.model.Student" %>

<!DOCTYPE html>
<html>

<head>
    <title>Student Dashboard</title>
</head>

<body>

<%

Student student =
    (Student) session.getAttribute("student");

if (student == null) {

    response.sendRedirect("login.jsp");

    return;
}

%>

<h1>Welcome, <%= student.getName() %>!</h1>

<p>
    Student ID:
    <%= student.getId() %>
</p>

<p>
    Email:
    <%= student.getEmail() %>
</p>

<p>
    CGPA:
    <%= student.getCgpa() %>
</p>

<p>
    Branch:
    <%= student.getBranch() %>
</p>

<a href="logout">Logout</a>

</body>

</html>