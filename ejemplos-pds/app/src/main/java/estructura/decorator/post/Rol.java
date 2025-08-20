package estructura.decorator.post;

public abstract class Rol implements IEmpleado {
    private IEmpleado empleado;

    public Rol(IEmpleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int calcularRemuneracion() {
        return empleado.calcularRemuneracion() + this.calcularBonos();
    }

    public abstract int calcularBonos();
}
