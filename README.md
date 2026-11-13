# SD3BusinessManagerLITE

## Status do Projeto
**Em desenvolvimento** (Etapa 5 — Versionamento e Integração com Banco de Dados concluídos).

## Tecnologias Aplicadas
* **Java SE (JDK 17)** — Linguagem de programação orientada a objetos.
* **Java Swing** — Construção da interface gráfica desktop (GUI).
* **Apache Maven** — Gerenciamento de dependências e build do projeto.
* **MySQL (8.x) & MySQL Workbench** — Sistema Gerenciador de Banco de Dados Relacional (SGBDR).
* **JDBC (`mysql-connector-j`) & Padrão DAO** — Persistência e comunicação entre a aplicação Java e o banco de dados.
* **Git & GitHub** — Controle de versão e hospedagem do código-fonte.

## Time de Desenvolvedores
* **Ismael Isidio** — Desenvolvimento, arquitetura de dados e interface gráfica.

## Objetivo do Software
O **SD3BusinessManagerLITE** é um sistema desktop voltado para microempresas e prestadores de serviços técnicos de TI, criado para centralizar e agilizar o controle operacional diário. O software substitui controles manuais e planilhas dispersas por um ambiente único para cadastro de clientes, abertura e acompanhamento de Ordens de Serviço (O.S.) e visualização de indicadores gerenciais em tempo real.

## Funcionalidades do Sistema (Requisitos)
* **Autenticação de Usuários (`TelaLogin`):** Validação de credenciais de acesso diretamente na tabela `usuarios` do banco de dados MySQL.
* **Dashboard Gerencial (`TelaDashboard`):** Exibição dinâmica de indicadores consolidados do negócio: total de clientes cadastrados, quantidade de Ordens de Serviço em aberto e faturamento total das O.S. concluídas.
* **Gestão de Clientes (`TelaClientes`):** Operações completas de CRUD (cadastro, listagem, edição e exclusão) com formatação automática de telefone e persistência na tabela `clientes`.
* **Gestão de Ordens de Serviço (`TelaOrdensServico`):** Abertura, consulta, edição e exclusão de O.S. vinculadas aos clientes cadastrados (via chave estrangeira e `INNER JOIN`), com controle de status (`Aberta`, `Em Andamento`, `Concluída`) e valores.
* **Persistência Relacional (`sd3_manager`):** Estruturação em banco de dados MySQL com integridade referencial e script SQL (`script_sd3_manager.sql`) incluso para implantação.
