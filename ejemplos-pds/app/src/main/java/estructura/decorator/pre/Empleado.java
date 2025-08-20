package estructura.decorator.pre;

public class Empleado {
    private String rut;
    private int antiguedad;

    public Empleado(String rut, int antiguedad) {
        this.rut = rut;
        this.antiguedad = antiguedad;
    }

    public String getRut() {
        return rut;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public int calcularRemuneracion() {
        return 800000 + (this.antiguedad > 3 ? this.antiguedad * 100000 : 0);
    }
}
