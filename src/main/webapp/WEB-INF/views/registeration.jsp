<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Registration Form</title>
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.css"
	rel="stylesheet"></link>
<link href="<%=request.getContextPath()%>/resources/css/app.css"
	rel="stylesheet"></link>
<link rel="stylesheet" type="text/css"
	href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
<link href="<%=request.getContextPath()%>/resources/css/jquery-ui.css"
	rel="stylesheet">
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery-ui.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/js/jquery-ui.min.js"></script>

<style>
.error {
	color: #ff0000;
}
</style>

<script>
	$(function() {
		$("#joiningdate").datepicker({
			dateFormat : 'dd/mm/yy',
			showOtherMonths : true,
			selectOtherMonths : true,
			autoclose : true,
			changeMonth : true,
			changeYear : true
		});

		$("#birthdate").datepicker({
			dateFormat : 'dd/mm/yy',
			showOtherMonths : true,
			selectOtherMonths : true,
			autoclose : true,
			changeMonth : true,
			changeYear : true
		});
	});
</script>

</head>

<body>
	<div id="mainWrapper">
		<div class="login-container">
			<div class="login-card">
				<div class="login-form">
					<c:url value="/registeration" var="registerURL"></c:url>
					<sf:form method="POST" action="${registerURL}"
						modelAttribute="employee" class="form-horizontal">
						<div>
							<sf:errors path="*" cssClass="error" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="fname"> First Name
							</label>
							<sf:input path="fname" id="fname" class="form-control"
								placeholder="Enter First Name" required="true" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="mname"> Middle Name
							</label>
							<sf:input path="mname" id="mname" class="form-control"
								placeholder="Enter Middle Name" required="true" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="lname">Last Name </label>
							<sf:input path="lname" id="lname" class="form-control"
								placeholder="Enter Last Name" required="true" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="joiningdate">Joining
								Date </label>
							<sf:input path="joiningdate" id="joiningdate"
								class="form-control" placeholder="Enter Joining Date" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="birthdate">Birth
								Date </label>
							<sf:input path="birthdate" id="birthdate" class="form-control"
								placeholder="Enter Birth Date" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="username">User Name
							</label>
							<sf:input path="username" id="username" class="form-control"
								placeholder="Enter User Name" required="true" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="password">Password
							</label>
							<sf:password path="password" id="password" class="form-control"
								placeholder="Enter Password" required="true" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="email">Email </label>
							<sf:input path="email" id="email" class="form-control"
								placeholder="Enter Email" required="true" />
						</div>
						<sf:errors path="email" cssClass="error" />
						<div class="input-group input-sm">
							<label class="input-group-addon" for="empid">Employee Id
							</label>
							<sf:input path="empid" id="empid" class="form-control"
								placeholder="Enter Employee Id" required="true" />
						</div>
						<div class="input-group input-sm">
							<label class="input-group-addon" for="active">Is Employee Active ?
							</label>
							<sf:checkbox path="active"  id="empid" checked="checked"/>
						</div>
						
						<div class="form-actions">
							<c:choose>
								<c:when test="${edit}">
									<input type="submit" value="Update"
										class="btn btn-block btn-primary btn-default" />
								</c:when>
								<c:otherwise>
									<input type="submit" value="Register"
										class="btn btn-block btn-primary btn-default" />
										<a href="<%=request.getContextPath()%>/" 
										class="btn btn-block btn-primary btn-default">back to Login</a>
								</c:otherwise>
							</c:choose>
						</div>
					</sf:form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>