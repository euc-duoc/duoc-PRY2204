package estructura.decorator.pre;

public class Jefatura extends Empleado {
    public Jefatura(String rut, int antiguedad) {
        super(rut, antiguedad);
    }

    @Override
    public int calcularRemuneracion() {
        return super.calcularRemuneracion() + 500000;
    }
}
