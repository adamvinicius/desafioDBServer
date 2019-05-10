#language: pt
Funcionalidade: Teste Alelo API

  @testeApi
  Cenario: Validacao dados com sucesso
    Dado que crio o quadro com "https://api.trello.com/1/boards/" com nome "DbServer"
    Quando crio lista do quadro ja criado com
      | nomeLista   |
      | Backlog     |
      | To Do       |
      | In Progress |
      | Testing     |
      | Done        |
    E crio o card "Teste" na lista backlog
    E atualizo o nome do card criado para "Teste Db-Server"
    E movo o card criado para
      | nomeLista   |
      | To Do       |
      | In Progress |
      | Testing     |
      | Done        |
    Entao apago o quadro criado
