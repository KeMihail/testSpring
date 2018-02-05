<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>

<c:set var="pageListHolder" value="${costs}" scope="session" />
<spring:url value="/costs" var="pageurl" />

<h4 class="header">List of Costs</h4>
<table class="bordered highlight">

	<tbody>
		<tr>
			<th><mytaglib:sort-link column="carId">carId</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="taxes">taxes</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="technicalInspection">technicalInspection</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="insurance">insurance</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="carService">carService</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="pretripInspection">pretripInspection</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="salaryDriver">salaryDriver</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="fuelConsumption">fuelConsumption</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="other">other</mytaglib:sort-link></th>
			<th></th>
		</tr>

		<c:forEach var="costs" items="${listModel.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${costs.carId}" /></td>
				<td><c:out value="${costs.taxes}" /></td>
				<td><c:out value="${costs.technicalInspection}" /></td>
				<td><c:out value="${costs.insurance}" /></td>
				<td><c:out value="${costs.carService}" /></td>
				<td><c:out value="${costs.pretripInspection}" /></td>
				<td><c:out value="${costs.salaryDriver}" /></td>
				<td><c:out value="${costs.fuelConsumption}" /></td>
				<td><c:out value="${costs.other}" /></td>

				<td class="right"><a class="btn-floating"
					href="/costs/${costs.id}"><i class="material-icons">info</i></a> <a
					class="btn-floating" href="/costs/${costs.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="/costs/${costs.id}/delete"><i class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right" href="/costs/add"><i
	class="material-icons">add</i></a>
