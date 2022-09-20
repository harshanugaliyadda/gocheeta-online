<%@page import="com.model.Vehicle"%>
<%@page import="com.dao.DBConnect"%>
<%@page import="com.dao.BranchDao"%>
<%@page import="com.dao.VehicleDao"%>

<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0);
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="com.model.Branch"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Appointment</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/hospital.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}
</style>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-5">
				<img alt="" src="images/carsall.jpg" class="d-block w-100"  >
			</div>

			<div class="col-md-6">
				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">Booking Vehicle</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-4 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<p class=" fs-4 text-center text-success">${succMsg}</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						<form class="row g-3" action="appBooking" method="post">

							<input type="hidden" name="userid" value="${userObj.id }">

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Full Name</label> <input
									required type="text" class="form-control" name="fullname">
							</div>


							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Booking
									Date</label> <input type="date" class="form-control" required
									name="booking_date">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Email</label> <input
									required type="email" class="form-control" name="email">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Phone No</label> <input
									maxlength="10" required type="number" class="form-control"
									name="phno">
							</div>


							

							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Driver and Branch</label> <select
									required class="form-control" name="driver_id">
									<option value="">--select--</option>

									<%
									VehicleDao dao = new VehicleDao(DBConnect.getConn());
									List<Vehicle> list = dao.getAllVehicle();
									for (Vehicle d : list) {
									%>
									<option value="<%=d.getId()%>"><%=d.getDriverName()%> (<%=d.getBranch()%>)
									</option>
									<%
									}
									%>
								</select>
							</div>
							
							
						
							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Vehicle</label> <select
									required class="form-control" name="vehicle_id">
									<option value="">--select--</option>

									<%
									VehicleDao dao2 = new VehicleDao(DBConnect.getConn());
									List <Vehicle> list2 = dao.getAllVehicle();
									for (Vehicle d : list2) {
									%>
									<option value="<%=d.getId()%>"><%=d.getVehicleName()%>  
									</option>
									<%
									}
									%>
								</select>
							</div>
							
							<div class="col-md-12">
								<label>Full Address</label>
								<textarea required name="address" class="form-control" rows="2"
									cols=""></textarea>
							</div>

							<c:if test="${empty userObj }">
								<a href="user_login.jsp" class="col-md-6 offset-md-3 btn btn-success bg-dark">Submit</a>
							</c:if>

							<c:if test="${not empty userObj }">
								<button class="col-md-6 offset-md-3 btn btn-success bg-dark">Submit</button>
							</c:if>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="component/footer.jsp"%>

</body>
</html>