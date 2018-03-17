<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
				<form:select path="carCit" type="text" disabled="${readonly}">
					<form:options items="${carKitChoices}" />
					<form:errors path="carCit" cssClass="red-text" />
				</form:select>
				<label for="carCit">carCit</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:select path="engineType" type="text" disabled="${readonly}">
					<form:options items="${engineTypeChoices}" />
					<form:errors path="engineType" cssClass="red-text" />
				</form:select>
				<label for="engineType">engineType</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:select path="BodyType" type="text" disabled="${readonly}">
					<form:options path="BodyType" items="${bodyTypeChoices}"
						cssClass="red-text" />
				</form:select>
				<label for="BodyType">BodyType</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:select path="brandId" disabled="${readonly}">
					<form:options items="${brandChoices}" />
				</form:select>
				<form:errors path="brandId" cssClass="red-text" />
				<label for="brandId">Brand</label>
			</div>
		</div>

		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">
						<spring:message code="standard.save" />
						
					</button>
				</c:if>
			</div>

			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="/model"><spring:message
						code="standard.tolist" /><i class="material-icons right"></i> </a>
			</div>
		</div>
	</form:form>
</div>
