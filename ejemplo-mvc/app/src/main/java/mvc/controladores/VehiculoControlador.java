package mvc.controladores;

import mvc.Controlador;
import mvc.SOPMotorVista;
import mvc.modelos.Vehiculo;
import mvc.modelos.VehiculoModelo;
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

}
