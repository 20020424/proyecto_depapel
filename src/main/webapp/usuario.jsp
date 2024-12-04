<%-- 
    Document   : usuario
    
    Author     : Nancy Siqueiros
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/usuario.css" rel="stylesheet" type="text/css">
    
    <title>Usuario</title>
</head>

<body>
    <nav class="navbar">

        

    </nav>
                    

        <div id="formulario">
            <div><h1>Iniciar Sesión</h1> </div>
            <form action="ControllerUsuario" method="POST">
                    <input type="hidden" name="action" value="addUser">
                    <div class="col" style="text-align: center;">
                        Nombre:
                    </div> 
                    <div class="col">
                        <input type="text" id="nombre" name="nombre" required style="border-radius: 20px; background-color: #FEA808;">
                    </div>
                    <p>
                    <div class="col">
                        Fecha de Nacimiento:
                    </div>
                    <div class="col">
                        <input type="date" id="fecha_nacimiento" name="fecha_nacimiento" required style="border-radius: 20px; background-color: #FEA808;">
                    </div>
                    <p>
                    <div class="col">
                        Correo Electrónico:
                    </div>
                    <div class="col">
                        <input type="email" id="email" name="email" required style="border-radius: 20px; background-color: #FEA808;">
                    </div>
                    <p>
                    <div class="col">
                        Contraseña:
                    </div> 
                    <div class="col">
                        <input type="password" id="contrasena" name="contrasena" required style="border-radius: 20px; background-color: #FEA808;">
                    </div>
                    <p>
                    <br>
                    <button type="submit" name="enviar" id="enviar">Registrar</button>
                    <br>
            </form>
                    
        </div>      
            

    <footer class="footer">
        <p>&copy; <%= new java.util.Date().getYear() + 1900 %> DePapel. All Rights Reserved. Diseño hecho por N.M.S.C</p>
    </footer>

</body>
</html>
