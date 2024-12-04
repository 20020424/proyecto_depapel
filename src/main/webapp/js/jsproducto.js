/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener("DOMContentLoaded", function() {
    // Obtener todas las imágenes del menú
    var menuImages = document.querySelectorAll(".img-box img");

    // Obtener el modal y los elementos para mostrar la imagen, título y descripción
    var modal = document.getElementById('miModal');
    var modalImage = document.getElementById('imagenModal');
    var modalTitle = document.getElementById('modalTitle');
    var modalDescription = document.getElementById('modalDescription');

    // Función para abrir el modal con la imagen, título y descripción correspondientes
    function abrirModal(imageSrc, title, description) {
        modalImage.src = imageSrc;
        modalTitle.textContent = title;
        modalDescription.textContent = description;
        modal.style.display = "block";
    }

    // Asignar evento de clic a cada imagen del menú
    menuImages.forEach(function(image) {
        image.addEventListener("click", function() {
            var imageSrc = this.src; // Obtener la ruta de la imagen
            var title = this.getAttribute('data-title'); // Obtener el título de la imagen
            var description = this.getAttribute('data-description'); // Obtener la descripción de la imagen
            abrirModal(imageSrc, title, description); // Abrir el modal con la información correspondiente
        });
    });

    // Obtener el elemento para cerrar el modal
    var spanCerrar = document.getElementsByClassName("cerrar-modal")[0];

    function cerrarModal() {
        modal.style.display = "none"; // Ocultar el modal
        modalImage.src = ""; // Limpiar la imagen del modal
    }

    // Cerrar el modal cuando se hace clic en el botón de cerrar
    spanCerrar.onclick = cerrarModal;

    // Cerrar el modal cuando se hace clic fuera de él
    window.onclick = function(event) {
        if (event.target == modal) {
            cerrarModal();
        }
    }
});


function obtenerProductos() {
    fetch('ControllerProductos?accion=obtenerProductos')
        .then(response => response.text())
        .then(data => {
            document.getElementById("productos").innerHTML = data;
        })
        .catch(error => console.error('Error:', error));
}

function agregarAlCarrito(index, nombre) {
    fetch('ControllerProductos?accion=agregar&index=' + index)
        .then(response => response.text())
        .then(data => {
            alert(nombre + " agregado al carrito.");
            obtenerProductos(); // Actualizar la lista de productos después de agregar al carrito
        })
        .catch(error => console.error('Error:', error));
}



