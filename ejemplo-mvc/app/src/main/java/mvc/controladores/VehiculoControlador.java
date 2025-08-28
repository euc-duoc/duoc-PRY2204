package mvc.controladores;

import java.util.List;

import mvc.Controlador;
import mvc.SOPMotorVista;
import mvc.modelos.Vehiculo;
import mvc.modelos.VehiculoModelo;
import mvc.vistas.MostrarTodosVehiculosVista;
import mvc.vistas.MostrarVehiculoVista;

public class VehiculoControlador extends Controlador {
    private VehiculoModelo modelo;

    public VehiculoControlador() {
        super(new SOPMotorVista());
        this.modelo = new VehiculoModelo();
    }

    public void buscarVehiculo(String patente) {
        Vehiculo v = modelo.buscar(patente);        
        mostrarVista(new MostrarVehiculoVista(v));
    }

    public void mostrarTodosLosVehiculos() {
        List<Vehiculo> vehiculos = modelo.buscarTodos();
        mostrarVista(new MostrarTodosVehiculosVista(vehiculos));
    }
}
