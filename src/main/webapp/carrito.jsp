<%-- 
    Document   : carrito
    
    Author     : Nancy Siqueiros
--%>
<%@page import="Controllers.ControllerProductos"%>
<%@page import="Models.Productos"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="css/carrito.css" rel="stylesheet" type="text/css">
        <title>Carrito</title>
    </head>
    <body>
        
    <nav class="navbar">


    </nav>
                    

        <div class="container">
            <h1>Lista de Compra</h1>
            <table class="table">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Precio</th>
                        <th>Cantidad</th>
                        <th>Total</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        // Iteramos sobre la lista de productos
                        ArrayList<Productos> listaProductos = ControllerProductos.obtenerListaProductos(session);
                        ArrayList<Productos> cart = (ArrayList<Productos>) session.getAttribute("listaCompras");
                        if (cart != null && !cart.isEmpty()) {
                            double total = 0;
                            for (int i = 0; i < cart.size(); i++) {
                                Productos productoreal = listaProductos.get(i);
                            Productos producto = cart.get(i);
                                double totalProducto = producto.getPrecio() * producto.getCantidad();
                                total += totalProducto;
                    %>
                    <tr>
                        <td><%= producto.getTitulo() %></td>
                        <td>$<%= producto.getPrecio() %></td>
                        <td><%= producto.getCantidad() %></td>
                        <td>$<%= totalProducto %></td>
                        <td>
                            <%if(producto.getCantidad() < 10){%>
                            <form action="ControllerProductos" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="incrementarCantidad">
                                <input type="hidden" name="index" value="<%= i %>">
                                <button type="submit" class="btn btn-success btn-sm">+</button>
                            </form>
                            <% }%>
                            <form action="ControllerProductos" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="disminuirCantidad">
                                <input type="hidden" name="index" value="<%= i %>">
                                <button type="submit" class="btn btn-danger btn-sm">-</button>
                            </form>
                        </td>
                    </tr>
                    <%
                            }
                    %>
                    <tr>
                        <td colspan="3">Total</td>
                        <td>$<%= total %></td>
                        <td></td>
                    </tr>
                    <%
                        } else {
                    %>
                    <tr>
                        <td colspan="5">No hay productos en el carrito.</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <a href="inicio.jsp" class="btn btn-primary">Seguir comprando</a>
        </div>
        
    <footer class="footer">
        <p>&copy; <%= new java.util.Date().getYear() + 1900 %> DePapel. All Rights Reserved. Diseño hecho por N.M.S.C</p>
    </footer>  
    
    </body>
    
</html>
