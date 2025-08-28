package mvc.vistas;

import mvc.Vista;
import mvc.modelos.Vehiculo;

public class MostrarVehiculoVista implements Vista {
    public static String procesarDatosVehiculo(Vehiculo v) {
        StringBuilder sb = new StringBuilder("=== Datos de vehículo ===\n")
            .append("Patente: ").append(v.getPatente()).append("\n")
            .append("Año: ").append(v.getAnio()).append("\n")
            .append("Precio: ").append(v.getPrecio()).append("\n");        

        return sb.toString();
    }

    private Vehiculo vehiculo;

    public MostrarVehiculoVista(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String procesarDatos() { 
        return procesarDatosVehiculo(vehiculo);
    }
}
