<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit authentication</h4>

<div class="row">
	<form:form class="col s12" method="POST" action="/authentication"
		modelAttribute="authenticationForm">
		<!--<form:input path="id" type="hidden" />-->

		<div class="row">
			<div class="input-field col s12">
				<form:input path="userId" type="text" disabled="${readonly}" />
				<form:errors path="userId" cssClass="red-text" />
				<label for="userId">userId</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="login" type="text" disabled="${readonly}" />
				<form:errors path="login" cssClass="red-text" />
				<label for="login">login</label>
			</div>
		</div>

		<div class="row">
			<div class="input-field col s12">
				<form:input path="password" type="text" disabled="${readonly}" />
				<form:errors path="password" cssClass="red-text" />
				<label for="password">password</label>
			</div>
		</div>

		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">Сохранить</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="authentication">
					К списку<i class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
