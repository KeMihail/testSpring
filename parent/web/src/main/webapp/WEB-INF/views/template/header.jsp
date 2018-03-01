<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header>
	<nav>
		<div class="nav-wrapper container">
			<sec:authorize access="!isAnonymous()">
				<a class="right" href="/execute_logout"><i
					class="material-icons">arrow_forward</i></a>
			</sec:authorize>


			<ul id="nav-mobile" class="left hide-on-med-and-down">

				<li><a href="/"><spring:message code="menu.home" /></a></li>
				<li><a href="/rate"><spring:message code="menu.rate" /></a></li>
				<li><a href="/brand"><spring:message code="menu.brand" /></a></li>
				<li><a href="/legalEntity"><spring:message
							code="menu.legalEntity" /></a></li>
				<li><a href="/model"><spring:message code="menu.model" /></a></li>
				<li><a href="/car"><spring:message code="menu.car" /></a></li>
				<li><a href="/user"><spring:message code="menu.user" /></a></li>
				<li><a href="/service"><spring:message code="menu.service" /></a></li>
				<li><a href="/authentication"><spring:message
							code="menu.authentication" /></a></li>
				<li><a href="carOption"><spring:message
							code="menu.carOption" /></a></li>

			</ul>
		</div>
	</nav>
</header>