import { Resultado } from './Resultado';  // Importamos la interfaz

// Función para obtener los resultados de la API
const obtenerResultados = async (): Promise<Resultado[]> => {
  const response = await fetch('/api/resultados');
  if (!response.ok) {
    throw new Error('Error al obtener los resultados');
  }
  return await response.json();
};

// Función para mostrar los resultados en el grid
const mostrarResultados = async () => {
  try {
    const resultados: Resultado[] = await obtenerResultados();
    const tabla = document.getElementById('resultado-grid');
    
    if (tabla) {
      resultados.forEach(resultado => {
        const fila = document.createElement('tr');
        
        const celdaNombre = document.createElement('td');
        celdaNombre.textContent = resultado.nombre;
        fila.appendChild(celdaNombre);

        const celdaDescripcion = document.createElement('td');
        celdaDescripcion.textContent = resultado.descripcion;
        fila.appendChild(celdaDescripcion);

        const celdaValor = document.createElement('td');
        celdaValor.textContent = resultado.valor.toString();
        fila.appendChild(celdaValor);

        tabla.appendChild(fila);
      });
    }
  } catch (error) {
    console.error('Error al mostrar los resultados:', error);
  }
};

// Llamamos a la función cuando la página esté cargada
window.onload = () => {
  mostrarResultados();
};