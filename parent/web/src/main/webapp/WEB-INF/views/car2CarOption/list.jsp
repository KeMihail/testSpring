<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>

<c:set var="pageListHolder" value="${car2CarOption}" scope="session" />
<spring:url value="/car2CarOption" var="pageurl" />

<h4 class="header">List of car2CarOption</h4>
<table class="bordered highlight">
	<tbody>

		<tr>
			<th><mytaglib:sort-link column="carId">carId</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="carOptionId">carOptionId</mytaglib:sort-link></th>
			<th></th>
		</tr>

		<c:forEach var="car2CarOption" items="${listModel.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${car2CarOption.carId}" /></td>
				<td><c:out value="${car2CarOption.carOptionId}" /></td>

				<td class="right"><a class="btn-floating"
					href="/car2CarOption/${car2CarOption.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="/car2CarOption/${car2CarOption.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="/car2CarOption/${car2CarOption.id}/delete"><i
						class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right" href="/car2CarOption/add"><i
	class="material-icons">add</i></a>
