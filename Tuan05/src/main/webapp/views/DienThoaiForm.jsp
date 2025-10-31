<%--
  Created by IntelliJ IDEA.
  User: WIN 11
  Date: 10/31/2025
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<form action="${pageContext.request.contextPath}/dienthoai-form" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Mã điện thoại:</td>
            <td><input type="text" name="madt" value="${dt.madt}" ${dt != null ? "readonly" : ""}></td>
        </tr>
        <tr>
            <td>Tên điện thoại:</td>
            <td><input type="text" name="tendt" value="${dt.tendt}"></td>
        </tr>
        <tr>
            <td>Năm sản xuất:</td>
            <td><input type="number" name="namsanxuat" value="${dt.namsanxuat}"></td>
        </tr>
        <tr>
            <td>Cấu hình:</td>
            <td><input type="text" name="cauhinh" value="${dt.cauhinh}"></td>
        </tr>
        <tr>
            <td>Nhà cung cấp:</td>
            <td>
                <select name="mancc">
                    <c:forEach var="ncc" items="${dsNCC}">
                        <option value="${ncc.mancc}" ${dt.mancc == ncc.mancc ? "selected" : ""}>
                                ${ncc.tennhacc}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Hình ảnh:</td>
            <td>
                <input type="file" name="hinhanh">
                <c:if test="${not empty dt.hinhanh}">
                    <br><img src="${pageContext.request.contextPath}/uploads/${dt.hinhanh}" width="120">
                </c:if>
            </td>
        </tr>
    </table>
    <input type="submit" value="${dt == null ? 'Thêm mới' : 'Cập nhật'}">
</form>

