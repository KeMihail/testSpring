<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit serviceitem</h4>

<div class="row">
	<form:form class="col s12" method="POST" action="/serviceitem"
		modelAttribute="serviceitemForm">
		<!--<form:input path="id" type="hidden" />-->

		<div class="row">
			<div class="input-field col s12">
				<form:input path="id" type="text" disabled="${readonly}" />
				<form:errors path="id" cssClass="red-text" />
				<label for="id">ID</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="car" type="text" disabled="${readonly}" />
				<form:errors path="car" cssClass="red-text" />
				<label for="car">car</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="item" type="text" disabled="${readonly}" />
				<form:errors path="item" cssClass="red-text" />
				<label for="item">item</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="summa" type="text" disabled="${readonly}" />
				<form:errors path="summa" cssClass="red-text" />
				<label for="summa">summa�</label>
			</div>
		</div>

		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">Сохранить</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="/serviceitem">
					К списку<i class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
