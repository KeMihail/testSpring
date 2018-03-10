
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>

<c:set var="pageListHolder" value="${model}" scope="session" />
<spring:url value="/model" var="pageurl" />

<h4 class="header">List of Model</h4>
<table class="bordered highlight">

	<tbody>

		<tr>
			<th><mytaglib:sort-link column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="name">name</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="carCit">carCit</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="engineType">engineType</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="BodyType">bodyType</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="brandId">brandId</mytaglib:sort-link></th>
			<th></th>
		</tr>

		<c:forEach var="model" items="${listModel.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${model.id}" /></td>
				<td><c:out value="${model.name}" /></td>
				<td><c:out value="${model.carCit}" /></td>
				<td><c:out value="${model.engineType}" /></td>
				<td><c:out value="${model.bodyType}" /></td>
				<td><c:out value="${model.brandId}" /></td>

				<td class="right"><a class="btn-floating"
					href="/model/${model.id}"><i class="material-icons">info</i></a> <a
					class="btn-floating" href="/model/${model.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="/model/${model.id}/delete"><i class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right" href="/model/add"><i
	class="material-icons">add</i></a>
