<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h2>Chỉnh sửa sản phẩm</h2>
<form action="${pageContext.request.contextPath}/products2/update" method="post">
  <input type="hidden" name="id" value="${product.id}"/>
  Tên: <input type="text" name="name" value="${product.name}" /><br/>
  Giá: <input type="text" name="price" value="${product.price}" /><br/>
  Loại:
  <select name="categoryId">
    <c:forEach var="c" items="${categories}">
      <option value="${c.id}" <c:if test="${c.id == product.categoryId}">selected</c:if>>${c.name}</option>
    </c:forEach>
  </select><br/>
  <input type="submit" value="Cập nhật"/>
</form>
<a href="${pageContext.request.contextPath}/products2">Quay lại</a>
</body>
</html>