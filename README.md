# EventSpot

O EventSpot é uma aplicação que permite aos usuários divulgarem e se inscreverem em eventos.

## Funcionalidades

- CRUD de usuários
- Listagem de eventos
- Criação de eventos por usuários com a role ORGANIZER
- Inscrição de usuários nos eventos
- Listagem dos eventos de cada usuário

## Tecnologias Utilizadas

- Java
- Spring Boot
- Hibernate
- H2 Database

## Executando a Aplicação

1. Clone o repositório para sua máquina local.
2. Configure as informações de banco de dados no arquivo `application.properties`.
3. Execute o aplicativo usando um IDE ou o comando `mvn spring-boot:run`.
4. Acesse `http://localhost:8080` para utilizar a aplicação.

## Funcionalidades Detalhadas

### CRUD de Usuários

A aplicação permite a criação, leitura, atualização e deleção de usuários. Os usuários podem ter diferentes roles: USER ou ORGANIZER.

### Listagem de Eventos

A lista de eventos está disponível para todos os usuários. Os eventos são organizados por data e localização.

### Criação de Eventos por Usuários com Role ORGANIZER

Usuários com a role ORGANIZER têm permissão para criar novos eventos. Eles podem especificar o nome, descrição, data, hora e localização do evento.

### Inscrição de Usuários nos Eventos

Qualquer usuário pode se inscrever em eventos disponíveis. A inscrição requer apenas a seleção do evento desejado.

### Listagem dos Eventos de Cada Usuário

Cada usuário pode visualizar a lista de eventos aos quais está inscrito.


