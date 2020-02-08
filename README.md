[![Run in Insomnia}](https://insomnia.rest/images/run.svg)](https://insomnia.rest/run/?label=jpa-self-relationship&uri=https%3A%2F%2Fraw.githubusercontent.com%2Fbrunodrugowick%2Fjpa-self-relationship%2Fmaster%2Fsrc%2Fmain%2Fresources%2Fstatic%2FInsomnia_requests.json)

# Auto-Relacionamento com JPA

Este exemplo foi construído sob demanda, a pedido de [uma amiga](https://github.com/PiPolaris).

A necessidade era um mapeamento de usuários no formato de amizade, onde cada usuário pode ser amigo de qualquer outro usuário.

Eu testei dois métodos apresentados nessa pergunta do Stack Overflow: https://stackoverflow.com/questions/14633798/friend-relationships-with-jpa.

# Alternativa 1

Essa alternativa é mais complexa, mas parece ter atendido melhor os requisitos (ainda tem que testar inserção sem ser por SQL).

## Alternativa 1 - Endpoints

Todos os endpoints estão disponíveis no [Insomnia_requests.json](https://raw.githubusercontent.com/brunodrugowick/jpa-self-relationship/master/src/main/resources/static/Insomnia_requests.json) para serem importados no [Insomnia](https://insomnia.rest/download/). A saber:

- GET {{ host  }}/users
- GET {{ host  }}/users/1
- GET {{ host  }}/users/1/friends
- GET {{ host  }}/friends

## Alternativa 1 - Estrutura do Código

O código todo está dentro do pacote `firstalternative` e respeita a seguinte estrutura:

- O pacote `domain` contém as entidades `User` (a entidade base) e `Friend` (a entidade através da qual o auto-relacionamento é implementado).
- O pacote `infrastructure` contém:
  - O pacote `repository` com os repositórios Spring Data JPA.
  - O pacote `projection` com uma projeção para exibir a lista de amigos de um usuário sem repetir o nome do usuário na resposta.
- O pacote `web` contém:
  - O pacote `rest` com controladores REST `UserController` e `FriendController`.
  
# Alternativa 2

Essa alternativa parece mais simples, mas a inserção pode ficar complicada. Nesse caso eu acabei já fazendo a inserção por código.

## Alternativa 2 - Endpoints

Todos os endpoints estão disponíveis no [Insomnia_requests.json](https://raw.githubusercontent.com/brunodrugowick/jpa-self-relationship/master/src/main/resources/static/Insomnia_requests.json) para serem importados no [Insomnia](https://insomnia.rest/download/). A saber:

- GET {{ host  }}/people
- GET {{ host  }}/people/1
- GET {{ host  }}/people/1/friends

## Alternativa 2 - Estrutura do Código

O código todo está dentro do pacote `secondalternative` e respeita a seguinte estrutura:

- O pacote `bootstrap` contém um CommandLineRunner que inicializa a tabela `person` (e consequentemente a `person_friends`) com dados.
- O pacote `domain` contém a entidade `Person`. Note que nesse caso apenas uma entidade é necessária.
- O pacote `infrastructure` contém:
  - O pacote `repository` com o repositório Spring Data JPA.
- O pacote `web` contém:
  - O pacote `rest` com controlador REST `PersonController`.

# Resources (para ambas alternativas)

A pasta `resources`:

- serve estaticamente o arquivo exportado do Insomnia apenas para conveniência.
- contém um arquivo `import.sql` para carregar dados na inicialização para a Alternativa 1.
- serve um `index.html` dentro da pasta `templates` só pra facilitar a vida, também.

# Rodando o projeto

Você pode testar aqui [https://jpa-self-relationship.herokuapp.com](https://jpa-self-relationship.herokuapp.com).

Se não vai importar na sua IDE favorita pra ela se virar, basta rodar:

```shell script
./mvnw spring-boot:run
```
