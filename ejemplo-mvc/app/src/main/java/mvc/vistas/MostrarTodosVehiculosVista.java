package mvc.vistas;

import java.util.List;

import mvc.Vista;
import mvc.modelos.Vehiculo;

public class MostrarTodosVehiculosVista implements Vista {
    List<Vehiculo> vehiculos;

    public MostrarTodosVehiculosVista(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String procesarDatos() {
        StringBuilder sb = new StringBuilder("Lista de vehiculos:\n");

        for(Vehiculo v : vehiculos) {
            sb.append(MostrarVehiculoVista.procesarDatosVehiculo(v));
        }

        return sb.toString();
    }

}
