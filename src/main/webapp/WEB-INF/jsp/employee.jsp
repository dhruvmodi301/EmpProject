<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Employee Detail</title>
    <link rel="stylesheet" href="https://cdn.datatables.net/2.0.7/css/dataTables.dataTables.min.css">
</head>
<body>
<h2>Welcome to Employee Detail Page</h2>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-12 mt-5 mb-5 mt-5">
            <button class="btn btn-danger" style="justify-content: end;margin-left: 92%;" id="addRecordButton">Add New Record</button>
        </div>
    </div>
</div>


<table id="employee-dt" border="1" class="table dataTable" style="width:100%">
    <thead>
    <tr>
        <th>Name</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Date of Joining</th>
        <th>Email</th>
        <th>Contact</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="https://cdn.datatables.net/2.0.7/js/dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/employee.js"></script>
</body>
</html>