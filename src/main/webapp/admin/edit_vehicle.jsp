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

			<div class="col-md-5 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Vehicle Details</p>
						<c:if test="${not empty errorMsg}">
							<p class="fs-3 text-center text-danger">${errorMsg}</p>
							<c:remove var="errorMsg" scope="session" />
						</c:if>
						<c:if test="${not empty succMsg}">
							<div class="fs-3 text-center text-success" role="alert">${succMsg}</div>
							<c:remove var="succMsg" scope="session" />
						</c:if>
						
						<% 
						int id = Integer.parseInt(request.getParameter("id"));
						VehicleDao dao2 = new VehicleDao(DBConnect.getConn());
						Vehicle d = dao2.getVehicleById(id);
						%>
						
						
						<form action="../updateVehicle" method="post">
							<div class="mb-3">
								<label class="form-label">Vehicle Name</label> <input type="text"
									required name="vehiclename" class="form-control" 
									value="<%=d.getVehicleName()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Vehicle Number</label> <input type="text"
									required  name="vehiclenumber" class="form-control"
									value="<%=d.getVehicleNumber()%>">
							</div>

							<div class="mb-3">
								<label class="form-label">Driver Name</label> <input required value="<%=d.getDriverName()%>"
									name="drivername" type="text" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Branch</label> <select name="bran"
									required class="form-control">
									<option><%=d.getBranch()%></option>

									<%
									BranchDao dao = new BranchDao(DBConnect.getConn());
									List<Branch> list = dao.getAllBranch();
									for (Branch s : list) {
									%>
									<option><%=s.getBranchName()%></option>
									<%
									}
									%>


								</select>
							</div>

							<div class="mb-3">
								<label class="form-label">Email</label> <input type="text" 
								  value="<%=d.getEmail()%>"
									required name="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mob No</label> <input type="text" 
								value="<%=d.getMobNo() %>"
									required name="mobno" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label> <input required 
								value="<%=d.getPassword() %>"
									name="password" type="text" class="form-control">
									
									 
							</div>
							
							<input type="hidden" name="id" value = "<%=d.getId()%>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
			
			</div>
			
			</div>
		
			
			
			
</body>
</html>