# Sistema de Gerenciamento de Eventos

Este projeto é um Sistema de Gerenciamento de Eventos em Java que permite o cadastro de eventos, inscrições e cancelamentos de participantes, verificação de lotação e geração de relatórios. Ele foi desenvolvido utilizando conceitos de Programação Orientada a Objetos (POO).

## Funcionalidades

- *Cadastrar Eventos:* Permite criar novos eventos com informações como nome, local, capacidade máxima e data.
- *Inscrição em Eventos:* Os participantes podem se inscrever nos eventos existentes.
- *Cancelamento de Inscrição:* Participantes podem cancelar sua inscrição em eventos através do e-mail cadastrado.
- *Verificar Lotação:* O sistema verifica se o evento atingiu sua capacidade máxima.
- *Geração de Relatórios:* Relatórios de eventos são gerados com informações sobre o local, data e total de participantes inscritos.

## Estrutura do Projeto

### 1. SistemaEventos.java
- Arquivo principal que gerencia o fluxo do sistema.
- Apresenta um menu interativo para escolher opções como:
  - Cadastro de evento.
  - Inscrição de participantes.
  - Cancelamento de inscrição.
  - Verificação de lotação.
  - Geração de relatórios.
- Usa as classes Evento, Local e Participante para operar sobre eventos.

### 2. Evento.java
- Classe que representa um evento.
- Armazena o nome do evento, o local (instância da classe Local), a lista de participantes e a data.
- Principais métodos:
  - Cadastrar Participante: Adiciona um participante ao evento.
  - Cancelar Inscrição: Remove um participante com base no e-mail.
  - Verificar Lotação: Verifica se o evento atingiu a capacidade.
  - Gerar Relatório: Gera um relatório com os detalhes do evento e participantes.

### 3. Local.java
- Representa o local onde o evento será realizado.
- Armazena o nome do local, endereço e capacidade máxima de participantes.
- Usado dentro da classe Evento.

### 4. Participante.java
- Representa um participante de um evento.
- Armazena o nome e o e-mail do participante (utilizado para cadastro e cancelamento).

# Sistema de Gerenciamento de Restaurante

Este projeto é um Sistema de Gerenciamento de Restaurante em Java, que permite o controle de mesas, pedidos, fechamento de contas e geração de relatórios de vendas. Ele foi desenvolvido utilizando conceitos de Programação Orientada a Objetos (POO).

## Funcionalidades

- *Gerenciar Mesas:* Verifica a disponibilidade, reserva e libera mesas.
- *Gerenciar Pedidos:* Cria novos pedidos para mesas específicas e fecha pedidos, liberando as mesas.
- *Fechamento de Pedidos:* Finaliza o pedido e libera a mesa para novos clientes.
- *Relatórios de Vendas:* Gera relatórios com informações sobre vendas e pedidos fechados.

## Estrutura do Projeto

### 1. SistemaRestaurante.java
- Arquivo principal que gerencia o fluxo do sistema.
- Apresenta um menu interativo com opções como:
  - Reserva de mesas.
  - Cadastro de pedidos.
  - Fechamento de pedidos.
  - Geração de relatórios de vendas.
  - Verificação da disponibilidade de mesas.
- Usa as classes Mesa, Pedido, ItemMenu e RelatorioVendas para operar o restaurante.

### 2. Mesa.java
- Classe que representa uma mesa no restaurante.
- Armazena o número da mesa, se está disponível ou reservada.
- Principais métodos:
  - Reservar: Marca a mesa como reservada.
  - Liberar: Define a mesa como disponível.

### 3. Pedido.java
- Classe que representa um pedido de uma mesa no restaurante.
- Armazena o número da mesa, os itens consumidos e se o pedido foi finalizado.
- Principais métodos:
  - Adicionar Item: Adiciona itens do menu ao pedido.
  - Fechar Pedido: Finaliza o pedido e libera a mesa.

### 4. ItemMenu.java
- Classe que representa os itens do menu.
- Armazena o nome e o preço dos itens.

### 5. RelatorioVendas.java
- Classe que gera relatórios financeiros do restaurante.
- Armazena o total de vendas e pedidos fechados.
- Principais métodos:
  - Gerar Relatório: Exibe o total de vendas e o número de pedidos realizados.
 
