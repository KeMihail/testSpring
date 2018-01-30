<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="brand" value="${requestScope.brand}" />

<table>
	<tr>
		<td>ID</td>
		<td><c:out value="${brand.id}" /></td>
	</tr>
	<tr>
		<td>Бренд</td>
		<td><c:out value="${brand.name}" /></td>
	</tr>
	<tr>
		<td>Создан</td>
		<td><c:out value="${brand.created}" /></td>
	</tr>
	<tr>
		<td>Изменен</td>
		<td><c:out value="${brand.modified}" /></td>
	</tr>
</table>
