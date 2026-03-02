<html>
<body>

<h2>Update Employee</h2>

<form action="update-employee" method="post">

Email:<br>
<input type="text" name="email" value="${employee.email}" readonly>
<br><br>

Name:<br>
<input type="text" name="name" value="${employee.name}">
<br><br>

Role:<br>
<input type="text" name="role" value="${employee.role}">
<br><br>

Salary:<br>
<input type="text" name="salary" value="${employee.salary}">
<br><br>

<button type="submit">Update</button>

</form>

</body>
</html>