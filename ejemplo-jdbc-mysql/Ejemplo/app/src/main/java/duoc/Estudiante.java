
package duoc;

import java.util.ArrayList;

public class Estudiante { 
    private int rut;
    private String nombre;
    private String apellido;
    private int edad;
    private String localidad;

    public void setRut(int rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getLocalidad() {
        return localidad;
    }
    
    public String[] validar() {
        ArrayList<String> res = new ArrayList<>();
        
        if(rut == 0)
            res.add("RUT no asignado.");
        
        if(nombre == null)
            res.add("Nombre no asignado.");
        else if(nombre.equals(""))
            res.add("Nombre en blanco.");
        
        if(apellido == null)
            res.add("Nombre no asignado.");
        else if(apellido.equals(""))
            res.add("Apellido en blanco.");
        
        if(edad == 0)
            res.add("Edad no asignada.");
        
        return res.toArray(new String[0]);
    }
}
