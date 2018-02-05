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
				<li><a href="/">Home</a></li>
				<li><a href="/rate">Rates List</a></li>
				<li><a href="/brand">Brand List</a></li>
				<li><a href="/legalEntity">legalEnity List</a></li>
				<li><a href="/model">Model List</a></li>
				<li><a href="/car">Car List</a></li>
				<li><a href="/user">User List</a></li>
				<li><a href="/costs">Costs List</a></li>
				<li><a href="/authentication">Authentication List</a></li>
				<li><a href="/car2CarOption">Car2CarOption List</a></li>
				<li><a href="carOption">CarOption List</a></li>
			</ul>
		</div>
	</nav>
</header>