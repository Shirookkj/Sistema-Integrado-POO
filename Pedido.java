import java.util.ArrayList;

public class Pedido {
    Mesa mesa;
    ArrayList<ItemDoPedido> itens;
    boolean finalizado;

    public Pedido(Mesa mesa) {
        this.mesa = mesa;
        this.itens = new ArrayList<>();
        this.finalizado = false;
    }

    public void adicionarPedidos(ItemDoPedido item) {
        itens.add(item);
    }

    public void fecharPedido() {
        this.finalizado = true; // Marca o pedido como finalizado
        mesa.setDisponivel(true); // Libera a mesa
        System.out.println("Pedido da mesa " + mesa.getNumero() + " fechado.");
    }

    public double calcularTotal() {
        double total = 0;
        for (ItemDoPedido item : itens) {
            total += item.getPreco() * item.getQuantidade();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido da Mesa ").append(mesa.getNumero()).append(":\n");
        for (ItemDoPedido item : itens) {
            sb.append(item).append("\n");
        }
        sb.append("Total: R$ ").append(calcularTotal()).append("\n");
        return sb.toString();
    }
}
