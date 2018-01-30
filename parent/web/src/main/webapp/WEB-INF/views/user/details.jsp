<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="user" value="${requestScope.user}" />

<table>
	<tr>
		<td>Роль</td>
		<td><c:out value="${user.role}" /></td>
	</tr>
	<tr>
		<td>Имя</td>
		<td><c:out value="${user.name}" /></td>
	</tr>
	<tr>
		<td>Фамилия</td>
		<td><c:out value="${user.lastName}" /></td>
	</tr>
	<tr>
		<td>День Рождения</td>
		<td><c:out value="${user.birthday}" /></td>
	</tr>
	<tr>
		<td>Адресс</td>
		<td><c:out value="${user.address}" /></td>
	</tr>
	<tr>
		<td>Номер телефона</td>
		<td><c:out value="${user.phoneNumber}" /></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><c:out value="${user.email}" /></td>
	</tr>
</table>
