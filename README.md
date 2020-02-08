# Auto-Relacionamento com JPA

Este exemplo foi construído so demanda, a pedido de [uma amiga](https://github.com/PiPolaris).

A necessidade era um mapeamento de usuários no formato de amizade, onde cada usuário pode ser amigo de qualquer outro usuário.

Eu sinceramente não tenho certeza da corretude dessa solução, mas segue o que eu consegui fazer.

## Endpoints

Todos os endpoints estão disponíveis no [Insomnia_requests.json](/Insomnia_requests.json) para serem importados no [Insomnia](https://insomnia.rest/download/). A saber:

- GET {{ host  }}/users
- GET {{ host  }}/users/1
- GET {{ host  }}/users/1/friends
- GET {{ host  }}/friends

## Estrutura do código

O código respeita a seguinte estrutura:

- O pacote `domain` contém as entidades `User` (a entidade base) e `Friend` (a entidade através da qual o auto-relacionamento é implementado).
- O pacote `infrastructure` contém:
  - O pacote `repository` com os repositórios Spring Data JPA.
  - O pacote `projection` com uma projeção para exibir a lista de amigos de um usuário sem repetir o nome do usuário na resposta.
- O pacote `web` contém:
  - O pacote `rest` com controladores REST `UserController` e `FriendController`.
  
A pasta `resources`:

- serve estaticamente o arquivo exportado do Insomnia apenas para conveniência.
- contém um arquivo `import.sql` para carregar dados na inicialização.

## Rodando o projeto

Se não vai importar na sua IDE favorita pra ela se virar, basta rodar:

```shell script
./mvnw spring-boot:run
```



