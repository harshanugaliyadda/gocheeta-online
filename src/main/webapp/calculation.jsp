<%@page import="java.util.List"%>
<%@page import="com.dao.VehicleDao"%>
<%@page import="com.model.Vehicle"%>
<%@page import="com.dao.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

 <%@include file="component/allcss.jsp" %>
    
<meta charset="ISO-8859-1">
<title>Insert title here</title>

	<style type="text/css">
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
  font-family: "Poppins", sans-serif;
}
body {
  height: 100vh;
  background: #DCDCDC;
}
.container {
  background-color: #ffffff;
  position:  absolute;
  transform: translate(-50%, -50%);
  top: 90%;
  left: 50%;
  width: 50vw;
  max-width: 650px;
  min-width: 350px;
  padding: 60px 50px;
  border-radius: 10px;
  box-shadow: 0 20px 40px rgba(0, 0, 0, 0.2);
}
h1{

text-align:center;
}
.topimg{
height: 230px;
	display: block;
	margin-left: auto;
	margin-right: auto;
	margin-bottom:0px;

}

label {
  display: block;
  font-size: 22px;
  margin-bottom: 10px;
  font-weight: 500;
}
input {
  margin-bottom: 20px;
  border: none;
  font-size: 20px;
  border-bottom: 2px solid #585858;
  color: #585858;
  padding: 2px 15px;
}
input:focus {
  outline: none;
  border-bottom: 2.4px solid #FFD700;
}
.input-wrapper {
  display: flex;
  justify-content: space-between;
  gap: 20px;
}
.input-wrapper input {
  width: 100%;
}
.time-wrapper input {
  width: 60%;
}
select {
  width: 35%;
  border: 1px solid #585858;
  font-size: 20px;
  margin-left: 3%;
  padding: 8px 0;
  border-radius: 5px;
}
onclick {
  display: block;
  background-color: #01e26e;
  border: none;
  color: #ffffff;
  margin: 20px auto 0 auto;
  padding: 15px 40px;
  font-size: 20px;
  border-radius: 5px;
}
#result {
  background-color: ;
  margin-top: 30px;
  color: #585858;
  text-align: center;
  font-size: 18px;
  padding: 20px;
  border-radius: 5px;
}
#result div {
  margin-bottom: 10px;
}
#result span {
  color: ;
  font-weight: 500;
  
  
}

.sem {
 background-color: White;
 height:30px;
 width:50px;

}

.p3 {

text-align: center;
color: black;
}

</style> 


	<title>javascript: calculate two numbers</title>
        <meta charset="windows-1252">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <script>
            
            function calc()
            {
                var n1 = parseFloat(document.getElementById('n1').value);
                var n2 = parseFloat(document.getElementById('n2').value);
                
                var oper = document.getElementById('operators').value;
                
                
                
                if(oper === 'X')
                {
                    document.getElementById('result').value = n1*n2;
                }
            }
            
        </script>
        
    </head>
 
    <body>
    	<%@include file="component/navbar.jsp"%>
    <div class="container">  
  
  
      <h1> GoCheeta </h1>
       <img src="images/gocheta.jpg" class="d-block w-100" alt="..."  height="400px">
  <br>

    <p >  Charge Per Km </p> <input type="number" id="n1" value="45" /><br/> <br/>
      <p>  Enter Distance(Km)  </p>   <input type="number" id="n2" value="" /><br/><br/>
        
        <select id="operators">
            
            <option value="X">  Currency (LKR)</option>
        
        </select>
       
   
        
        <button  onclick ="calc();" type="button" class="btn bg-dark text-white col-md-2 ">Submit</button>
      

        <input type="text" id="result" /> 
            <p class="p3"> Pay cash end of the journy.</p>
         </div>   
        
    </body>
</html>