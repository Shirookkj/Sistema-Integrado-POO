import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Evento> eventos = new ArrayList<>();

    public static void acessarSistemaClinica() {
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\n--- Sistema de Clínica ---");
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Cadastrar Médico");
            System.out.println("3. Marcar Consulta");
            System.out.println("4. Buscar Paciente");
            System.out.println("5. Gerar Relatório de Consultas");
            System.out.println("6. Voltar ao menu principal");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarPaciente(pacientes, scanner);
                    break;
                case 2:
                    cadastrarMedico(medicos, scanner);
                    break;
                case 3:
                    marcarConsulta(pacientes, medicos, consultas, scanner);
                    break;
                case 4:
                    System.out.print("Digite o CPF do paciente: ");
                    String cpfPaciente = scanner.nextLine();
                    listarConsultasPacientes(consultas, cpfPaciente);
                    break;
                case 5:
                    gerarRelatorioConsultas(consultas);
                    break;
                case 6:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 6);
    }

    public static void acessarSistemaRestaurante(ArrayList<Paciente> pacientes) {
        ArrayList<Mesa> mesas = new ArrayList<>();
        ArrayList<Pedido> pedidos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de mesas para o restaurante: ");
        int quantidadeMesas = scanner.nextInt();
        adicionarMesas(mesas, quantidadeMesas);

        int opcao;
        do {
            System.out.println("\n--- Sistema de Restaurante ---");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Fechar Pedido");
            System.out.println("3. Reservar Mesa");
            System.out.println("4. Gerar Relatório de Vendas");
            System.out.println("5. Voltar ao menu principal");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Número da mesa: ");
                    int numeroMesa = scanner.nextInt();
                    scanner.nextLine();  // Consumir o newline
                    System.out.print("Nome do item: ");
                    String nomeItem = scanner.nextLine();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço unitário: ");
                    double preco = scanner.nextDouble();

                    registrarPedido(mesas, pedidos, numeroMesa, new ItemDoPedido(nomeItem, quantidade, preco));
                    break;
                case 2:
                    System.out.print("Número da mesa para fechar o pedido: ");
                    int mesaFechar = scanner.nextInt();
                    fecharPedido(pedidos, mesaFechar, pacientes);
                    break;
                case 3:
                    System.out.print("Número da mesa para reservar: ");
                    int mesaReservar = scanner.nextInt();
                    reservarMesa(mesas, mesaReservar);
                    break;
                case 4:
                    gerarRelatorioVendas(pedidos);
                    break;
                case 5:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 5);
    }

    public static void acessarSistemaEventos() {
        Scanner leitor = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- Sistema de Eventos ---");
            System.out.println("1. Cadastrar Evento");
            System.out.println("2. Fazer Cadastro em um Evento");
            System.out.println("3. Cancelar Inscrição em um Evento");
            System.out.println("4. Verificar Lotação de um Evento");
            System.out.println("5. Gerar Relatório de Evento");
            System.out.println("6. Voltar ao menu principal");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do evento que você deseja cadastrar:");
                    String nomeEvento = leitor.nextLine();

                    System.out.println("Digite o local do evento:");
                    String nomeLocal = leitor.nextLine();

                    System.out.println("Digite o endereço do local:");
                    String endereco = leitor.nextLine();

                    System.out.println("Digite a capacidade máxima do local:");
                    int capacidade = leitor.nextInt();
                    leitor.nextLine();

                    System.out.println("Digite a data do evento (ex: 10/10/2024):");
                    String data = leitor.nextLine();

                    Local local = new Local(nomeLocal, endereco, capacidade);
                    Evento novoEvento = new Evento(nomeEvento, local, data);
                    eventos.add(novoEvento);

                    System.out.println("Evento cadastrado com sucesso!");
                    break;

                case 2:
                    if (eventos.isEmpty()) {
                        System.out.println("Não há eventos cadastrados.");
                        break;
                    }

                    System.out.println("Digite o nome do evento para cadastro:");
                    String eventoEscolhido = leitor.nextLine();
                    Evento eventoParaCadastro = buscarEventoPorNome(eventoEscolhido);

                    if (eventoParaCadastro == null) {
                        System.out.println("Evento não encontrado.");
                    } else {
                        System.out.println("Digite o seu nome:");
                        String nomeParticipante = leitor.nextLine();

                        System.out.println("Digite o seu email:");
                        String emailParticipante = leitor.nextLine();

                        Participante novoParticipante = new Participante(nomeParticipante, emailParticipante);
                        eventoParaCadastro.cadastrarParticipante(novoParticipante);

                        System.out.println("Cadastro realizado com sucesso!");
                    }
                    break;

                case 3:
                    if (eventos.isEmpty()) {
                        System.out.println("Não há eventos cadastrados.");
                        break;
                    }

                    System.out.println("Digite o nome do evento para cancelamento:");
                    String eventoCancelamento = leitor.nextLine();
                    Evento eventoParaCancelar = buscarEventoPorNome(eventoCancelamento);

                    if (eventoParaCancelar == null) {
                        System.out.println("Evento não encontrado.");
                    } else {
                        System.out.println("Digite o seu email para cancelar a sua inscrição:");
                        String emailCancelamento = leitor.nextLine();
                        eventoParaCancelar.cancelarInscricao(emailCancelamento);
                    }
                    break;

                case 4:
                    if (eventos.isEmpty()) {
                        System.out.println("Não há eventos cadastrados.");
                        break;
                    }

                    System.out.println("Digite o nome do evento para verificar lotação:");
                    String eventoLotacao = leitor.nextLine();
                    Evento eventoParaVerificar = buscarEventoPorNome(eventoLotacao);

                    if (eventoParaVerificar == null) {
                        System.out.println("Evento não encontrado.");
                    } else {
                        if (eventoParaVerificar.verificarLotacao()) {
                            System.out.println("O evento está lotado. :(");
                        } else {
                            System.out.println("Ainda há vagas disponíveis! :)");
                        }
                    }
                    break;

                case 5:
                    if (eventos.isEmpty()) {
                        System.out.println("Não há eventos cadastrados.");
                        break;
                    }

                    System.out.println("Digite o nome do evento para gerar relatório:");
                    String eventoRelatorio = leitor.nextLine();
                    Evento eventoParaRelatorio = buscarEventoPorNome(eventoRelatorio);

                    if (eventoParaRelatorio == null) {
                        System.out.println("Evento não encontrado.");
                    } else {
                        eventoParaRelatorio.gerarRelatorio();
                    }
                    break;

                case 6:
                    sair = true;
                    System.out.println("Voltando ao menu principal...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Paciente> pacientes = new ArrayList<>(); // Lista de pacientes para ser usada em todos os sistemas
        Scanner leitor = new Scanner(System.in);
        boolean sair = false;

        while (!sair) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1. Acessar Sistema de Eventos");
            System.out.println("2. Acessar Sistema de Restaurante");
            System.out.println("3. Acessar Sistema de Clínica");
            System.out.println("4. Sair");

            int opcao = leitor.nextInt();
            leitor.nextLine();

            switch (opcao) {
                case 1:
                    acessarSistemaEventos();
                    break;
                case 2:
                    acessarSistemaRestaurante(pacientes);
                    break;
                case 3:
                    acessarSistemaClinica();
                    break;
                case 4:
                    sair = true;
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }



    public static void adicionarMesas(ArrayList<Mesa> mesas, int quantidadeMesas) {
        for (int i = 1; i <= quantidadeMesas; i++) {
            mesas.add(new Mesa(i));
        }
        System.out.println(quantidadeMesas + " mesas foram adicionadas.");
    }


    public static void reservarMesa(ArrayList<Mesa> mesas, int numeroMesa) {
        Mesa mesa = buscarMesaPorNumero(mesas, numeroMesa);
        if (mesa != null && !mesa.isReservada() && mesa.isDisponivel()) {
            mesa.setReservada(true);
            System.out.println("Mesa " + numeroMesa + " foi reservada.");
        } else if (mesa != null && mesa.isReservada()) {
            System.out.println("A mesa " + numeroMesa + " já está reservada.");
        } else if (mesa != null && !mesa.isDisponivel()) {
            System.out.println("A mesa " + numeroMesa + " está ocupada e não pode ser reservada.");
        } else {
            System.out.println("Mesa " + numeroMesa + " não encontrada.");
        }
    }


    public static Mesa buscarMesaPorNumero(ArrayList<Mesa> mesas, int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa) {
                return mesa;
            }
        }
        return null;
    }


    public static void registrarPedido(ArrayList<Mesa> mesas, ArrayList<Pedido> pedidos, int numeroMesa, ItemDoPedido item) {
        Pedido pedidoAtual = null;
        for (Pedido pedido : pedidos) {
            if (pedido.mesa.getNumero() == numeroMesa && !pedido.finalizado) {
                pedidoAtual = pedido;
                break;
            }
        }

        if (pedidoAtual == null) {
            Mesa mesa = buscarMesa(mesas, numeroMesa);
            if (mesa != null) {
                mesa.setDisponivel(false);
                pedidoAtual = new Pedido(mesa);
                pedidos.add(pedidoAtual);
                System.out.println("Novo pedido iniciado na mesa " + numeroMesa);
            } else {
                System.out.println("Mesa " + numeroMesa + " não está disponível.");
                return;
            }
        }

        pedidoAtual.adicionarPedidos(item);
        System.out.println("Item adicionado ao pedido: " + item);
    }


    public static Mesa buscarMesa(ArrayList<Mesa> mesas, int numeroMesa) {
        for (Mesa mesa : mesas) {
            if (mesa.getNumero() == numeroMesa && mesa.isDisponivel()) {
                return mesa;
            }
        }
        return null;
    }

    // Função para fechar um pedido e liberar a mesa
    public static void fecharPedido(ArrayList<Pedido> pedidos, int numeroMesa, ArrayList<Paciente> pacientes) {
        for (Pedido pedido : pedidos) {
            if (pedido.mesa.getNumero() == numeroMesa && !pedido.finalizado) {
                double totalPedido = pedido.calcularTotal();


                if (!pacientes.isEmpty()) {
                    totalPedido = Math.max(totalPedido * 0.30, 0);
                    System.out.println("Desconto de R$10 aplicado por ter paciente cadastrado.");
                }

                System.out.println("Total final do pedido: R$ " + totalPedido);
                pedido.fecharPedido();
                pedido.mesa.setDisponivel(true);
                pedido.mesa.setReservada(false);
                System.out.println("Pedido da mesa " + numeroMesa + " foi fechado.");
                return;
            }
        }
        System.out.println("Não foi encontrado nenhum pedido aberto para a mesa " + numeroMesa);
    }


    public static void gerarRelatorioVendas(ArrayList<Pedido> pedidos) {
        System.out.println("Relatório de Vendas\n");
        if (pedidos.isEmpty()) {
            System.out.println("Nenhuma venda realizada.");
        } else {
            double totalVendas = 0;
            boolean temPedidosFinalizados = false;

            for (Pedido pedido : pedidos) {
                if (pedido.finalizado) {
                    System.out.println(pedido);
                    totalVendas += pedido.calcularTotal();
                    temPedidosFinalizados = true;
                }
            }

            if (!temPedidosFinalizados) {
                System.out.println("Nenhum pedido finalizado.");
            } else {
                System.out.println("Total geral de vendas: R$ " + totalVendas);
            }
        }

      }

    public static void cadastrarPaciente(ArrayList<Paciente> pacientes, Scanner scanner) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Idade do paciente: ");
        int idade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("CPF do paciente: ");
        String cpf = scanner.nextLine();

        pacientes.add(new Paciente(nome, idade, cpf));
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public static void cadastrarMedico(ArrayList<Medico> medicos, Scanner scanner) {
        System.out.print("Nome do médico: ");
        String nome = scanner.nextLine();
        System.out.print("CRM do médico: ");
        String crm = scanner.nextLine();
        System.out.print("Especialidade do médico: ");
        String especialidade = scanner.nextLine();
        System.out.print("O médico está disponível? (true/false): ");
        boolean disponibilidade = scanner.nextBoolean();

        medicos.add(new Medico(nome, crm, especialidade, disponibilidade));
        System.out.println("Médico cadastrado com sucesso!");
    }

    public static void marcarConsulta(ArrayList<Paciente> pacientes, ArrayList<Medico> medicos, ArrayList<Consulta> consultas, Scanner scanner) {
        System.out.print("Digite o CPF do paciente: ");
        String cpfPaciente = scanner.nextLine();
        Paciente paciente = verPaciente(pacientes, cpfPaciente);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.print("Digite a especialidade do médico: ");
        String especialidadeMedico = scanner.nextLine();
        Medico medico = verMedicos(medicos, especialidadeMedico);
        if (medico == null) {
            System.out.println("Nenhum médico disponível com essa especialidade.");
            return;
        }

        System.out.print("Digite a data da consulta (formato AAAA-MM-DD): ");
        String data = scanner.nextLine();

        Consulta consulta = new Consulta(paciente, medico, data);
        consultas.add(consulta);
        System.out.println("Consulta marcada com sucesso!");
    }

    public static Paciente verPaciente(ArrayList<Paciente> pacientes, String cpf) {
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                return p;
            }
        }
        return null;
    }

    public static Medico verMedicos(ArrayList<Medico> medicos, String especialidade) {
        for (Medico m : medicos) {
            if (m.getEspecialidade().equals(especialidade) && m.isDisponibilidade()) {
                return m;
            }
        }
        return null;
    }

    public static void gerarRelatorioConsultas(ArrayList<Consulta> consultas) {
        System.out.println("\nRelatório de consultas:\n");
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta realizada.");
        } else {
            for (Consulta consulta : consultas) {
                Paciente paciente = consulta.getPaciente();
                Medico medico = consulta.getMedico();
                System.out.println("Consulta: \nPaciente: " + paciente.getNome() +
                        " | CPF: " + paciente.getCpf() +
                        " | Médico: " + medico.getNome() +
                        " | Especialidade: " + medico.getEspecialidade() +
                        " | Data: " + consulta.getDataConsulta());
            }
        }
    }

    public static void listarConsultasPacientes(ArrayList<Consulta> consultas, String cpfPaciente) {
        System.out.println("Consultas do paciente com CPF: " + cpfPaciente);
        boolean encontrou = false;
        for (Consulta consulta : consultas) {
            if (consulta.getPaciente().getCpf().equals(cpfPaciente)) {
                System.out.println(consulta);
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma consulta encontrada para este paciente!");
        }
    }


    private static Evento buscarEventoPorNome(String nomeEvento) {
        for (Evento evento : eventos) {
            if (evento.getNomeEvento().equalsIgnoreCase(nomeEvento)) {
                return evento;
            }
        }
        return null;
    }
}


