$(document).ready(function () {
    jQuery.validator.addMethod("dateLessThanToday", function(value, element) {
        var today = new Date();
        var inputDate = new Date(value);
        return this.optional(element) || inputDate < today;
    }, "Date must be less than current date");

    $("#employeeEditForm").validate({
        rules: {
            name: {
                required: true
            },
            email: {
                required: true,
                email: true
            },
            contact: {
                required: true,
                pattern: /^\d{10}$/
            },
            department: {
                required: true
            },
            salary: {
                required: true,
                pattern: /^\d{1,3}(,\d{3})*(\.\d+)?$/
            },
            dateOfJoining: {
                required: true,
                dateLessThanToday: true
            }
        },
        messages: {
            name: {
                required: "Enter name"
            },
            email: {
                required: "Enter email",
                email: "Please enter a valid email address"
            },
            contact: {
                required: "Enter contact",
                pattern: "Please enter a valid 10-digit phone number"
            },
            department: {
                required: "Enter department"
            },
            salary: {
                required: "Enter salary",
                pattern: "Salary must have a numeric value in (##,###) format"
            },
            dateOfJoining: {
                required: "Please select date",
                dateLessThanToday: "Date must be less than current date"
            }
        },
        errorPlacement: function (label, element) {
            label.css("color", "#d62027");
            label.insertAfter(element);
        },
        submitHandler: function (form) {

            $.ajax({
                type: "POST",
                url: "/employee/update",
                data: JSON.stringify(getFormData($(form))),
                contentType: "application/json",
                success: function (response) {
                    window.location.href = "/employee/home";
                }
            });
        }
    });
});

function getFormData($form) {
    var unindexed_array = $form.serializeArray();
    var indexed_array = {};
    $.map(unindexed_array, function (n, i) {
        indexed_array[n["name"]] = n["value"];
    });
    return indexed_array;
}