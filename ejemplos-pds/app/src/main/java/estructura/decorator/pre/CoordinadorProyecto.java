package estructura.decorator.pre;

public class CoordinadorProyecto extends Empleado {
    public CoordinadorProyecto(String rut, int antiguedad) {
        super(rut, antiguedad);
    }

    @Override
    public int calcularRemuneracion() {
        return super.calcularRemuneracion() + 150000;
    }
}
