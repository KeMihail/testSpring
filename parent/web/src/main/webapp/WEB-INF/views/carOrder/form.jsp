<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h4 class="header">Edit CarOrder</h4>

<div class="row">
	<form:form class="col s12" method="POST" action="/carOrder"
		modelAttribute="carOrderForm">
		<form:input path="id" type="hidden" />

		<div class="row">
			<div class="input-field col s12">
				<form:input path="departureAddress" type="text"
					disabled="${readonly}" />
				<form:errors path="departureAddress" cssClass="red-text" />
				<label for="departureAddress">departureAddress</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="arrivalAddress" type="text" disabled="${readonly}" />
				<form:errors path="arrivalAddress" cssClass="red-text" />
				<label for="arrivalAddress">arrivalAddress</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="distanceOrder" type="text" disabled="${readonly}" />
				<form:errors path="distanceOrder" cssClass="red-text" />
				<label for="distanceOrder">distanceOrder</label>
			</div>
		</div>
		<div class="row">
			<div class="input-field col s12">
				<form:input path="distancePaid" type="text" disabled="${readonly}" />
				<form:errors path="distancePaid" cssClass="red-text" />
				<label for="distancePaid">distancePaid</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="inactivityMinutes" type="text"
					disabled="${readonly}" />
				<form:errors path="inactivityMinutes" cssClass="red-text" />
				<label for="inactivityMinutes">inactivityMinutes</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:select path="rateId" type="text" disabled="${readonly}">
					<form:options items="${rateChoices}" />
				</form:select>
				<form:errors path="rateId" cssClass="red-text" />
				<label for="rateId">rate</label>
			</div>
		</div>


		<div class="row">
			<div class="input-field col s12">
				<form:select path="clientId" type="text" disabled="${readonly}">
					<form:options items="${userChoices}" />
				</form:select>
				<form:errors path="clientId" cssClass="red-text" />
				<label for="clientId">client</label>
			</div>
		</div>


		<div class="row">
			<div class="input-field col s12">
				<form:select path="driverId" type="text" disabled="${readonly}">
					<form:options items="${driverChoices}" />
				</form:select>
				<form:errors path="driverId" cssClass="red-text" />
				<label for="driverId">driver</label>
			</div>
		</div>


		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">
						<spring:message code="standard.save" />
					</button>
				</c:if>
			</div>

			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="/carOrder"><spring:message
						code="standard.tolist" /><i class="material-icons right"></i> </a>
			</div>
		</div>
	</form:form>
</div>
