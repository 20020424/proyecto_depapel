/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

document.addEventListener("DOMContentLoaded", function() {
        
    // Obtener el icono del usuario
var iconoUsuario = document.getElementById('user');

// Obtener el modal
var modal = document.getElementById('miModalSesion');

// Obtener el elemento para cerrar el modal
var spanCerrar = document.getElementsByClassName("cerrar-modal")[0];

// Función para abrir el modal
function abrirModal() {
    modal.style.display = "block";
}

// Función para cerrar el modal
function cerrarModal() {
    modal.style.display = "none";
}

// Abrir el modal cuando se haga clic en el icono del usuario
iconoUsuario.onclick = abrirModal;

// Cerrar el modal cuando se hace clic en el botón de cerrar
spanCerrar.onclick = cerrarModal;

// Cerrar el modal cuando se hace clic fuera de él
window.onclick = function(event) {
    if (event.target == modal) {
        cerrarModal();
    }

}

function redirigirAMenu() {
            window.location.href = "todo_producto.jsp"; 
        }

});


