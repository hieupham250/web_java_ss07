<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Danh sách khóa học</title></head>
<body>
<h2>Danh sách khóa học</h2>
<a href="${pageContext.request.contextPath}/courses/add">Thêm khóa học</a>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Mô tả</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="course" items="${courses}">
    <tr>
      <td>${course.id}</td>
      <td>${course.name}</td>
      <td>${course.description}</td>
      <td>
        <a href="${pageContext.request.contextPath}/courses/delete/${course.id}">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>