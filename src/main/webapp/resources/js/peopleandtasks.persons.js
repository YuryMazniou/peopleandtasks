const personsUrl = "person/";

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
                }
            ]
        },
        updateTable: function () {
            $.get(personsUrl, updateTableByData);
        }
    });
});