<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="POST" action="/brand" modelAttribute="brandForms">
	<table>
		<tr>
			<td>Бренд</td>
			<td><form:input path="name" type="text" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Сохранить" /></td>
		</tr>
	</table>
</form:form>
