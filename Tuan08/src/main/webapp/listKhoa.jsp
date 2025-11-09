<%--
  Created by IntelliJ IDEA.
  User: WIN 11
  Date: 10/25/2025
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Danh sách Khoa</title>
</head>
<body>
<h2>Danh sách Khoa</h2>
<table border="1">
  <tr>
    <th>Mã Khoa</th>
    <th>Tên Khoa</th>
    <th>Trưởng Khoa</th>
    <th>Mô tả</th>
  </tr>
  <%
    java.util.List<model.Khoa> list =
            (java.util.List<model.Khoa>) request.getAttribute("listKhoa");
    if (list != null) {
      for (model.Khoa k : list) {
  %>
  <tr>
    <td><%= k.getMaKhoa() %></td>
    <td><%= k.getTenKhoa() %></td>
    <td><%= k.getTruongKhoa() %></td>
    <td><%= k.getMoTa() %></td>
  </tr>
  <%
    }
  } else {
  %>
  <tr><td colspan="4">Không có dữ liệu!</td></tr>
  <% } %>
</table>
</body>
</html>

