package estructura;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import estructura.decorator.pre.EmpleadoDinamico;

public class DecoratorTests {
    @Test
    public void empleadoPreTest() throws Exception {
        EmpleadoDinamico e1 = new EmpleadoDinamico("12345678", 1);
        EmpleadoDinamico e2 = new EmpleadoDinamico("12345678", 5);

        e1.agregarRol("jefatura");
        e2.agregarRol("coordinador-proyecto");

        assertEquals(1300000, e1.calcularRemuneracion());
        assertEquals(1450000, e2.calcularRemuneracion());
    }

    @Test
    public void empleadoPostTest() throws Exception {
        
    }
}
