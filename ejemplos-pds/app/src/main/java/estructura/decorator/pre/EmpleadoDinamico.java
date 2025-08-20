package estructura.decorator.pre;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoDinamico extends Empleado{
    private List<String> roles = new ArrayList<>();

    public EmpleadoDinamico(String rut, int antiguedad) {
        super(rut, antiguedad);
    }

    public void agregarRol(String rol) {
        if(!this.roles.contains(rol))
            this.roles.add(rol);
    }

    @Override
    public int calcularRemuneracion() {
        int bonos = 0;

        if(roles.contains("jefatura"))
            bonos += 500000;

        if(roles.contains("coordinador-proyecto"))
            bonos += 150000;

        return super.calcularRemuneracion() + bonos;
    }
}
