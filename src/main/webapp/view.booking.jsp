<%@page import="com.model.Booking"%>
<%@page import="com.model.Vehicle"%>
<%@page import="com.dao.BookingDao"%>
<%@page import="com.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DBConnect"%>
<%@page import="com.dao.VehicleDao"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
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
	<c:if test="${empty userObj }">
		<c:redirect url="user_login.jsp"></c:redirect>
	</c:if>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fulid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>
	<div class="container p-3">
		<div class="row">
			<div class="col-md-9">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 fw-bold text-center text-dark">Booking
							List</p>
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Full Name</th>
									<th scope="col">Booking Date</th>
									<th scope="col">Email</th>
									<th scope="col">Phone No</th>
									<th scope="col">Driver and Branch</th>
									<th scope="col">Vehicle</th>
									<th scope="col">Full Address</th>
									<th scope="col">Status</th>

								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("userObj");
								BookingDao dao = new BookingDao(DBConnect.getConn());
								VehicleDao dao2 = new VehicleDao(DBConnect.getConn());
								List<Booking> list =dao.getAllBookingByLoginUser(user.getId());
								for (Booking ap : list) {
									Vehicle d = dao2.getVehicleById(ap.getVehicleId());
								%>
								<tr>
									<th><%=ap.getFullName()%></th>
									<td><%=ap.getBookinDate()%></td>
									<td><%=ap.getEmail()%></td>
									<td><%=ap.getPhNo()%></td>
									<td><%=d.getDriverName()%>(<%=d.getBranch()%>)</td>
									<td><%=d.getVehicleName()%></td>
									<td><%=ap.getAddress()%></td>
									
									<td>
										<%
										if ("Pending".equals(ap.getStatus())) {
										%> <a href="#" class="btn btn-sm btn-warning">Pending</a> <%
 } else {
 %> <%=ap.getStatus()%> <%
 }
 %>
									</td>
								</tr>
								<%
								}
								%>



							</tbody>
						</table>

					</div>
				</div>
			</div>

			<div class="col-md-3 p-3">
				<img alt="" src="images/carsall.jpg">
			</div>
		</div>
	</div>


</body>
</html>