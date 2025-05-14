<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Danh sách sản phẩm</h2>

<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>

<form method="get" action="${pageContext.request.contextPath}/products">
    <input type="text" name="keyword" value="${keyword}" placeholder="Tìm kiếm..."/>
    <input type="submit" value="Tìm"/>
</form>

<a href="${pageContext.request.contextPath}/products2/add">Thêm sản phẩm</a>

<table border="1">
    <tr><th>ID</th><th>Tên</th><th>Giá</th><th>Loại</th><th>Hành động</th></tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td><a href="${pageContext.request.contextPath}/products/${p.id}">${p.name}</a></td>
            <td>${p.price}</td>
            <td>
                <c:forEach var="c" items="${categories}">
                    <c:if test="${c.id == p.categoryId}">${c.name}</c:if>
                </c:forEach>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/products2/edit/${p.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/products2/delete/${p.id}">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>