<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, model.Khoa" %>
<html>
<head>
    <title>Danh sách Bệnh nhân</title>
</head>
<body>

<h3>Tìm kiếm bệnh nhân</h3>
<form method="get" action="benhnhan">
    <input type="hidden" name="action" value="search">
    <input type="text" name="name" placeholder="Nhập tên bệnh nhân..." required>
    <input type="submit" value="Tìm">
</form>

<h3>Xem theo khoa điều trị</h3>
<form method="get" action="benhnhan">
    <input type="hidden" name="action" value="byKhoa">

    <select name="maKhoa" required>
        <option value="">-- Chọn khoa --</option>
        <%
            // Lấy danh sách khoa từ request (được set trong Servlet)
            List<Khoa> listKhoa = (List<Khoa>) request.getAttribute("listKhoa");
            if (listKhoa != null) {
                for (Khoa k : listKhoa) {
        %>
        <option value="<%=k.getMaKhoa()%>"><%=k.getTenKhoa()%></option>
        <%
                }
            }
        %>
    </select>
    <input type="submit" value="Xem">
</form>

<h3>Thêm bệnh nhân mới</h3>
<form method="post" action="benhnhan" onsubmit="return validateForm()">
    <input type="hidden" name="action" value="add">

    Mã BN: <input type="number" name="maBn" required><br>
    Họ tên: <input type="text" name="hoTen" required><br>
    Ngày nhập viện: <input type="date" name="ngayNhapVien" required><br>
    Chẩn đoán: <input type="text" name="chuanDoan" required><br>
    Khoa điều trị:
    <select name="maKhoa" required>
        <option value="">-- Chọn khoa --</option>
        <%
            java.util.List<model.Khoa> dsKhoa =
                    (java.util.List<model.Khoa>) request.getAttribute("listKhoa");
            if (dsKhoa != null) {
                for (model.Khoa k : dsKhoa) {
        %>
        <option value="<%= k.getMaKhoa() %>"><%= k.getTenKhoa() %></option>
        <%
                }
            }
        %>
    </select><br>
    <input type="submit" value="Thêm mới">
</form>

<script>
    function validateForm() {
        const inputs = document.querySelectorAll("input[required], select[required]");
        for (let input of inputs) {
            if (!input.value.trim()) {
                alert("Vui lòng nhập đầy đủ thông tin!");
                return false;
            }
        }
        return true;
    }
</script>

<hr>
<h2>Danh sách Bệnh nhân</h2>
<table border="1" cellpadding="5">
    <tr>
        <th>Mã BN</th>
        <th>Họ tên</th>
        <th>Ngày nhập viện</th>
        <th>Chẩn đoán</th>
        <th>Khoa điều trị</th>
    </tr>
    <%
        List<model.BenhNhan> list =
                (List<model.BenhNhan>) request.getAttribute("listBenhNhan");
        if (list != null && !list.isEmpty()) {
            for (model.BenhNhan bn : list) {
    %>
    <tr>
        <td><%= bn.getMaBn() %></td>
        <td><%= bn.getHoTen() %></td>
        <td><%= bn.getNgayNhapVien() %></td>
        <td><%= bn.getChuanDoan() %></td>
        <td><%= bn.getMaKhoa() %></td>
    </tr>
    <%
        }
    } else {
    %>
    <tr><td colspan="5">Không có dữ liệu!</td></tr>
    <% } %>
</table>
</body>
</html>
