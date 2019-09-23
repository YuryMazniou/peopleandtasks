const personsUrl = "rest/persons/";

$(function () {
    makeEditable({
        ajaxUrl: personsUrl,
        datatableOpts: {
            "columns": [
                {
                    "data": "firstName"
                },
                {
                    "data": "lastName"
                },
                {
                    "data": "patronymic"
                },
                {
                    "data": "email",
                    "render": function (data, type, row) {
                        if (type === "display") {
                            return "<a href='mailto:" + data + "'>" + data + "</a>";
                        }
                        return data;
                    }
                },
                {
                    "data": "password"
                },
                {
                    "render": renderEditBtn,
                    "defaultContent": "",
                    "orderable": false
                },
                {
                    "render": tasksBtn,
                    "defaultContent": "",
                    "orderable": false
                }
            ]
        },
        updateTable: function () {
            $.get(personsUrl, updateTableByData);
        }
    });
});

function renderEditBtn(data, type, row) {
    if (type === "display") {
        /*return "<a onclick='updateRow(" + row.id + ");'><span class='fa fa-pencil'></span></a>";*/
        return "<button type=\"button\" class=\"btn btn-info\" onclick='updateRow(" + row.id + ");'>Изменить</button>";
    }
}

function tasksBtn(data, type, row) {
    if (type === "display") {
        return "<button type=\"button\" class=\"btn btn-info\" onclick='goToTasks(" + row.id + ");'>Задачи</button>";
    }
}

function savePerson() {
    var contactForm = {};
    var id = $('#id').val();
    var firstName = $('#firstName').val();
    var patronymic = $('#patronymic').val();
    var lastName = $('#lastName').val();
    var email = $('#email').val();
    var password = $('#password').val();
    contactForm.id = id;
    contactForm.firstName = firstName;
    contactForm.lastName = lastName;
    contactForm.patronymic = patronymic;
    contactForm.email = email;
    contactForm.password = password;
    $.ajax({
        type: "POST",
        url: context.ajaxUrl,
        data: JSON.stringify(contactForm),
        contentType: 'application/json; charset=utf-8',
        dataType: 'json'
    }).done(function () {
        $("#editRow").modal("hide");
        context.updateTable();
        successNoty("Успешно сохраненно");
    });
}

function updateRow(id) {
    $("#modalTitle").html();
    $.get(context.ajaxUrl + id, function (data) {
        $.each(data, function (key, value) {
            form.find("input[name='" + key + "']").val(value);
        });
        $('#editRow').modal();
    });
}

function goToTasks(id) {
    localStorage.setItem('idPerson', id);
    window.location.href='tasks'
}