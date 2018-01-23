<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="POST" action="/user" modelAttribute="userForm">
	<table>
		<tr>
			<td>Роль</td>
			<td><form:input path="role" type="text" /></td>
		</tr>
		<tr>
			<td>Имя</td>
			<td><form:input path="name" type="text" /></td>
		</tr>
		<tr>
			<td>Фамилия</td>
			<td><form:input path="last_name" type="text" /></td>
		</tr>
		<tr>
			<td>День Рождения</td>
			<td><form:input path="birthday" type="text" /></td>
		</tr>
		<tr>
			<td>Адресс</td>
			<td><form:input path="address" type="text" /></td>
		</tr>
		<tr>
			<td>Номер телефона</td>
			<td><form:input path="phone_number" type="text" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><form:input path="email" type="text" /></td>
		</tr>
		<tr>
			<td>Статус</td>
			<td><form:input path="deleted" type="text" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить" /></td>
		</tr>
	</table>
</form:form>
