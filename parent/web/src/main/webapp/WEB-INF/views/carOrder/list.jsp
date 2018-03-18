<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>

<c:set var="pageListHolder" value="${carOrder}" scope="session" />
<spring:url value="/carOrders" var="pageurl" />

<h4 class="header">List of carOrder</h4>
<table class="bordered highlight">

	<tbody>

		<tr>
			<th><mytaglib:sort-link column="departureAddress">departureAddress</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="arrivalAddress">arrivalAddress</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="orderBegin">orderBegin</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="orderEnd">orderEnd</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="distanceOrder">distanceOrder</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="distancePaid">distancePaid</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="inactivityMinutes">inactivityMinutes</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="total">total</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="clientName">clientName</mytaglib:sort-link></th>
			<th></th>
		</tr>

		<c:forEach var="carOrder" items="${listModel.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${carOrder.departureAddress}" /></td>
				<td><c:out value="${carOrder.arrivalAddress}" /></td>
				<td><c:out value="${carOrder.orderBegin}" /></td>
				<td><c:out value="${carOrder.orderEnd}" /></td>
				<td><c:out value="${carOrder.distanceOrder}" /></td>
				<td><c:out value="${carOrder.distancePaid}" /></td>
				<td><c:out value="${carOrder.inactivityMinutes}" /></td>
				<td><c:out value="${carOrder.total}" /></td>
				<td><c:out value="${carOrder.clientName}" /></td>

				<td class="right"><a class="btn-floating"
					href="/carOrders/${carOrder.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="/carOrders/${carOrder.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="/carOrders/${carOrder.id}/delete"><i
						class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right" href="/carOrders/add"><i
	class="material-icons">add</i></a>
