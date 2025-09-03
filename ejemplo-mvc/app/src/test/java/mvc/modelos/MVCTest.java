package mvc.modelos;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import mvc.Modelo;
import mvc.Vista;
import mvc.vistas.MostrarTodosVehiculosVista;

public class MVCTest {
    @Test
    void simulaControladorTest() {
        Modelo<Vehiculo, String> modelo = new VehiculoModelo();
        List<Vehiculo> vehiculos = modelo.buscarTodos();

        assertEquals(3, vehiculos.size());

        Vista vista = new MostrarTodosVehiculosVista(vehiculos);
        String output = vista.procesarDatos();

        assertTrue(output.contains("5996CMG"));
        assertTrue(output.contains("3303FNJ"));
        assertTrue(output.contains("4733BKN"));
    }
}
