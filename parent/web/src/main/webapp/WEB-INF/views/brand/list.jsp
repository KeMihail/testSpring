<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="margin: 10px;">
	<h4>List of Rates</h4>
	<table style="width: 600px" class="reference">

		<tbody>
			<tr>
				<th>Id</th>
				<th>Name</th>
			</tr>
			<c:forEach var="brand" items="${requestScope.brandAll}"
				varStatus="loopCounter">
				<tr>
					<td><c:out value="${brand.id}" /></td>
					<td><c:out value="${brand.name}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<a href="/brand/add">Сохранить</a>

</div>