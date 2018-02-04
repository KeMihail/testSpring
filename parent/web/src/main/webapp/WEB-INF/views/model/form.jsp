<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit model</h4>

<div class="row">
	<form:form class="col s12" method="POST" action="/model"
		modelAttribute="modelForm">
		<form:input path="id" type="hidden" />

		<div class="row">
			<div class="input-field col s12">
				<form:input path="name" type="text" disabled="${readonly}" />
				<form:errors path="name" cssClass="red-text" />
				<label for="name">name</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="carCit" type="text" disabled="${readonly}" />
				<form:errors path="carCit" cssClass="red-text" />
				<label for="carCit">carCit</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="engineType" type="text" disabled="${readonly}" />
				<form:errors path="engineType" cssClass="red-text" />
				<label for="engineType">engineType</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="BodyType" type="text" disabled="${readonly}" />
				<form:errors path="BodyType" cssClass="red-text" />
				<label for="BodyType">BodyType»</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="brandId" type="text" disabled="${readonly}" />
				<form:errors path="brandId" cssClass="red-text" />
				<label for="brandId">brandId»</label>
			</div>
		</div>

		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">сохранить</button>
				</c:if>
			</div>

			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="/model">к
					списку<i class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
