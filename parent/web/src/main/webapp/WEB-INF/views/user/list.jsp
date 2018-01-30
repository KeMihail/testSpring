<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="margin: 10px;">
	<h4>List of Users</h4>
	<table style="width: 600px" class="reference">
	
		<tbody>
			<tr>
				<th>Id</th>
				<th>Role</th>
				<th>Name</th>
				<th>LastName</th>
				<th>Birthday</th>
				<th>Address</th>
				<th>PhoneNumber</th>
				<th>Email</th>
			</tr>
			<c:forEach var="user" items="${requestScope.users}"
				varStatus="loopCounter">
				<tr>
					<td><c:out value="${user.id}" /></td>
					<td><c:out value="${user.role}" /></td>
					<td><c:out value="${user.name}" /></td>
					<td><c:out value="${user.lastName}" /></td>
					<td><c:out value="${user.birthday}" /></td>
					<td><c:out value="${user.address}" /></td>
					<td><c:out value="${user.phoneNumber}" /></td>
					<td><c:out value="${user.email}" /></td>

					<td><a href="/user/${user.id}">Подробности¸</a>|<a
						href="/user/${user.id}/edit">Изменить</a>|<a
						href="/user/${user.id}/delete">Удалить</a></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/user/add">Создать</a>
</div>