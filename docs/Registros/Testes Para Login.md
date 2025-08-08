##### Dia 02/08 - Primeiras linhas de código.

Durante a semana foram feitos os protótipos (mais para esqueletos) das telas de login e criação de personagem, assim como decidido a estética do projeto como um todo. Tirei o dia 02 para programar funções iniciais (login e cadastro) para não perder o ritmo. 

A primeira tarefa do dia foi organizar certas informações importantes do projeto. Foi decidido o nome: *Arcanum*, posteriormente *The Arkanum* (*thearkanum.com*) devido a indisponibilidade de *arcanum.com*. Após isso foi feita uma rápida pesquisa sobre hospedagem de banco de dados na nuvem e deploy de paginas, ainda está sendo estudado a melhor maneira de prosseguir com o projeto - serão verificadas no futuro questões de segurança para armazenamento de private keys e proteção de dados. 

Após isso o restante do dia foi dedicado para o inicio da programação do backend em *Spring*, as! primeiras implementações foram criação das *entitys*, *repositorys*, *controllers* e *dtos*. Com isso foi possível implementar as duas primeiras funcionalidades básicas: o cadastro de usuários e o login de usuário.  Também foi criado a função de criar personagem vinculado a um usuário. 

Isso me tirou o dia todo considerando tempo de estudo do JWT e Spring Security + Implementação e testes básicos utilizando o https://www.usebruno.com/

##### Dia 03/08 - Melhorias de Segurança

Depois de perceber uma falhas grotescas de segurança em relação ao repositorio no Github, tirei o dia para concertar esses problemas. 

Na parte da tarde integrei o Back com o Front de maneira mais completa e criei uma página de "home" e uma de "welcome". Muito rústicas.

##### Dia 08/08 - Login e Cadastro Finalizados

Fiquei a **semana inteira** pesquisando e buscando mais informações sobre validação de JWT e boas práticas de segurança e finalmente consegui implementar o protótipo de login e cadastro finalizados e de maneira satisfatória. 

O React agora funciona bacana armazenando o *accessToken* no *localstorage* e utilizando ele para validar as informações que vão vir a ser necessárias no futuro. Respeitosamente isso fritou todos os meus neurônios mas não vou para pra não perder o ritmo. 

O próximo passo é realizar testes unitários e polir os erros desta parte para deixar ela nos trinques.