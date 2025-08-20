package estructura.decorator.post;

public class CoordinadorProyectos extends Rol {

    public CoordinadorProyectos(IEmpleado empleado) {
        super(empleado);
    }

    @Override
    public int calcularBonos() {
        return 150000;
    }    
}
