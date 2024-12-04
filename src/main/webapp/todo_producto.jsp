<%-- 
    Document   : todo_producto
    
    Author     : Nancy Siqueiros
--%>

<%@page import="Controllers.ControllerProductos"%>
<%@page import="Models.Productos"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link href="css/todo.css" rel="stylesheet" type="text/css">
    <script src="js/jsproducto.js"></script>
    <script> src="js/jsusurario.js"></script>
    
    <title>DePapel - Todos los productos</title>
</head>

<body>
    <nav class="navbar">

        <div class="navbar-content">

            <div class="navbar-menu">
                <p>
                    <ul>
                        <li><a href='todo_producto.jsp' id='t'> Todos los productos &emsp;</a></li>
                        <br>
                        <li><a href='plumas.jsp' id='p'> Plumas &emsp;</a></li>
                    </ul>
                </p>

                <p>
                    <ul>
                        <li><a href='lapices.jsp' id='l'> Lapices &emsp;</a></li>
                        <br>
                        <li><a href='papel.jsp' id='pa'> Papel &emsp;</a></li>
                    </ul> 
                </p>

                <p>
                    <ul>
                        <li><a href='marcadores.jsp' id='m'> Marcadores &emsp;</a></li>
                        <br>
                        <li><a href='cuadernos.jsp' id='c'> Cuadernos &emsp;</a></li>
                    </ul>
                </p>

                <p>
                    <ul>
                        <li><a href='pegamento.jsp' id='pe'>Pegamento &emsp;</a></li>
                        <br>
                        <li><a href='oficina.jsp' id='o'>Oficina &emsp;</a></li>
                    </ul>
                </p>   
            </div>

            <div class="icons">
                <form action="<%= request.getContextPath() %>/buscar" method="get">
                    <input type="text" name="query" placeholder="Buscar...">
                    <button type="submit">Buscar</button>
                </form>
                    
                    <a href="usuario.jsp"><img src="img/User2.png" alt="Usuario" class="icon user-icon"></a>
                    
                    <a href="carrito.jsp"><img src="img/carrito.png" alt="Carrito" class="icon cart-icon"></a>
            </div>

        </div>

    </nav>

    <div id='productos'>
        <h1>Todos los productos</h1>
    </div>
                    
    <section class="shop_section layout_padding">
        <div class="container">
            <div class="heading_container heading_center"></div>
            <div class="row" id="productos">
                <% 
                // Iteramos sobre la lista de productos
                ArrayList<Productos> listaProductos = ControllerProductos.obtenerListaProductos(session);
                for (int i = 0; i < listaProductos.size(); i++) {
                    Productos producto = listaProductos.get(i);
                %>
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="box">
                        <a>
                            <div class="img-box">
                                <img src="<%= producto.getImagen() %>" alt="" onclick="abrirModal('<%= producto.getImagen() %>')">
                            </div>
                            <div class="detail-box">
                                <h6><%= producto.getTitulo() %></h6>
                                <p>Cantidad disponible: <%= producto.getCantidad() %></p> <%-- Mostrar cantidad disponible --%>
                                <!-- Agregar al carrito llamando a la función JavaScript con el índice del producto -->
                                <button class="btn btn-primary" onclick="agregarAlCarrito(<%= i %>, '<%= producto.getTitulo() %>')">Agregar al carrito</button>

                            </div>
                        </a>
                    </div>
                </div>
                <% } %>

            </div>
        </div>
    </section>
                
    <div id="miModal" class="modal">
        <div class="modal-contenido">
            <span class="cerrar-modal" onclick="cerrarModal()">&times;</span>
            <img id="imagenModal" src="" alt="Imagen Modal">
            <h2 id="modalTitle"></h2>
            <p id="modalDescription"></p>
        </div>
    </div>
                

    <footer class="footer">
        <p>&copy; <%= new java.util.Date().getYear() + 1900 %> DePapel. All Rights Reserved. Diseño hecho por N.M.S.C</p>
    </footer>
    
    <script>
    document.addEventListener("DOMContentLoaded", function() {
        obtenerProductos(); // Llamar para obtener los productos al cargar la página
    });
    </script>

</body>
</html>