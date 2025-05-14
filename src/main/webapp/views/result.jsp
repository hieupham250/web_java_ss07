<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả góp ý</title>
</head>
<body>
<h2>Thông tin góp ý</h2>
<table border="1">
    <tr><th>Họ và tên</th><td>${feedback.name}</td></tr>
    <tr><th>Số điện thoại</th><td>${feedback.phone}</td></tr>
    <tr><th>Địa chỉ</th><td>${feedback.address}</td></tr>
    <tr><th>Nội dung góp ý</th><td>${feedback.content}</td></tr>
</table>
<br/>
<a href="list">Xem danh sách góp ý</a>
</body>
</html>

