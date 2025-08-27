package mvc.vistas;

import mvc.Vista;
import mvc.modelos.Vehiculo;

public class MostrarVehiculoVista implements Vista {
    private Vehiculo vehiculo;

    public MostrarVehiculoVista(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String procesarDatos() {
        StringBuilder sb = new StringBuilder("=== Datos de vehículo ===\n")
            .append("Patente: ").append(vehiculo.getPatente()).append("\n")
            .append("Año: ").append(vehiculo.getAnio()).append("\n")
            .append("Precio: ").append(vehiculo.getPrecio()).append("\n");        

        return sb.toString();
    }
}
