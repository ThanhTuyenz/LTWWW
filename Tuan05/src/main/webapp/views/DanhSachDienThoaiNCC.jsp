<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách điện thoại</title>
</head>
<body>

<h1>${ncc.tennhacc} - ${ncc.diachi}</h1>

<a href="${pageContext.request.contextPath}/dienthoai-form?mancc=${ncc.mancc}">➕ Thêm điện thoại</a>
<br><br>

<c:if test="${empty dsDT}">
    <p><i>Không có điện thoại nào.</i></p>
</c:if>

<c:if test="${not empty dsDT}">
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>Hình ảnh</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Năm SX</th>
            <th>Cấu hình</th>
            <th>Thao tác</th>
        </tr>

        <c:forEach var="dt" items="${dsDT}">
            <tr>
                <td>
                    <c:if test="${not empty dt.hinhanh}">
                        <img src="${pageContext.request.contextPath}/uploads/${dt.hinhanh}" width="100">
                    </c:if>
                </td>
                <td>${dt.madt}</td>
                <td>${dt.tendt}</td>
                <td>${dt.namsanxuat}</td>
                <td>${dt.cauhinh}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/dienthoai-form?madt=${dt.madt}">Sửa</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<br>
<a href="${pageContext.request.contextPath}/danh-sach">Quay lại danh sách NCC</a>

</body>
</html>
