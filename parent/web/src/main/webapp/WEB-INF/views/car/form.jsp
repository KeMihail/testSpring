<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit car</h4>

<div class="row">
	<form:form class="col s12" method="POST" action="/car"
		modelAttribute="carForm">
		<form:input path="id" type="hidden" />

		<div class="row">
			<div class="input-field col s12">
				<form:input path="userId" type="text" disabled="${readonly}" />
				<form:errors path="userId" cssClass="red-text" />
				<label for="userId">userId</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="releaseYear" type="text" disabled="${readonly}" />
				<form:errors path="releaseYear" cssClass="red-text" />
				<label for="releaseYear">releaseYear</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="modelId" type="text" disabled="${readonly}" />
				<form:errors path="modelId" cssClass="red-text" />
				<label for="modelId">modelId</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="legalEntityId" type="text" disabled="${readonly}" />
				<form:errors path="legalEntityId" cssClass="red-text" />
				<label for="legalEntityId">legalEntityId»</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="status" type="text" disabled="${readonly}" />
				<form:errors path="status" cssClass="red-text" />
				<label for="status">status»</label>
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
				<a class="btn waves-effect waves-light right" href="/car"> К
					списку<i class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
