package mvc;

public class Controlador {
    protected MotorVista motorVista;

    public Controlador(MotorVista motorVista) {
        this.motorVista = motorVista;
    }    

    public final void mostrarVista(Vista vista) {
        motorVista.mostrar(vista);
    }
}
