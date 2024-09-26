<h1>Trabalho: Ementor-Plus</h1>

Trabalho desenvolvido na disciplina de Programação Orientada a Objeto, onde o foco é o desenvolvimento de um sistema que gerencia o cadastro de alunos e professores, através do uso de interfaçes gráficas, e armazanar os dados cadastrados no banco de dados usando MySQL.

<h3>Enunciado do trabalho:</h3>

Desenvolva um programa em Java, denominado eMentor-Plus, que contenha as Classes
Pessoa, Usuario, Aluno, Egressos, Turma e Professor. A Classe mãe Pessoa deve possuir os
atributos de Nome, Data de Nascimento, CPF, Telefone, Rua, Bairro, Cidade e Estado. Em
relação aos métodos, devem ser implementados os métodos construtor padrão e construtor
para inicializar todos os atributos.
A subclasse Usuário deve possuir os atributos: Nome do Usuario, Senha e Nivel de Acesso (de
1 a 3 – para futuras implementações); com os métodos: construtor padrão, setDados,
getNomoUsuario; getSenha. O objetivo dessa classe é gerenciar os acessos ao ementor-Plus,
sendo assim, devendo para entrar no software informar usuário e senha. Estes previamente
definidos (podendo ser cadastrados diretamente no console do banco de dados pelo comando
insert into Nome da Tabela). Caso o usuário e senha estiverem corretos chama-se uma
interface gráfica contendo o Menu de opções: Cadastrar Aluno, Cadastrar Egresso, Cadastrar
Professor; Listar Aluno; Listar Egresso; Listar Professor; Alterar dados Aluno; Alterar dados
Egresso; Alterar dados Professor. A partir desse ponto outras interfaces gráficas com suas
respectivas funcionalidades serão invocadas.
A Subclasse Aluno, filha de Pessoa, deve conter os atributos de Matrícula, Período, Turma e
Notas, sendo esse um vetor de até 10 posições, assim como os métodos: Construtor padrão;
construtor para inicializar todos os atributos; setDados para inicializar todos os atributos após
a criação dos objetos; getMatricula e getPeriodo para recuperar esses atributos; e outro
método para imprimir os dados (preferencialmente utilizar mensagens gráficas de dialogo).
Sobreleva-se que, deve haver também uma interface gráfica para cadastrar as notas para cada
aluno em separado ao cadastro de aluno. Para tal, deve-se buscar o aluno pela matrícula e
adicionar a quantidade de notas bem como o valor de cada nota no vetor de notas da classe
aluno.

Em face do acima expendido, deve-se criar uma classe Turma contendo os atributos código da
turma, nome da turma e campo capaz de guardar os alunos vinculados a cada Turma
cadastrada, essa associando-se com a classe Aluno pelo matrícula (aluno) e código de turma
(turma). Os métodos devem ser aqueles capazes de gerenciar as turmas a serem criadas
conjuntamente a seus alunos vinculados.
Tocante a subclasse Egresso, filha de Aluno, deve conter os atributos de Profissão Atual, Faixa
Salarial, Curso Anterior, Curso Atual. Os métodos são todos aqueles inerentes a de aluno,
lembrando dos atributos adicionais. Em outros termos, aplicar a sobrescrita.
Quanto a Subclasse Professor, filha de Pessoa, deve possuir os atributos de Data de Admissão,
Cargo chefia (sim/não); Cargo de coordenação (sim ou não) e Salário Bruto. Os métodos a
serem implementados para essa subclasse são: Construtor padrão; construtor para inicializar
todos os atributos; setDados para inicializar os atributos depois de criados os objetos;
getDataAdmissao e getSalarioBruto para recuperar esses atributos; imprimir dados; calcular
salário bruto (salário base + adicional chefia + adicional coordenação); e calcular salário líquido
(de forma simplificada considerar desconto de 14% de INSS para todas as faixas de salário e
22,5% de IRPF para salários maiores ou iguais que R$ 5.000,00, os salários menores que o valor
citado deve ter desconto apenas de INSS).

Requisitos gerais para a solução:

1) Os atributos da classe mãe devem ter o modificador de acesso protegido e das
subclasses privados;
2) Utilizar interfaces gráficas para Cadastrar Alunos, Cadastrar Professores, bem como
Listar e Alterar Dados dos Alunos, Egressos, Turmas e Professores. Para facilitar é
recomendável construir uma interface gráfica com um Menu de opções. O referido
Menu pode ser feito por botões maiores dispostos na interface gráfica;
3) Utilizar Interfaces gráficas contendo três tabelas (JTable) contendo os dados de
alunos, egressos e professores cadastrados;
4) Aplicar o uso de Banco de Dados, em particular, o MySQL, conforme apresentado nas
aulas, devendo ter uma classe destinada para essa finalidade, contemplando os
métodos de conectar, desconectar, gravar, recuperar dados e alterar dados fazendo
uso de Lista de Objetos;
5) Criar uma Base de Dados no MySQL denominada ementor-Plus com as tabelas:
Pessoa, Usuario, Aluno, Egresso, Turma e Professor, com os respectivos campos que
reflitam os atributos das classes implementadas no Java;
6) As inserções devem ser aplicadas pelo comando insert into Table e as alterações dos
dados pelo comando update Table, por exemplo: update ementor.pessoa set
pessoa.Nome="Fulado de tal" where pessoa.CPF="12345678910". Nesse sentido,
deverá ter uma interface solicitando a chave primária a ser recuperada, por exemplo,
CPF ou Matricula, para alteração dos dados, trazendo os campos para um formulário
e editar aqueles desejados;

7) Produzir um log de erros para a aplicação, isto é, a cada erro identificado deve ser
registrado em um arquivo erros.dat, com a respectiva codificação e descrição do erro.
8) Os desenvolvedores ficam livres para organizar as interfaces gráficas e os métodos
conforme seus conhecimentos e suas preferências, assim, também, outros métodos
podem ser implementados em quais quer classes, conforme identificados pela equipe
de trabalho;
9) A ratificar o item (7) deve-se ter extremo cuidado e habilidades na construção das
interfaces gráficas. Isso inclui, mas não apenas: botões de voltar para a interface
anterior, botões de avançar e retroceder nos registros a serem alterados ou apenas
visualizados, seleções intuitivas, uso de ícones inerentes a cada ação, mensagens de
diálogos, empregos de tratamento de exceções, barra de percentual de
processamento para salvar e alterar dados (Threads).
10) Deve existir uma opção de impressão dos cadastros de Alunos, Egressos, Professores
e Turmas com notas e médias. Cada relatório deve ser apresentado em PDF.
