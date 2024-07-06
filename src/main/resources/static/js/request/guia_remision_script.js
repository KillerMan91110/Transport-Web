let originalSelectHTML = $("#actualizar .conductor-container").html();
$(document).ready(function (){
    originalSelectHTML = $("#actualizar .conductor-container").html();
    console.log(originalSelectHTML);
});
function editRecord(id) {
        const form = $("#actualizar");
        Swal.fire({
            title: "Comprobando...",
            html: "Espere un momento",
            icon: "info",
            showCancelButton: false,
            showConfirmButton: false,
            showCloseButton: false,
            allowEscapeKey: false,
            allowOutsideClick: false,
            willOpen: () => {
                Swal.showLoading();
            },
        });
        form.trigger("reset");
        form.find(".conductor-container").html(originalSelectHTML);
        $.ajax({
            url: `/guiaRemision/guia/${id}`,
            type: "GET",
            success: function (response){
                form.attr("action",`/guiaRemision/guia/${id}`)
                for (const key in response){
                    if (response.hasOwnProperty(key)){
                        const field = form.find("[name='" + key + "']");
                        if (field.length) {
                            if (field.is("input, textarea")) {
                                field.val(response[key]);
                            } else if (field.is("select")) {
                                field.val(response[key]).change();
                            }
                        }
                    }
                }
                if(response.estado === "PEND"){
                    form.find("select[name='idEmpleado']").val(response.idEmpleado);
                }else{
                    form.find(".conductor-container").empty();
                }
                //console.log(response)
                $('#modalEditar').modal('show');
                Swal.close();
            },
            error: function () {
                Swal.fire({
                    title: "Error",
                    text: "No se pudo cargar la información. Inténtelo nuevamente.",
                    icon: "error",
                    confirmButtonText: "OK"
                });
            }
        })
}

function actualizar(){
    const form = $("#actualizar");
    /**/
    Swal.fire({
        title: "Comprobando...",
        html: "Espere un momento",
        icon: "info",
        showCancelButton: false,
        showConfirmButton: false,
        showCloseButton: false,
        allowEscapeKey: false,
        allowOutsideClick: false,
        willOpen: () => {
            Swal.showLoading();
        },
    });

    $.ajax({
        url: form.attr("action"),
        type: "PUT",
        data: form.serialize(),
        success: function (res) {
            Swal.close();
            localStorage.setItem("Status", "¡Registro Actualizado!");
            window.location.reload();
        },
        error: function () {
            Swal.close();
            Swal.fire({
                title: "Error",
                text: "No se pudo cargar la información. Inténtelo nuevamente.",
                icon: "error",
                confirmButtonText: "OK"
            });
        }
    });
}

$(document).ready(function() {
    let previousValue;

    $('table').on('focus', '#estado', function() {
        previousValue = $(this).val();
    }).on('change', '#estado', function() {
        const selectedValue = $(this).val();
        const id = $(this).attr("data-id");
        const selectElement = $(this);

        Swal.fire({
            title: '¿Estás seguro?',
            text: '¿Deseas cambiar el estado?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Sí, cambiar',
            cancelButtonText: 'No, cancelar',
            allowOutsideClick: false,
            allowEscapeKey: false
        }).then((result) => {
            if (result.isConfirmed) {
                console.log('Se ha seleccionado una nueva opción:', selectedValue);
                actualizarEstado(id,selectedValue);
            } else {
                selectElement.val(previousValue);
            }
        });
    });
});

function actualizarEstado(id,valor) {
    console.log('Se seleccionó el estado: ' + valor);
    $.ajax({
        url: `/guiaRemision/list/estado/${id}`,
        type: "PATCH",
        data: {estado:valor},
        success: function (response) {
            // Procesa la respuesta del servidor
        },
    })
}