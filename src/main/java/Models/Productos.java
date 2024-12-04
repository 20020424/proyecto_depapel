/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Nancy Siqueiros
 */
import java.util.ArrayList;
import java.util.Objects;

public class Productos {
    private String imagen;
    private String titulo;
    private double precio;
    private String descripcion;
    private int cantidad; // Nuevo campo

            
    // Constructor actualizado
    public Productos(String imagen, String titulo, double precio, String descripcion,int cantidad) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.precio = precio;
        this.descripcion = descripcion;
        this.cantidad = cantidad; // Inicializa la cantidad a 0
    }

    // Getters y setters
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Método para mostrar información del producto
    public void mostrarProducto() {
        System.out.println("Producto: " + titulo);
        System.out.println("Precio: $" + precio);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Imagen: " + imagen);
        System.out.println("Cantidad: " + cantidad); // Añadido para mostrar la cantidad
    }
    public static ArrayList<Productos> inicializaProductos() {
        ArrayList<Productos> listaProductos = new ArrayList<>();
        listaProductos.add(new Productos("img_productos/papel_blanco.jpg", " PEN + GEAR Papel Blanco ", 70, "500 HOJAS 75GR", 10));
        listaProductos.add(new Productos("Imagenes/manzana.png", "MANZANA", 60, "Rol de canela relleno con mermelada natural de manzana y topping de nuestro glaseado queso crema.", 10));
        listaProductos.add(new Productos("Imagenes/moras.png", "MORAS", 60, "Rol de canela relleno con mermelada natural de moras y topping de nuestro glaseado queso crema.", 10));
        listaProductos.add(new Productos("Imagenes/duo.png", "DÚO", 60, "Rol de canela con líneas de nuestro glaseado queso crema y líneas de crema de avellanas como topping.", 10));
        listaProductos.add(new Productos("Imagenes/fresa.png", "FRESA CHEESECAKE", 65, "Rol de canela con nuestro glaseado queso crema, líneas de puré de fresa y galleta molida como topping.", 10));
        listaProductos.add(new Productos("Imagenes/lotus.png", "LOTUS BISCOFF", 70, "Rol de canela con líneas de nuestro glaseado queso crema, líneas de toffee y galleta Lotus Biscoff molida como topping.", 10));
        listaProductos.add(new Productos("Imagenes/smores.png", "SMORE'S", 60, "Rol de canela con topping de crema de avellanas, mini bombones tostados y trozos de galleta de miel.", 10));
        listaProductos.add(new Productos("Imagenes/nuez.png", "NUEZ", 65, "Rol de canela con topping de nuestro glaseado queso crema  y nuez tostada molida.", 10));
        listaProductos.add(new Productos("Imagenes/toffee.png", "TOFFEE NUT", 65, "Rol de canela con topping de nuestro glaseado queso crema, salsa de caramelo casera y nuez tostada molida.", 10));
        listaProductos.add(new Productos("Imagenes/cajeta.png", "CAJETA ROL", 65, "Rol de canela con topping de cajeta y nuez tostada.", 10));
        listaProductos.add(new Productos("Imagenes/sanwis.png", "SÁNDWICH ROLÓN", 75, "Nuestro rol de canela clásico partido por la mitad, con una orden de nieve en el centro.", 10));
        listaProductos.add(new Productos("Imagenes/bites.png", "ROLÓN BITES", 60, "Rol partido en cuadritos para comer con mayor comódidad. Escoge cualquiera de nuestros roles y hazlo BITES. (El precio depende del sabor que se escoja)", 10));
        listaProductos.add(new Productos("Imagenes/imagen1.jpg", "ICED LATTE", 50, "Leche + shot de espresso.", 10));
        listaProductos.add(new Productos("Imagenes/imagen6.jpg", "COLD BREW", 40, "Café frío.", 10));
        listaProductos.add(new Productos("Imagenes/dalgona.png", "DALGONA", 45, "Vaso de leche con espuma hecha a base de café instantáneo, azúcar y agua.", 10));
        listaProductos.add(new Productos("Imagenes/chocolatada.png", "CHOCOLATADA", 55, "Leche con chocolate con crema batida, chocolate rayado y barquillo como topping.", 10));
        listaProductos.add(new Productos("Imagenes/tisana.png", "TISANA", 45, "Infusión de frutas deshidratadas. Endulza con azúcar, jarabe o miel.", 10));
        listaProductos.add(new Productos("Imagenes/matcha.png", "MATCHA LATTE", 55, "Té verde matcha + leche (endulzado con leche condensada) ", 10));
        listaProductos.add(new Productos("Imagenes/Berry.png", "BERRY MATCHA", 65, "Matcha latte endulzado con puré de fresa natural.", 10));
        listaProductos.add(new Productos("Imagenes/chai.png", "CHAI LATTE", 65, "Chai de especias con leche.", 10));
        listaProductos.add(new Productos("Imagenes/coca.jpg", "SODA", 15, "Soda", 10));
        listaProductos.add(new Productos("Imagenes/awa.jpg", "AGUA", 15, "Agua", 10));
        listaProductos.add(new Productos("Imagenes/leche.jpg", "VASO DE LECHE", 25, "Leche", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "LATTE", 50, "Leche texturizada + 1 shot de espresso. Endulza al gusto.  ", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "CAPPUCCINO", 50, "Leche texturizada, shot de espresso y espuma de leche. Endulza al gusto.", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "MOCHA", 55, "Leche texturizada, shot de espresso y cocoa. Endulza al gusto.", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "CHOCOLATE CALIENTE", 50, "Cocoa turin endulzada con leche texturizada.", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "MATCHA LATTE CALIENTE", 55, "Té verde matcha + leche texturizada (endulzado con leche condensada)", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "TISANA CALIENTE", 45, "Infusión de frutas deshidratadas. Endulza con azúcar, jarabe o miel.", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "CHAI LATTE CALIENTE", 60, "Chai de especias con leche texturizada.", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "CAFE DEL DIA", 35, "Café regular de cafetera. Agrega leche y azúcar al gusto.", 10));
        listaProductos.add(new Productos("Imagenes/vaso_1.png", "ESPRESSO",30, "Shot de espresso.", 10));
        return listaProductos;
    }
    
    public void comprarProducto() {
        if (cantidad > 0) {
            this.cantidad = --cantidad; // Disminuir la cantidad disponible en 1
        }
    }
    
    // Método para incrementar la cantidad
    public void incrementarCantidad(int cantidad) {
        this.cantidad += cantidad;
    }
    
    public boolean puedeIncrementarCantidad(int cantidad) {
    return this.cantidad >= cantidad;
}
    public boolean puedeIncrementarCantidad() {
    if(this.cantidad <= 0){
        return false;
    }
    return true;
}

    /**
     *
     * @param o */
    
    
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Productos producto = (Productos) o;
        return titulo.equals(producto.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo);
    }

}
