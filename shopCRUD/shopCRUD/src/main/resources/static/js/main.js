document.addEventListener("DOMContentLoaded", function() {
    console.log("Shoplox 2015 Engine Ready.");

    const forms = document.querySelectorAll("form");
    forms.forEach(form => {
        form.addEventListener("submit", function(event) {
            // Confirmación básica estilo Roblox
            const confirmacion = confirm("¿Estás seguro de realizar esta acción?");
            if (!confirmacion) {
                event.preventDefault();
            }
        });
    });
});