<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="user" value="${requestScope.user}" />

<table>
	<tr>
		<td>ID</td>
		<td><c:out value="${user.id}" /></td>
	</tr>
	<tr>
		<td>Роль</td>
		<td><c:out value="${user.role}" /></td>
	</tr>
	<tr>
		<td>Имя</td>
		<td><c:out value="${user.name}" /></td>
	</tr>
	<tr>
		<td>Фамилия</td>
		<td><c:out value="${user.last_name}" /></td>
	</tr>
	<tr>
		<td>День рождения</td>
		<td><c:out value="${user.birthday}" /></td>
	</tr>
	<tr>
		<td>Адресс</td>
		<td><c:out value="${user.address}" /></td>
	</tr>
	<tr>
		<td>Номер телефона</td>
		<td><c:out value="${user.phone_number}" /></td>
	</tr>
	<tr>
		<td>Email</td>
		<td><c:out value="${user.email}" /></td>
	</tr>
	<tr>
		<td>Статус</td>
		<td><c:out value="${user.deleted}" /></td>
	</tr>
</table>
