/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Productos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ControllerProductos", urlPatterns = {"/ControllerProductos"})
public class ControllerProductos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String accion = request.getParameter("accion");
            HttpSession session = request.getSession();
            
            if ("agregar".equals(accion)) {
                int index = Integer.parseInt(request.getParameter("index"));
                agregarAlCarrito(session, index);
                out.write("Producto agregado al carrito correctamente.");
            } else if ("obtenerProductos".equals(accion)) {
                ArrayList<Productos> listaProductos = obtenerListaProductos(session);
                for (Productos producto : listaProductos) {
                    out.write("<div class=\"col-sm-6 col-md-4 col-lg-3\">");
                    out.write("<div class=\"box\">");
                    out.write("<a>");
                    out.write("<div class=\"img-box\">");
                    out.write("<img src=\"" + producto.getImagen() + "\" alt=\"\" onclick=\"abrirModal('" + producto.getImagen() + "')\">");
                    out.write("</div>");
                    out.write("<div class=\"detail-box\">");
                    out.write("<h6>" + producto.getTitulo() + "</h6>");
                    out.write("<p>Cantidad disponible: " + producto.getCantidad() + "</p>");
                    out.write("<button class=\"btn btn-primary\" onclick=\"agregarAlCarrito(" + listaProductos.indexOf(producto) + ", '" + producto.getTitulo() + "')\">Agregar al carrito</button>");
                    out.write("</div>");
                    out.write("</a>");
                    out.write("</div>");
                    out.write("</div>");
                }
            } else {
                out.write("Acción no válida.");
            }
        } catch (Exception e) {
            response.getWriter().write("Error al procesar la solicitud: " + e.getMessage());
        }
        
    }
    
    
        public static ArrayList<Productos> obtenerListaProductos(HttpSession session) {
        ArrayList<Productos> listaProductos = (ArrayList<Productos>) session.getAttribute("listaProductos");
        if (listaProductos == null) {
            listaProductos = Productos.inicializaProductos();
            session.setAttribute("listaProductos", listaProductos);
        }
        return listaProductos;
    }

    public static void agregarAlCarrito(HttpSession session, int index) {
    ArrayList<Productos> listaProductos = obtenerListaProductos(session);
    Productos producto = listaProductos.get(index);

    // Verificar si hay suficiente cantidad disponible para agregar al carrito
    if (producto.getCantidad() > 0) {
        producto.comprarProducto();
        session.setAttribute("listaProductos", listaProductos);
        ArrayList<Productos> listaCompras = obtenerListaCompras(session);

        boolean found = false;
        for (Productos prod : listaCompras) {
            if (prod.equals(producto)) {
                prod.incrementarCantidad(1);
                found = true;
                break;
            }
        }

        if (!found) {
            Productos nuevoProducto = new Productos(producto.getImagen(), producto.getTitulo(), producto.getPrecio(), producto.getDescripcion(), 1);
            listaCompras.add(nuevoProducto);
        }

        session.setAttribute("listaCompras", listaCompras);
    } else {
        // Manejar el caso cuando la cantidad disponible es 0
        // Esto puede incluir lanzar una excepción, registrar un mensaje de error, etc.
        throw new RuntimeException("No hay cantidad disponible para agregar al carrito para el producto: " + producto.getTitulo());
    }
}
    
        private void incrementarCantidad(HttpSession session, int index) {
    ArrayList<Productos> listaCompras = obtenerListaCompras(session);
    Productos productoCarrito = listaCompras.get(index);

    // Verificar si la cantidad en el carrito es mayor que 0
    if (productoCarrito.getCantidad() > 0) {
        productoCarrito.incrementarCantidad(1);

        // Actualizar la cantidad disponible en la lista de productos
        ArrayList<Productos> listaProductos = obtenerListaProductos(session);
        Productos producto = listaProductos.stream()
                                            .filter(p -> p.equals(productoCarrito))
                                            .findFirst()
                                            .orElse(null);
        if (producto != null) {
            producto.comprarProducto();
            session.setAttribute("listaProductos", listaProductos);
        }
    } else {
        // Manejar el caso cuando la cantidad en el carrito es 0
        // Esto puede incluir lanzar una excepción, registrar un mensaje de error, etc.
        System.out.println("No se puede incrementar la cantidad para el producto: " + productoCarrito.getTitulo() + " porque ya ha alcanzado su límite.");
    }

    // Actualizar la lista de compras en la sesión
    session.setAttribute("listaCompras", listaCompras);
}
        
        private void disminuirCantidad(HttpSession session, int index) {
    ArrayList<Productos> listaCompras = obtenerListaCompras(session);
    Productos productoCarrito = listaCompras.get(index);

    productoCarrito.incrementarCantidad(-1);
    if (productoCarrito.getCantidad() <= 0) {
        listaCompras.remove(index);
    }

    ArrayList<Productos> listaProductos = obtenerListaProductos(session);
    Productos producto = listaProductos.stream()
    .filter(p -> p.equals(productoCarrito))
    .findFirst()
    .orElse(null);

    // Incrementar la cantidad disponible en el inventario
    if (producto != null) {
        producto.incrementarCantidad(1);
    }

    session.setAttribute("listaCompras", listaCompras);
    session.setAttribute("listaProductos", listaProductos);
}
        
        public static ArrayList<Productos> obtenerListaCompras(HttpSession session) {
        ArrayList<Productos> listaCompras = (ArrayList<Productos>) session.getAttribute("listaCompras");
        if (listaCompras == null) {
            listaCompras = new ArrayList<>();
            session.setAttribute("listaCompras", listaCompras);
        }
        return listaCompras;
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
                HttpSession session = request.getSession();
        String action = request.getParameter("action");
        int index = Integer.parseInt(request.getParameter("index"));

        if ("incrementarCantidad".equals(action)) {
            incrementarCantidad(session, index);
        } else if ("disminuirCantidad".equals(action)) {
            disminuirCantidad(session, index);
        }

        response.sendRedirect("carrito.jsp");
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
