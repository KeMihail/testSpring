<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="mytags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib"
	uri="https://journaldev.com/jsp/tlds/mytags"%>

<c:set var="pageListHolder" value="${authentication}" scope="session" />
<spring:url value="/authentication" var="pageurl" />

<h4 class="header">List of Authentication</h4>
<table class="bordered highlight">
	<tbody>

		<tr>
			<th><mytaglib:sort-link column="userId">userId</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="login">login</mytaglib:sort-link></th>
			<th><mytaglib:sort-link column="password">password</mytaglib:sort-link></th>
			<th></th>
		</tr>

		<c:forEach var="authentication" items="${listModel.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${authentication.userId}" /></td>
				<td><c:out value="${authentication.login}" /></td>
				<td><c:out value="${authentication.password}" /></td>

				<td class="right"><a class="btn-floating"
					href="/authentication/${authentication.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating"
					href="/authentication/${authentication.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="/authentication/${authentication.id}/delete"><i
						class="material-icons">delete</i></a>
			</tr>
		</c:forEach>
	</tbody>
</table>
<mytags:paging />
<a class="waves-effect waves-light btn right" href="/authentication/add"><i
	class="material-icons">add</i></a>
