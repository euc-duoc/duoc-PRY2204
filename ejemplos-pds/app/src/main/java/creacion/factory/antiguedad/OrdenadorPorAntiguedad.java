package creacion.factory.antiguedad;

import java.util.Arrays;

import creacion.factory.Documento;
import creacion.factory.OrdenadorDocumentos;

class OrdenadorPorAntiguedad implements OrdenadorDocumentos {

    private boolean ascendente;
    private int min;

    public OrdenadorPorAntiguedad(boolean ascendente, int min) {
        this.ascendente = ascendente;
        this.min = min;
    }

    @Override
    public Documento[] ordenar(Documento[] documentos) {
        Documento[] nuevos = Arrays.asList(documentos)
            .stream()
            .filter(d -> this.min == -1 || d.getAntiguedad() > this.min)
            .toArray(Documento[]::new);

        Arrays.sort(nuevos, (d1, d2) -> {
            int comparacion = Integer.compare(d1.getAntiguedad(), d2.getAntiguedad());
            return ascendente ? comparacion : -comparacion;
        });

        return nuevos;
    }
}