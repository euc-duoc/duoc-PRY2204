package mvc.modelos;

import java.util.Arrays;
import java.util.List;

import mvc.Modelo;

public class VehiculoModelo implements Modelo<Vehiculo, String> {

    private static Vehiculo[] DB = new Vehiculo[] {
        new Vehiculo("5996CMG", 2018, 10000000),
        new Vehiculo("3303FNJ", 2010, 5000000),
        new Vehiculo("4733BKN", 2008, 4200000)
    };

    @Override
    public Vehiculo buscar(String patente) {
        for(Vehiculo v : DB) {
            if(v.getPatente().equals(patente))
                return v;
        }

        throw new IllegalArgumentException("Patente '" + patente +"' no encontrada.");
    }

    @Override
    public List<Vehiculo> buscarTodos() {
        return Arrays.asList(DB);
    }
}
