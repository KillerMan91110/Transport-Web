$(function () {
    $("#contactForm").submit(function (e) {
        e.preventDefault();
        const form = $("#contactForm");
        const formContainer = $("#form-container");
        let inputs = form.find(":input:not(:submit):not(button)");
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
            url:"/contacto",
            type: "POST",
            data: form.serialize(),
            success: function (res){
                console.log(res.message);
                formContainer.html('').css("height", "500px");
                formContainer.append(` 
                    <div class="alert alert-success d-flex align-items-center" role="alert">
                        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
                        <div>
                            Datos registrados, ¡Te contactaremos pronto!
                        </div>
                    </div>
                `)
                Swal.close();
            }
        })
    })
})