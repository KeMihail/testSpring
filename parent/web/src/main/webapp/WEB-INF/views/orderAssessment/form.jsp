<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<h4 class="header">orderAssessment</h4>

<div class="row">
	<form:form class="col s12" method="POST" action="/orderAssessment"
		modelAttribute="orderAssessmentForm">
		<form:input path="id" type="hidden" />

		<div class="row">
			<div class="input-field col s12">
				<form:select path="orderId" type="text" disabled="${readonly}">
					<form:options items="${ordersChoices}" />
				</form:select>
				<form:errors path="orderId" cssClass="red-text" />
				<label for="orderId">orderId</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="assessment" type="text" disabled="${readonly}" />
				<form:errors path="assessment" cssClass="red-text" />
				<label for="assessment">assessment</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="comment" type="text" disabled="${readonly}" />
				<form:errors path="comment" cssClass="red-text" />
				<label for="comment">comment</label>
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
				<a class="btn waves-effect waves-light right"
					href="/orderAssessment"> <spring:message code="standard.tolist" /><i
					class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
