document.getElementById('searchButton').addEventListener('click', function() {
    var searchText = document.getElementById('searchText').value;

    fetch('/api?searchText=' + encodeURIComponent(searchText))
        .then(response => response.json())
        .then(function(data) {
            var resultadosTable = document.getElementById('resultadosTable');
            var resultadosBody = document.getElementById('resultadosBody');
            resultadosBody.innerHTML = '';


            data.map((item) => {
                const row = resultadosBody.insertRow();
                row.insertCell().textContent = item.nombre;
                row.insertCell().textContent = item.apellido;
                row.insertCell().textContent = item.correo;
                row.insertCell().textContent = item.direccion;
                row.insertCell().textContent = item.ciudad;
                row.insertCell().textContent = item.departamento;
                row.insertCell().textContent = item.barrio;
                row.insertCell().textContent = item.fecha;
                row.insertCell().textContent = item.estado;
            });
            console.log(data);



            resultadosTable.style.display = 'block';
        })
        .catch(error => console.error('Error:', error));
});
