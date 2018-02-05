<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit car2CarOption</h4>

<div class="row">
	<form:form class="col s12" method="POST" action="/car2CarOption"
		modelAttribute="car2CarOptionForm">
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
				<form:input path="carOptionId" type="text" disabled="${readonly}" />
				<form:errors path="carOptionId" cssClass="red-text" />
				<label for="carOptionId">carOptionId</label>
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
				<a class="btn waves-effect waves-light right" href="/car2CarOption">
					К списку<i class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
