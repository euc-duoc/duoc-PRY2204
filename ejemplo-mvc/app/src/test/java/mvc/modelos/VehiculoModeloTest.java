package mvc.modelos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class VehiculoModeloTest {
    private final VehiculoModelo vm = new VehiculoModelo();

    @Test
    void buscarCorrecto() {
        Vehiculo v = vm.buscar("3303FNJ");
        
        assertEquals(2010, v.getAnio());
        assertEquals(5000000, v.getPrecio());
    }

    @Test
    void buscarError() {
        String patente = "AAA";

        IllegalArgumentException ex = 
            assertThrows(IllegalArgumentException.class, () ->
                vm.buscar(patente)
            );

        assertEquals("Patente '" + patente +"' no encontrada.", ex.getMessage());
    }
}
