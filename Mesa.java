public class Mesa {
    private int numero;
    private boolean disponivel;
    private boolean reservada;

    public Mesa(int numero) {
        this.numero = numero;
        this.disponivel = true;
        this.reservada = false;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isDisponivel() {
        return disponivel && !reservada; // A mesa só está disponível se não estiver ocupada e não estiver reservada
    }

    public boolean isReservada() {
        return reservada;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }
}
