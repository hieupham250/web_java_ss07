<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Chi tiết sản phẩm</h2>
<p><b>ID:</b> ${product.id}</p>
<p><b>Tên:</b> ${product.name}</p>
<p><b>Giá:</b> ${product.price}</p>
<p><b>Loại:</b>
  <c:forEach var="c" items="${categories}">
    <c:if test="${c.id == product.categoryId}">${c.name}</c:if>
  </c:forEach>
</p>
<a href="${pageContext.request.contextPath}/products2">Quay lại</a>
</body>
</html>