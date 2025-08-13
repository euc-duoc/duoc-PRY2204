package creacion.factory.antiguedad;

import creacion.factory.ProcesadorDocumentos;

public class ProcesadorPorAntiguedad extends ProcesadorDocumentos {

    private int min = -1;

    public ProcesadorPorAntiguedad() {
    }

    public ProcesadorPorAntiguedad(int min) {
        this.min = min;
    }

    @Override
    protected OrdenadorPorAntiguedad crearOrdenador(boolean ascendente) {
        return new OrdenadorPorAntiguedad(ascendente, this.min);
    }
}