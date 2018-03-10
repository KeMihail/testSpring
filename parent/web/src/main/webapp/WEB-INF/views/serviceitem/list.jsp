<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>

<c:set var="pageListHolder" value="${serviceitem}" scope="session" />
<spring:url value="/serviceitem" var="pageurl" />

<h4 class="header">List of serviceitem</h4>
<table class="bordered highlight">

	<tbody>
		<tr>
			<th><mytaglib:sort-link column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="car">car</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="item">item</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="summa">summa</mytaglib:sort-link></th>
			<th></th>
		</tr>

		<c:forEach var="serviceitem" items="${listModel.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${serviceitem.id}" /></td>
				<td><c:out value="${serviceitem.carId}" /></td>
				<td><c:out value="${serviceitem.item}" /></td>
				<td><c:out value="${serviceitem.summa}" /></td>

				<td class="right"><a class="btn-floating"
					href="/serviceitem/${serviceitem.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="/serviceitem/${serviceitem.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="/serviceitem/${serviceitem.id}/delete"><i
						class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right" href="/serviceitem/add"><i
	class="material-icons">add</i></a>
