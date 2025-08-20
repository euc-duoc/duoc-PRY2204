package estructura;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import estructura.decorator.post.CoordinadorProyectos;
import estructura.decorator.post.EmpleadoGenerico;
import estructura.decorator.post.IEmpleado;
import estructura.decorator.post.Jefatura;
import estructura.decorator.pre.EmpleadoDinamico;

public class DecoratorTests {
    @Test
    public void empleadoPreTest() throws Exception {
        EmpleadoDinamico e1 = new EmpleadoDinamico("12345678", 1);
        EmpleadoDinamico e2 = new EmpleadoDinamico("87654321", 5);

        e1.agregarRol("jefatura");
        e2.agregarRol("coordinador-proyecto");

        assertEquals(1300000, e1.calcularRemuneracion());
        assertEquals(1450000, e2.calcularRemuneracion());
    }

    @Test
    public void empleadoPostTest() throws Exception {
        IEmpleado e1 = new EmpleadoGenerico("12345678", 1);
        e1 = new Jefatura(e1);

        IEmpleado e2 = new EmpleadoGenerico("87654321", 5);
        e2 = new CoordinadorProyectos(e2);

        assertEquals(1300000, e1.calcularRemuneracion());
        assertEquals(1450000, e2.calcularRemuneracion());
    }
}
