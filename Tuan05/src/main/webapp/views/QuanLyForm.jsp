<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách nhà cung cấp</title>
</head>
<body>

<h1>Danh sách nhà cung cấp</h1>

<c:if test="${empty dsNCC}">
    <p><i>Không có nhà cung cấp nào trong cơ sở dữ liệu.</i></p>
</c:if>

<c:if test="${not empty dsNCC}">
    <ul>
        <c:forEach var="ncc" items="${dsNCC}">
            <li>
                <a href="${pageContext.request.contextPath}/danh-sach?mancc=${ncc.mancc}">
                        ${ncc.tennhacc} - ${ncc.diachi}
                </a>
            </li>
        </c:forEach>
    </ul>
</c:if>

</body>
</html>
