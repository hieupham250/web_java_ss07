<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Thêm khóa học</title></head>
<body>
<h2>Thêm khóa học</h2>
<form action="${pageContext.request.contextPath}/courses/add" method="post">
  Tên: <input type="text" name="name" /><br/>
  Mô tả: <input type="text" name="description" /><br/>
  <input type="submit" value="Thêm" />
</form>
</body>
</html>