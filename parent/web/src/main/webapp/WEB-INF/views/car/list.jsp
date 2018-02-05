<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>

<c:set var="pageListHolder" value="${car}" scope="session" />
<spring:url value="/car" var="pageurl" />

<h4 class="header">List of Cars</h4>
<table class="bordered highlight">

	<tbody>
		<tr>
			<th><mytaglib:sort-link column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="userId">userId</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="releaseYear">releaseYear</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="modelId">modelId</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="legalEntityId">legalEntityId</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="status">status</mytaglib:sort-link></th>

			<th></th>
		</tr>

		<c:forEach var="car" items="${listModel.list}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${car.id}" /></td>
				<td><c:out value="${car.userId}" /></td>
				<td><c:out value="${car.releaseYear}" /></td>
				<td><c:out value="${car.modelId}" /></td>
				<td><c:out value="${car.legalEntityId}" /></td>
				<td><c:out value="${car.status}" /></td>

				<td class="right"><a class="btn-floating" href="/car/${car.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="/car/${car.id}/edit"><i class="material-icons">edit</i></a> <a
					class="btn-floating red" href="/car/${car.id}/delete"><i
						class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right" href="/car/add"><i
	class="material-icons">add</i></a>
