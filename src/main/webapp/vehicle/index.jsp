<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
<%@include file="../component/allcss.jsp" %>
</head>
<body>
<c:if test="${empty vehiObj }">
      <c:redirect url="../driver_login.jsp"></c:redirect>
</c:if>

<%@include file="navbar.jsp" %>

<p class="text-center fs-3"> Driver Dashboard</p>

<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-2">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fa-solid fa-user"></i><br>
						<p class="fs-4 text-center">
							Driver <br>1
						</p>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body text-center text-success">
						<i class="fa-regular fa-calendar-check"></i><br>
						<p class="fs-4 text-center">
							Total Appointment <br>
							
						</p>
					</div>
				</div>
			</div>

		</div>
	</div>


</body>
</html>