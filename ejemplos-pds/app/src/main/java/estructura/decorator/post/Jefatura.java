package estructura.decorator.post;

public class Jefatura extends Rol {

    public Jefatura(IEmpleado empleado) {
        super(empleado);
    }

    @Override
    public int calcularBonos() {
        return 500000;
    }    
}
