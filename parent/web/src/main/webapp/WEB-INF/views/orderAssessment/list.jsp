<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="pageListHolder" value="${orderAssessment}" scope="session" />
<spring:url value="/brand" var="pageurl" />

<h4 class="header">orderAssessment List</h4>

<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link column="id">ID</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="orderId">orderId</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="assessment">assessment</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="comment">comment</mytaglib:sort-link></th>
		</tr>

		<c:forEach var="orderAssessment" items="${listModel.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${orderAssessment.id}" /></td>
				<td><c:out value="${orderAssessment.orderId}" /></td>
				<td><c:out value="${orderAssessment.assessment}" /></td>
				<td><c:out value="${orderAssessment.comment}" /></td>

				<td class="right"><a class="btn-floating"
					href="/orderAssessment/${orderAssessment.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="/orderAssessment/${orderAssessment.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="/orderAssessment/${orderAssessment.id}/delete"><i
						class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right"
	href="/orderAssessment/add"><i class="material-icons">add</i></a>