# Sistema de Gerenciamento de Consultas Médicas

Este projeto é um Sistema de Gerenciamento de Consultas Médicas em Java que permite o cadastro de pacientes, médicos, agendamento de consultas e geração de relatórios de consultas. Ele foi desenvolvido utilizando conceitos de Programação Orientada a Objetos (POO).

## Funcionalidades

- *Cadastrar Pacientes:* Permite o registro de novos pacientes com informações pessoais.
- *Cadastrar Médicos:* Registra novos médicos com especialidades e disponibilidade.
- *Marcar Consultas:* Os pacientes podem agendar consultas com médicos disponíveis.
- *Buscar Pacientes:* Permite buscar e listar consultas de um paciente específico.
- *Geração de Relatórios:* Relatórios de consultas são gerados com informações sobre pacientes e médicos.

## Estrutura do Projeto

### 1. SistemaConsultas.java
- Arquivo principal que gerencia o fluxo do sistema.
- Apresenta um menu interativo para escolher opções como:
  - Cadastro de pacientes.
  - Cadastro de médicos.
  - Marcação de consultas.
  - Busca de pacientes.
  - Geração de relatórios.
- Usa as classes Paciente, Medico, Consulta e RelatorioConsultas para operar o sistema de saúde.

### 2. Paciente.java
- Classe que representa um paciente.
- Armazena o nome, idade e CPF do paciente.
- Principais métodos:
  - Cadastrar Paciente: Adiciona um novo paciente ao sistema.
  
### 3. Medico.java
- Classe que representa um médico.
- Armazena o nome, CRM, especialidade e disponibilidade do médico.
- Principais métodos:
  - Cadastrar Médico: Adiciona um novo médico ao sistema.

### 4. Consulta.java
- Classe que representa uma consulta médica.
- Armazena informações sobre o paciente, médico e data da consulta.
- Principais métodos:
  - Marcar Consulta: Associa um paciente a um médico em uma data específica.

### 5. RelatorioConsultas.java
- Classe que gera relatórios de consultas.
- Armazena informações sobre consultas realizadas.
- Principais métodos:
  - Gerar Relatório: Exibe todas as consultas realizadas.
 
# 1.Quantas consultas um determinado paciente já realizou?
- Função que responde: listarConsultasPacientes()
- Pergunta: Quantas consultas o paciente com CPF "X" já realizou?
- Tomada de Decisão: Ajuda a monitorar a frequência de consultas de cada paciente, identificar pacientes com muitas consultas e oferecer-lhes atendimento personalizado ou campanhas de fidelização.

# 2. Qual é o total de vendas realizadas pelo restaurante até agora?
- Função que responde: gerarRelatorioVendas()
- Pergunta: Qual o valor total de vendas realizadas por meio dos pedidos finalizados?
- Tomada de Decisão: Auxilia a avaliar o desempenho financeiro do restaurante, ajudando a entender o volume de vendas e a tomar decisões sobre promoções ou ajustes no cardápio.

# 3. Quais eventos ainda têm vagas disponíveis?
- Função que responde: verificarLotacao()
- Pergunta: Quais eventos ainda têm vagas e não estão lotados?
- Tomada de Decisão: Permite à equipe gerenciar a divulgação de eventos com base nas vagas disponíveis, promovendo eventos com menor adesão para aumentar o número de participantes.

# 4. O restaurante tem alguma mesa atualmente reservada?
- Função que responde: reservarMesa()
- Pergunta: Há alguma mesa reservada no restaurante neste momento?
- Tomada de Decisão: Ajuda a organizar o fluxo de atendimento, especialmente em horários de pico, assegurando que as reservas sejam bem gerenciadas e a ocupação de mesas seja otimizada.

# 5. Qual a ocupação das mesas no restaurante?
- Função que responde: buscarMesa() e reservarMesa()
- Pergunta: Quais mesas estão disponíveis e quais estão ocupadas ou reservadas?
- Tomada de Decisão: Auxilia na gestão do espaço no restaurante, ajudando a entender o uso das mesas e a planejar a ocupação e o atendimento de forma mais eficiente.
