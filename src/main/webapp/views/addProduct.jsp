<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Thêm sản phẩm</h2>
<form action="${pageContext.request.contextPath}/products2/save" method="post">
    <input type="hidden" name="id" value="0"/>
    Tên: <input type="text" name="name" value="" /><br/>
    Giá: <input type="text" name="price" value="" /><br/>
    Loại:
    <select name="categoryId">
        <c:forEach var="c" items="${categories}">
            <option value="${c.id}">${c.name}</option>
        </c:forEach>
    </select><br/>
    <input type="submit" value="Lưu"/>
</form>
<a href="${pageContext.request.contextPath}/products2">Quay lại</a>
</body>
</html>