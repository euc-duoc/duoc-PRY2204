package mvc;

import mvc.controladores.VehiculoControlador;

public class Enrutador {
    public static void main(String[] args) {
        if(args.length < 1)
            throw new IllegalArgumentException("Ruta no especificada.");

        VehiculoControlador vc = new VehiculoControlador();

        try {
            switch(args[0]) {
                case "buscar-vehiculo": {
                    if(args.length < 2)
                        throw new IllegalArgumentException("Patente no especificada.");

                    vc.buscarVehiculo(args[1]);
                    break;
                }
                case "mostrar-todos": {
                    vc.mostrarTodosLosVehiculos();
                    break;
                }
                default: throw new IllegalArgumentException("Ruta no encontrada: '" + args[0] + "'.");
            }
        } 
        catch (Exception e) {
            System.out.println("Error al ejecutar controlador: " + e.getMessage());
        }
        
    }
}
