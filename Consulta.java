public class Consulta {
    private Paciente paciente;
    private Medico medico;
    private String dataConsulta;


    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public Consulta(Paciente paciente, Medico medico, String dataConsulta){
        if (medico.isDisponibilidade()){
            this.paciente = paciente;
            this.medico = medico;
            this.dataConsulta = dataConsulta;

            medico.setDisponibilidade(false);
        }
        else {
            System.out.println("Médico não disniponivel!");
        }





    }
    @Override
    public String toString() {
        return "Consulta marcada:\n" + paciente.toString() + "\n" + medico.toString() + "\nData: " + dataConsulta;
    }
}