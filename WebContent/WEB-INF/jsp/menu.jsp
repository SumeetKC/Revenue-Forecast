<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
/* Dropdown Button */
.dropbtn {
	background-color: #4CAF50;
	color: white;
	padding: 11px;
	font-size: 14px;
	border: none;
	cursor: pointer;
	font-family: Arial;
	/* font-size: 9pt; */
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
	position: relative;
	display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
	background-color: #f1f1f1
}

/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
	display: block;
}

/* Change the background color of the dropdown button when the dropdown content is shown */
.dropdown:hover .dropbtn {
	background-color: #3e8e41;
}

.anchorstyle {
	font-family: Arial;
	font-size: 9pt;
}
</style>
<c:if test="${sessionScope.userValid!=null}">
<div class="dropdown">
	
	<c:if test="${sessionScope.userValid.role=='A'}">
	<button class="dropbtn">Upload Sheets</button>
	<div class="dropdown-content">
		<!-- <a class="anchorstyle" href="view_up_aas.html">Active Assignment Sheet</a> -->
		<a class="anchorstyle" href="view_up_ar.html">Allocation Report Sheet</a> 
		<a class="anchorstyle" href="view_up_evcis.html">ESA VS Contractor Id Sheet</a>
		<a class="anchorstyle" href="view_up_pls.html">Project List Sheet</a> 
		<a class="anchorstyle" href="view_update_pl.html">View/Update Project List</a>
		<a class="anchorstyle" href="view_up_swwds.html">SOW Worker Wise Data Sheet</a>
		<a class="anchorstyle" href="view_up_vds.html">Vacation Details Sheet</a>
		<a class="anchorstyle" href="view_up_jwns.html">Just Worker New Sheet</a>
		<a class="anchorstyle" href="view_up_hls.html">Holiday List Sheet</a>
		<a class="anchorstyle" href="view_up_ppms.html">PPM Sheet</a>
	</div>
	</c:if>
</div>
<div class="dropdown">
	<button class="dropbtn">Generate Reports</button>
	<div class="dropdown-content">
		<c:if test="${sessionScope.userValid.role=='A'}">
		<a class="anchorstyle" href="generatebase.html">Generate Base Sheet</a>
		<a class="anchorstyle" href="generateActiveSheet.html">Generate	Active sheet</a> 
		<a class="anchorstyle" href="movebase.html">Move Base To Base History</a>
		<a class="anchorstyle" href="duplicatereport.html">Duplicate Report</a>
		</c:if>
		
		<a class="anchorstyle" href="viewbase.html">View Base Sheet</a>
		<a class="anchorstyle" href="fetchreportbypm.html">Project Manager Wise Report</a> 
		<a class="anchorstyle" href="fetchreportbyproject.html">Project Wise Report</a>
		<a class="anchorstyle" href="ppmtaskreport.html">PPM Status Task wise Report</a>
		<a class="anchorstyle" href="ppmstatusreport.html">PPM Status Report</a>
		<a class="anchorstyle" href="ppmactuals.html">PPM Actuals</a>
	</div>
</div>
<c:if test="${sessionScope.userValid.role=='A'}">
<div class="dropdown">
	<button class="dropbtn">AdminOps</button>
	<div class="dropdown-content">
		<a class="anchorstyle" href="listusers.html">List Users</a>
		
	</div>
</div>
</c:if>
<hr>
</c:if>


