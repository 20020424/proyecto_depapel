/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Users;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Nancy Siqueiros
 */

import java.util.ArrayList;

@WebServlet(name = "ControllerUsuario", urlPatterns = {"/ControllerUsuario"})
public class ControllerUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private static ArrayList<Users> usuarios;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if ("logout".equals(action)) {
            // Eliminar el atributo de sesión que contiene los usuarios
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate(); // Invalidar la sesión existente
            }
            response.sendRedirect("inicio.jsp");
        } else if ("addUser".equals(action)) {
            // Registro de usuario
            String nombre = request.getParameter("nombre");
            String fechaNacimiento = request.getParameter("fecha_nacimiento");
            String correo = request.getParameter("email");
            String contrasena = request.getParameter("contrasena");

            // Asegurarse de que el ArrayList de usuarios esté inicializado
            inicializarUsuarios();

            // Agrega el nuevo usuario al ArrayList existente
            usuarios = Users.agregaUsuario(usuarios, nombre, correo, contrasena, fechaNacimiento);

            // Redirigir a index.jsp?correcto después de un registro exitoso
            response.sendRedirect("inicio.jsp?correcto");
        } else {
            // Inicio de sesión
            String correo = request.getParameter("email");
            String pass = request.getParameter("contra1");

            // Asegurarse de que el ArrayList de usuarios esté inicializado
            inicializarUsuarios();

            // Validar el usuario utilizando el ArrayList global
            Users user = Users.validaUsuarioPorCorreo(usuarios, correo, pass);

            if (user != null) {
                // Autenticación exitosa, establecer el atributo de sesión "userName"
                HttpSession session = request.getSession();
                session.setAttribute("userName", user.getNombre());
                response.sendRedirect("inicio.jsp?userName=" + user.getNombre());

            } else {
                // Autenticación fallida, redirigir con un parámetro de error
                response.sendRedirect("inicio.jsp?error=1");
            }
        }
        
    }
    
    private void inicializarUsuarios() {
        if (usuarios == null) {
            usuarios = Users.inicializaUsuarios();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
