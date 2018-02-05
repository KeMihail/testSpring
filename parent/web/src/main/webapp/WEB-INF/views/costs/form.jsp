<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit Costs</h4>

<div class="row">
	<form:form class="col s12" method="POST" action="/costs"
		modelAttribute="costsForm">
		<!--<form:input path="id" type="hidden" />-->

		<div class="row">
			<div class="input-field col s12">
				<form:input path="carId" type="text" disabled="${readonly}" />
				<form:errors path="carId" cssClass="red-text" />
				<label for="carId">carId</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="taxes" type="text" disabled="${readonly}" />
				<form:errors path="taxes" cssClass="red-text" />
				<label for="priceLtaxesanding">taxes</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="technicalInspection" type="text"
					disabled="${readonly}" />
				<form:errors path="technicalInspection" cssClass="red-text" />
				<label for="technicalInspection">technicalInspection</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="insurance" type="text" disabled="${readonly}" />
				<form:errors path="insurance" cssClass="red-text" />
				<label for="insurance">insurance»</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="carService" type="text" disabled="${readonly}" />
				<form:errors path="carService" cssClass="red-text" />
				<label for="carService">carService»</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="pretripInspection" type="text"
					disabled="${readonly}" />
				<form:errors path="pretripInspection" cssClass="red-text" />
				<label for="pretripInspection">pretripInspection»</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="salaryDriver" type="text" disabled="${readonly}" />
				<form:errors path="salaryDriver" cssClass="red-text" />
				<label for="salaryDriver">salaryDriver»</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="fuelConsumption" type="text"
					disabled="${readonly}" />
				<form:errors path="fuelConsumption" cssClass="red-text" />
				<label for="fuelConsumption">fuelConsumption»</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="other" type="text" disabled="${readonly}" />
				<form:errors path="other" cssClass="red-text" />
				<label for="other">other»</label>
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
				<a class="btn waves-effect waves-light right" href="/costs"> К
					списку<i class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
