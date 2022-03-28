<!DOCTYPE html>
<!-- Designined by CodingLab | www.youtube.com/codinglabyt -->
<html lang="en" dir="ltr">

<head>
    <meta charset="UTF-8">
    <!--<title> Responsiive Admin Dashboard | CodingLab </title>-->
    <link rel="stylesheet" href="style.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <style>
    </style>
    <script>
    	var lastVehicleID;
    	function updateVehicle(vehicleDetails){
    		console.log(vehicleDetails);
    	} //end of function updateVehicle();
    	
    	function deleteVehicle(vehicleId){
    		console.log(vehicleId);
    		var vehicleIdURL = `/controller/deleteCarById/${vehicleId}`;
    		$.ajax({
    			url : vehicleIdURL,
    			type : "POST",
    		})	
    		console.log(vehicleIdURL);
    	} //end of function updateVehicle();
    	
    	$(document).ready(()=>{
    		$.ajax({
    			url: '/controller/getVehicleDetails',
    			type : "GET",
    			success : function(vehicleDetails){
    				lastVehicleID = vehicleDetails.length + 1;
    				console.log(lastVehicleID);
    				var table = $(`<table class = "table table-striped">
    								<tr> 
    										<th>#ID</th>
    										<th>Vehicle Name</th>
    										<th>Vehicle Brand</th>
    										<th>Vehicle Type</th>
    										<th>Seating Capacity</th>
    										<th>Price Per Km</th>
    										<th>Fuel Type</th>
    										<td>   <button type = "button" class = "btn btn-primary" data-toggle="modal" data-target="#addCar">Add Car</button>    <a href = "http://localhost:8080/AdminDashboard/ManageCars.html" class = "btn btn-warning" id = "">Refresh</a></td>
    									</tr>
    									</table>`);
  					for(var i=0;i<vehicleDetails.length;i++){
  						table.append( `<tr><td>${vehicleDetails[i].vehicle_id}</td><td>${vehicleDetails[i].vehicle_name}</td><td>${vehicleDetails[i].vehicle_brand_name}</td><td>${vehicleDetails[i].vehicle_type}</td><td>${vehicleDetails[i].vehicle_seating_capacity}</td><td>${vehicleDetails[i].vehicle_price_per_km}</td><td>${vehicleDetails[i].vehicle_fuel_type}</td> <td><button class = "btn btn-success" onclick = updateVehicle(vehicleDetails)>Update</button>    <button class = "btn btn-danger" onclick = deleteVehicle(${vehicleDetails[i].vehicle_id})>Delete</button</td> </tr>`);
  					} 	//end of for
  					$("#displayVehicles").append(table);
    			} //end of success function
    		})
    	})
    	function addCarDetails(){
    		var vehicleName = $("#vehicleName").val();
    		var vehicleBrandName = $("#vehicleBrandName").val();
    		var vehicleType = $("#vehicleType").val();
    		var seatingCapacity = $("#seatingCapacity").val();
    		var pricePerKm = $("#pricePerKm").val();
    		var vehicleFuelType = $("#vehicleFuelType").val();
    		var addCarURL = `/controller/addCar/${lastVehicleID}/${vehicleName}/${vehicleBrandName}/${vehicleType}/${seatingCapacity}/${pricePerKm}/${vehicleFuelType}`;
    		console.log(addCarURL);
    		$(document).ready(()=>{
    			$.ajax({
    				 url: addCarURL,
    				 type:"POST",
    				 success : function(){
    					 
    				 }
    			})
    		})
    	} //end of addCarDetails()
    </script>
</head>
<body style="overflow-x:hidden;">
    <div class="sidebar">
        <div class="logo-details">
            <i class='bx bxl-c-plus-plus'></i>
            <span class="logo_name">Car Rental Service</span>
        </div>
        <ul class="nav-links">
            <li>
                <a href="http://localhost:8080/AdminDashboard/Admin_Dashboard.html" class="active">
                    <i class='bx bx-grid-alt'></i>
                    <span class="links_name">Dashboard</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8080/AdminDashboard/ManageCars.html" id = "manageCars">
                    <i class='bx bx-box'></i>
                    <span class="links_name">Manage Cars</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8080/AdminDashboard/ManageDrivers.html">
                    <i class='bx bx-list-ul'></i>
                    <span class="links_name">Manage Drivers</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8080/AdminDashboard/UserFeedback.html">
                    <i class='bx bx-pie-chart-alt-2'></i>
                    <span class="links_name">User Feedback</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8080/AdminDashboard/ViewPayment.html">
                    <i class='bx bx-coin-stack'></i>
                    <span class="links_name">View Payments</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8080/AdminDashboard/ViewBookings.html">
                    <i class='bx bx-book-alt'></i>
                    <span class="links_name">View Bookings</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8080/AdminDashboard/ViewCustomers.html">
                    <i class='bx bx-user'></i>
                    <span class="links_name">View Customers</span>
                </a>
            </li>
            <li>
                <a href="http://localhost:8080/AdminDashboard/ViewProfile.html">
                    <i class='bx bx-user'></i>
                    <span class="links_name">View Profile</span>
                </a>
            </li>
            <li class="log_out">
                <a href="http://localhost:8080/AdminLogin/index.html">
                    <i class='bx bx-log-out'></i>
                    <span class="links_name">Log out</span>
                </a>
            </li>
        </ul>
    </div>
    <section class="home-section">
        <div class = "container text-center">
            <h3>Manage Cars</h3>
              <div id = "displayVehicles">
              </div>
        </div>
        
        <div class="modal fade" tabindex="-1" role="dialog" id = "addCar">
        	<div class="modal-dialog" role="document">
      			<div class="modal-content">
            			<div class="modal-header">
              				<h5 class="modal-title">Add Car</h5>
              				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    			<span aria-hidden="true">&times;</span>
              				</button>
    					</div>
    				<div class="modal-body">
      					<input type="text" class="text-primary" placeholder="Enter Vehicle Name" id="vehicleName">
      					<input type="text" class="text-primary" placeholder="Enter Vehicle Brand Name" id="vehicleBrandName">
      					<select id="vehicleType">
      						<option>Select Vehicle Type</option>
      						<option id = "Crossover">Crossover</option>
      						<option id = "HatchBack">Hatch-back</option>
      						<option id = "SUV">SUV</option>
      						<option id = "Sedan">Sedan</option>
      					</select>
      					<input type="text" class="text-primary" placeholder="Enter Seating Capacity" id="seatingCapacity">
      					<input type="text" class="text-primary" placeholder="Enter the Price (per km)" id="pricePerKm">
      					<select id="vehicleFuelType">
      						<option>Select Vehicle Fuel Type</option>
      						<option id = "CNG">CNG</option>
      						<option id = "Petrol">Petrol</option>
      						<option id = "Diesel">Diesel</option>
      						<option id = "Electric">Electric</option>
      					</select>
    				</div>
    				<div class="modal-footer">
      					<button type="button" class="btn btn-primary" onclick = "addCarDetails()">Add Car</button>
      					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
    				</div>
  				</div>
			</div>
		</div>
    </section>
    <!-- <script>
        let sidebar = document.querySelector(".sidebar");
        let sidebarBtn = document.querySelector(".sidebarBtn");
        sidebarBtn.onclick = function () {
            sidebar.classList.toggle("active");
            if (sidebar.classList.contains("active")) {
                sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
            } else
                sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
        }
    </script> -->
</body>
</html>