$(document).ready(function () {
    $("#employee-dt").DataTable({
        columns: [
            {data: "name"},
            {
                data: "department",
            },
            {data: "salary"},
            {data: "dateOfJoining"},
            {data: "email"},
            {data: "contact"},
            {
                render: function (data, type, row) {
                    var editButton = '<button type="button" class="btn btn-primary btn-sm"><a style="color: black" href="/employee/get-by-id?id=' + row.id + '" >Edit</a></button>';
                    var deleteButton = '<button type="button" class="btn btn-danger btn-sm"><a style="color: black" href="/employee/delete?id=' + row.id + '">Delete</a></button>';
                    return editButton + ' ' + deleteButton;
                }
            }
        ],
        ajax: {
            url: "/employee/get-all",
            type: "POST",
            dataType: "json",
            contentType: "application/json",
            data: function (d) {
                return JSON.stringify(d);
            }
        }
    });

    $('#addRecordButton').on('click', function () {
        window.location.href = "/employee/create-emp";
    });
    $("#employee-dt").on('draw.dt', function () {
        $('#employee-dt tbody tr').each(function () {
            var salary = parseFloat($(this).find('td:eq(2)').text().replace(/[^0-9.-]+/g, ""));
            if (salary > 80000) {
                $(this).css('background-color', '#A9DFBF');
            } else if (salary > 50000) {
                $(this).css('background-color', '#F9E79F');
            } else if (salary > 25000) {
                $(this).css('background-color', '#EB984E');
            } else if (salary > 10000) {
                $(this).css('background-color', '#EC7063');
            }
        });
    });

});