<%--
  Created by IntelliJ IDEA.
  User: Student
  Date: 9/7/2025
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@page import="fit.se.bai1.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result submit</title>
</head>
<body>
    <%
      Student student = new Student();
      student = (Student) request.getAttribute("student");
      out.println(
              "First Name: " + student.getFirstName() + "<br>" +
                "Last Name: " + student.getLastName() + "<br>" + 
                      "Email: " + student.getEmail() + "<br>" +
                      "Gender: " + student.getGenDer() + "<br>" +
                      "Birth Date: " + student.getDateOfBirth()
      );
    %>
</body>
</html>
