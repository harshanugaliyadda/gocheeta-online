<%@page import="com.model.Vehicle"%>
<%@page import="com.dao.VehicleDao"%>
<%@page import="com.model.Booking"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DBConnect"%>
<%@page import="com.dao.BookingDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Booking Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Booking Date</th>
							<th scope="col">Email</th>
							<th scope="col">Mobile Number</th>
							<th scope="col">Driver and Branch</th>
							<th scope="col">Vehicle</th>
							<th scope="col">Full Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						BookingDao dao = new BookingDao(DBConnect.getConn());
						VehicleDao dao2 = new VehicleDao(DBConnect.getConn());
						List<Booking> list = dao.getAllBooking();
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
							<td><%=ap.getStatus()%></td>
						</tr>
						<%
						}
						%>


					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>