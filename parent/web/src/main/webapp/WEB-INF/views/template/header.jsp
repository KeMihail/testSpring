<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<header>
	<nav>
		<div class="nav-wrapper container">
			<sec:authorize access="!isAnonymous()">
				<a class="right" href="/execute_logout"><i
					class="material-icons">arrow_forward</i></a>
			</sec:authorize>
			<ul id="nav-mobile" class="left hide-on-med-and-down">

				<sec:authorize access="hasRole('ADMIN')">

					<li><a href="/"><spring:message code="menu.home" /></a></li>

					<li><a href="/brand"><spring:message code="menu.brand" /></a></li>
					<li><a href="/model"><spring:message code="menu.model" /></a></li>
					<li><a href="/legalEntity"><spring:message
								code="menu.legalEntity" /></a></li>
					<li><a href="/rate"><spring:message code="menu.rate" /></a></li>
					<li><a href="/orderAssessment"><spring:message
								code="menu.orderAssessment" /></a></li>
					<li><a href="/carOption"><spring:message
								code="menu.carOption" /></a></li>
					<li><a href="/user"><spring:message code="menu.user" /></a></li>
					<li><a href="/serviceitem"><spring:message
								code="menu.service" /></a></li>
					<li><a href="/driver"><spring:message code="menu.driver" /></a></li>
					<li><a href="/car"><spring:message code="menu.car" /></a></li>
					<li><a href="/carOrder"><spring:message code="menu.order" /></a></li>
				</sec:authorize>

			</ul>
		</div>
	</nav>
	<div class="white-text " style="position: absolute; top: 5; right: 60">
		<sec:authentication property="name" />
	</div>

	<div class="white-text " style="position: absolute; top: 30; right: 60">
		<sec:authentication property="authorities" var="roles" scope="page" />
		<c:forEach var="role" items="${roles}">
			${role}
		</c:forEach>
	</div>

	<%-- <div style="position: absolute; top: 20; right: 20">
		<a
			href="${requestScope['javax.servlet.forward.request_uri']}?langauge=en">en</a>|<a
			href="${requestScope['javax.servlet.forward.request_uri']}?langauge=ru">ru</a>
	</div> --%>

	<div style="position: absolute; top: 20; right: 20">
		<a href="?lang=en">en</a> | <a href="?lang=ru">ru</a>
	</div>


	<!-- <span style="float: right;"><a href="?lang=en">en</a><a
		href="?lang=ru">ru</a></span> -->
</header>