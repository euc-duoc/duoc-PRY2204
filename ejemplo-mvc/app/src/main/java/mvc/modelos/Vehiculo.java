package mvc.modelos;

public class Vehiculo {
    private String patente;
    private int anio;
    private int precio;

    public Vehiculo(String patente, int anio, int precio) {
        this.patente = patente;
        this.anio = anio;
        this.precio = precio;
    }

    public int getAnio() {
        return anio;
    }

    public String getPatente() {
        return patente;
    }

    public int getPrecio() {
        return precio;
    }
}
