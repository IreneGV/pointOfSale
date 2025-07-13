function obtenerMarcas(){
	return fetch('/marcas/all')
	    .then(response => {
	        if (!response.ok) {
	            throw new Error("Error al obtener las marcas");
	        }
	        return response.json();
	    })
		.then(marcas => {
		    const select = document.getElementById('marcaSelect');
		    select.innerHTML = '<option value="" disabled selected hidden>Selecciona una marca</option>';
		    marcas.forEach(marca => {
		        const option = document.createElement('option');
		        option.value = marca.idMarca;
		        option.textContent = marca.nombre;
		        select.appendChild(option);
		    });
		})
	    .catch(error => {
	        console.error('Error al cargar las marcas:', error);
	    });
}

function obtenerValoresCheckSeleccionados(name) {
    return Array.from(document.querySelectorAll(`input[name="${name}[]"]:checked`))
                .map(cb => cb.value);
}

function obtenerValorRadioSeleccionado(name) {
    const radio = document.querySelector(`input[name="${name}"]:checked`);
    return radio ? radio.value : null;
}