package mvc;

public class SOPMotorVista implements MotorVista {
    @Override
    public void mostrar(Vista vista) {
        System.out.println(vista.procesarDatos());
    }
}
