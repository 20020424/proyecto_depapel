/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author Nancy Siqueiros
 */


import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;


public class Users {
    
    private String nombre;
    private String fecha_nac;
    private String correo;
    private String pwd;

    public Users() {
    }

    public Users(String nombre, String fecha_nac, String correo, String pwd) {
        this.nombre = nombre;
        this.fecha_nac = fecha_nac;
        this.correo = correo;
        this.pwd = pwd;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPwd() {
        return pwd;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    public static ArrayList<Users> inicializaUsuarios() {
        ArrayList<Users> usersArray = new ArrayList<>();
        Users user = new Users();
        user.setNombre("Nancy Siqueiros");
        user.setFecha_nac("24/04/2002");
        user.setCorreo("nancy.siqueiros@uabc.edu.mx");
        user.setPwd("Nosepuede");
        
        usersArray.add(user);
        usersArray.add(new Users("Maria Chavez", "24/04/2002", "nc2189333@gmail.com", "Sisepuede"));
        return usersArray;
    }
    
    public static Users validaUsuarioPorCorreo(String correo, String pass) {
        ArrayList<Users> usuarios = inicializaUsuarios();
        for (Users u : usuarios) {
            if (u.getCorreo().equals(correo) && u.getPwd().equals(pass)) {
                System.out.println("Usuario encontrado");
                return u;
            }
        }
        return null;
    }
    
    public static ArrayList<Users> agregaUsuario(ArrayList<Users> usersArray, String nombre, String correo, String pwd, String fecha_nac) {
        if (usersArray == null) {
            usersArray = new ArrayList<>();
        }

        Users user = new Users();
        user.setNombre(nombre);
        user.setCorreo(correo);
        user.setPwd(pwd);
        user.setFecha_nac(fecha_nac);
        usersArray.add(user);
        System.out.println("Imprimiendo datos del usuario...");
        for (Users u : usersArray) {
            System.out.println("user = " + u.getNombre());
        }
        return usersArray;
    }
    
    public static ArrayList<Users> imprimeUsuarios() {
        ArrayList<Users> users = inicializaUsuarios();
        System.out.println("Imprimiendo usuarios actualizados");
        for (Users u : users) {
            System.out.println("user = " + u.getNombre());
        }
        return users;
    }
    
    public static boolean actualizaUsuario(String correo, String pass, String nombre) {
        boolean res = false;
        ArrayList<Users> users = inicializaUsuarios();
        int index;
        for (Users u : users) {
            if (u.getCorreo().equals(correo)) {
                index = users.indexOf(u);
                System.out.println("index=" + index);
                users.set(index, new Users(nombre, u.getFecha_nac(), correo, pass));
                res = true;
                break;
            }
        }
        imprimeUsuarios();
        return res;
    }
    
    public static boolean borrarUsuario(String correo) {
        boolean res = false;
        ArrayList<Users> users = inicializaUsuarios();
        int index;
        for (Users u : users) {
            if (u.getCorreo().equals(correo)) {
                index = users.indexOf(u);
                System.out.println("index=" + index);
                users.remove(index);
                res = true;
                break;
            }
        }
        imprimeUsuarios();
        return res;
    }
    
    public static ArrayList<Users> consultaUsuarios() {
        ArrayList<Users> users = inicializaUsuarios();
        System.out.println("usuarios " + users);
        return users;
    }
    
    public static Users consultaUsuarios(String correo) {
        ArrayList<Users> users = inicializaUsuarios();
        for (Users u : users) {
            if (u.getCorreo().equals(correo)) {
                return u;
            }
        }
        return null;
    }
    
    public static Users validaUsuarioPorCorreo(ArrayList<Users> usuarios, String correo, String pass) {
        
    for (Users u : usuarios) {
        if (u.getCorreo().equals(correo) && u.getPwd().equals(pass)) {
            System.out.println("Usuario encontrado");
            return u;
        }
    }
    
    return null;
    
    }
    
}
