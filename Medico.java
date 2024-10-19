public class Medico {
    private String nome;
    private String crm;
    private String especialidade;
    private boolean disponibilidade;


    public Medico(String nome, String crm, String especialidade, boolean disponibilidade){
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.disponibilidade = disponibilidade;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }


    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
    @Override
    public String toString() {
        return "Médico: " + nome + ", Especialidade: " + especialidade + ", Disponível: " + disponibilidade;
    }

}