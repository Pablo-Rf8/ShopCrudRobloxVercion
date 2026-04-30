document.addEventListener("DOMContentLoaded", function() {
    console.log("Shoplox 2015 Engine Ready.");

    const forms = document.querySelectorAll("form");
    forms.forEach(form => {
        form.addEventListener("submit", function(event) {
            // Confirmación básica estilo Roblox
            const confirmacion = confirm("¿Estás seguro de realizar esta acción?");
            if (!confirmacion) {
                event.preventDefault();
            const tableSearchInput = document.getElementById('table-search');
              if (tableSearchInput) {
              tableSearchInput.addEventListener('keyup', function() {
            const filterText = this.value.toLowerCase();
            const rows = document.querySelectorAll('#crud-table tbody tr');

            rows.forEach(row => {
                const rowText = row.innerText.toLowerCase();
                if (rowText.includes(filterText)) {
                    row.style.display = '';
                } else {
                    row.style.display = 'none';
                }
            });
        });
    }