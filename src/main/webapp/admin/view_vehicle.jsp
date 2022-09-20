
<%@page import="com.dao.BranchDao"%>
<%@page import="com.model.Vehicle"%>
<%@page import="com.dao.VehicleDao"%>
<%@page import="com.model.Branch"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DBConnect"%>
<%@page import="com.dao.BranchDao"%>
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
	<div class="container-fluid p-3">
		<div class="row">

			
			
			
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Vehicle Details</p>
					
						<table class="table">
							<thead>
								<tr>
									<th scope="col">Vehicle Name</th>
									<th scope="col">Vehicle Number</th>
									<th scope="col">Driver Name</th>
									<th scope="col">Branch</th>
									<th scope="col">Email</th>
									<th scope="col">Mob No</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								VehicleDao dao2 = new VehicleDao(DBConnect.getConn());
								List<Vehicle> list2 = dao2.getAllVehicle();
								for (Vehicle d : list2) {
								%>
								<tr>
									<td><%=d.getVehicleName()%></td>
									<td><%=d.getVehicleNumber()%></td>
									<td><%=d.getDriverName()%></td>
									<td><%=d.getBranch()%></td>
									<td><%=d.getEmail()%></td>
									<td><%=d.getMobNo()%></td>
									
									<td>
									<a href="edit_vehicle.jsp?id=<%=d.getId()%>"
										class="btn btn-sm btn-primary">Edit</a> 
										
										<a
										href="../deleteVehicle?id=<%=d.getId()%>"
										class="btn btn-sm btn-danger">Delete</a></td>
								</tr>
								<%
								}
								%>



							</tbody>
						</table>
						
						
                   </div>
                </div>
			</div>
		</div>  
	</div>
</body>
</html>