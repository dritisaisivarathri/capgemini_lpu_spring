<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h2>All Employees</h2>

<!-- DELETE FORM -->
<form action="delete-selected" method="post">

<table border="1">

<tr>
    <th>Select</th>
    <th>Name</th>
    <th>Email</th>
    <th>Role</th>
    <th>Salary</th>
</tr>

<c:forEach var="e" items="${employees}">
<tr>

<td>
<input type="radio" name="selectedEmails" value="${e.email}">
</td>

<td>${e.name}</td>
<td>${e.email}</td>
<td>${e.role}</td>
<td>${e.salary}</td>

</tr>
</c:forEach>

</table>

<br>

<button type="submit" formaction="delete-selected">Delete Selected</button>

<button type="submit" formaction="update-selected">Update Selected</button>

</form>

</body>
</html>