import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nomeEvento;
    private Local local;
    private List<Participante> participantes;
    private String data;

    public Evento(String nomeEvento, Local local, String data) {
        this.nomeEvento = nomeEvento;
        this.local = local;
        this.participantes = new ArrayList<>();
        this.data = data;
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public List<Participante> getParticipantes() {
        return new ArrayList<>(participantes);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private boolean isParticipanteCadastrado(Participante participante) {
        for (Participante p : participantes) {
            if (p.getEmail().equals(participante.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public boolean cadastrarParticipante(Participante participante) {
        if (isParticipanteCadastrado(participante)) {
            System.out.println(participante.getNome() + " já está cadastrado(a) no evento " + nomeEvento);
            return false;
        }

        if (participantes.size() < local.getCapacidade()) {
            participantes.add(participante);
            return true;
        } else {
            System.out.println("Não foi possível concluir o cadastro. Capacidade máxima atingida para o evento " + nomeEvento);
            return false;
        }
    }

    public boolean cancelarInscricao(String email) {
        for (Participante participante : participantes) {
            if (participante.getEmail().equals(email)) {
                participantes.remove(participante);
                System.out.println("Inscrição cancelada.");
                return true;
            }
        }
        System.out.println("Email não encontrado.");
        return false;
    }

    public boolean verificarLotacao() {
        return participantes.size() >= local.getCapacidade();
    }

    public void gerarRelatorio() {
        System.out.println("Relatório de Participação do Evento " + nomeEvento + ":");
        System.out.println("Local: " + local.getNomeLocal() + ", Data: " + data);
        System.out.println("Total de Participantes: " + participantes.size());

    }
}