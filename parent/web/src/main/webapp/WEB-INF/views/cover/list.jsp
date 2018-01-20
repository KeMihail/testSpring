<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div style="margin: 10px;">
	<h4>List of Covers</h4>
	<table style="width: 600px" class="reference">
		<tbody>
			<tr>
				<th>ID</th>
				<th>Width</th>
				<th>Material</th>
			</tr>
			<c:forEach var="cover" items="${requestScope.covers}" varStatus="loopCounter">
				<tr>
					<td><c:out value="${cover.id}" /></td>
					<td><c:out value="${cover.width}" /></td>
					<td><c:out value="${cover.material}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>