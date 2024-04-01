# Sistema de Controle de Notas


O Sistema de Controle de Notas foi desenvolvido para atender à necessidade dos alunos de gerenciar suas atividades, trabalhos, médias, visualizar suas grades curriculares e acompanhar tanto o semestre atual quanto semestres anteriores.

Cadastro do Aluno:
- O sistema permite o cadastro do aluno, incluindo a geração automática do CRA (Coeficiente de Rendimento Acadêmico), que é preenchido conforme o uso do sistema.

Segurança:

- Ao cadastrar um novo aluno, a senha é criptografada utilizando o algoritmo BCryptPasswordEncoder, gerando um hash para garantir a segurança das informações do usuário.
- Foi implementado a biblioteca spring security com JWT para gerenciar a autenticação dos usuários é preciso estar autenticado com um token válido para acessar os end-points 
- Os end-points são permissionados de acordo com o grupo do usuário, sendo eles Aluno, Funcionario e Admin

Semestre: 
- A cada inicialização da aplicação, é acionado um método que gera automaticamente o semestre, verificando se o intervalo de meses desde o último semestre criado até a data atual é maior que seis.

Disciplina: 
- O sistema permite o cadastro de disciplinas e sua associação às respectivas grades curriculares de acordo com o curso do aluno.

Curso: 
- É possível cadastrar um novo curso e também buscar cursos por código, além de listar todos os cursos disponíveis.

Trabalho e Avaliação: 
- Permite o cadastro de trabalhos e avaliações, incluindo a especificação da nota total do trabalho e a nota final obtida pelo aluno.
## Autores

- [@gabrielarantes](https://github.com/arantesgabriel)
- [@gabrieljn](https://github.com/gabrieljn)
