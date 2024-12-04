<%-- 
    Document   : inicio
    
    Author     : Nancy Siqueiros
--%>
<%@page import="javax.servlet.http.HttpSession"%>

<%
    String userName = request.getParameter("userName");
    HttpSession currentSession = request.getSession(false);
    String sessionUserName = (currentSession != null) ? (String) currentSession.getAttribute("userName") : null;
    if (userName != null) {
        sessionUserName = userName; // Si se proporciona un nombre de usuario en el parámetro, lo usamos
    }
%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
    
    <title>DePapel - Inicio</title>
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
                    <% if (sessionUserName != null) { %>
                    <a href="usuario.jsp"><img src="img/User2.png" alt="Usuario" class="icon user-icon"></a>
                    <% } %>
                    <a href="carrito.jsp"><img src="img/carrito.png" alt="Carrito" class="icon cart-icon"></a>
            </div>

        </div>

    </nav>

    <div class="main-content">
        <%
                    if (request.getParameter("error") != null) {
                        out.println("<p>Correo o contraseña incorrectos.</p>");
                    }
        %>
        <div class="image-box">
            
        </div>
    </div>

    <div class="sidebar">
        <h2>¡BIENVENID@!</h2>
        <br>
        <p>DePapel se enorgullece de ofrecer una amplia variedad de productos de alta calidad, a precios competitivos y con la seguridad que necesitas para tus compras.</p>
    </div>

    <footer class="footer">
        <p>&copy; <%= new java.util.Date().getYear() + 1900 %> DePapel. All Rights Reserved. Diseño hecho por N.M.S.C</p>
    </footer>

</body>
</html>
