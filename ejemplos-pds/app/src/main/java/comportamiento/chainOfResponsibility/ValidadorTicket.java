package comportamiento.chainOfResponsibility;

public abstract class ValidadorTicket {
    protected ValidadorTicket next;

    public abstract String getNombreValidador();
    
    public void setNext(ValidadorTicket next) {
        this.next = next;
    }

    public final EstadoTicket validarCadena(Ticket ticket) {
        System.out.println("Validando ticket '" + ticket.getId() + "' por: '" + getNombreValidador() + "'");
        EstadoTicket resultado = validar(ticket);

        if (resultado == EstadoTicket.APROBADO && next != null) {
            return next.validarCadena(ticket);
        }

        System.out.println("Resultado: '" + resultado + "'");
        return resultado;
    }

    protected abstract EstadoTicket validar(Ticket ticket);
}
