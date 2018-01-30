<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>

<c:set var="pageListHolder" value="${rate}" scope="session" />
<spring:url value="/rate" var="pageurl" />

<h4 class="header">List of Rates</h4>
<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="name">name</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="price_landing">price_landing</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="price_kilometr">price_kilometr</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="price_minute_wait">price_minute_wait</mytaglib:sort-link></th>
			<th></th>
		</tr>
		<c:forEach var="rate" items="${listModel.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${rate.id}" /></td>
				<td><c:out value="${rate.name}" /></td>
				<td><c:out value="${rate.priceLanding}" /></td>
				<td><c:out value="${rate.priceKilometr}" /></td>
				<td><c:out value="${rate.priceMinuteWait}" /></td>

				<td class="right"><a class="btn-floating"
					href="/rate/${rate.id}"><i class="material-icons">info</i></a> <a
					class="btn-floating" href="/rate/${rate.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="/rate/${rate.id}/delete"><i class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right" href="/rate/add"><i
	class="material-icons">add</i></a>
