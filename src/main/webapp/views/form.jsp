<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Form Góp Ý</h2>

<c:if test="${not empty errors}">
    <ul style="color:red;">
        <c:forEach var="err" items="${errors}">
            <li>${err}</li>
        </c:forEach>
    </ul>
</c:if>

<form action="${pageContext.request.contextPath}/submit" method="post">
    Họ và tên: <input type="text" name="name" /><br/><br/>
    Số điện thoại: <input type="text" name="phone" /><br/><br/>
    Địa chỉ: <input type="text" name="address" /><br/><br/>
    Nội dung góp ý:<br/>
    <textarea name="content" rows="5" cols="40"></textarea><br/><br/>
    <input type="submit" value="Gửi góp ý" />
</form>
</body>
</html>