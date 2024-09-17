package ementor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConexoesMySQL {

    /*Secão de atributos/variaveis iniciais */
    private final String caminho = "localhost"; //Indica que usaremos o server na máquina
    private final String porta = "3306"; //Porta padrão de Conexão do MySQL Server
    private final String nome = "ementor"; //Nome da nossa base de dados
    private final String usuario = "root"; //Usuario padrão do MySQL
    private final String senha = ""; // Senha definida no momento da instalação do MySQL
    private final String FusoHorario = "?useTimezone=true&serverTimezone=UTC";
    private final String URL = "jdbc:mysql://" + caminho + ":" + porta + "/" + nome + FusoHorario; //Ajusta o fuso horário em relação a sede da Oracle 

    public static int countTurmas = 0;

    public Connection realizaConexaoMySQL() {
        try {
            return DriverManager.getConnection(URL, usuario, senha); //Estabelece a conexão via conector j

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    /////////////////////////////////////////////////////////////////////
    public void desconectaMySQL(Connection conexao) {
        try {
            if (conexao != null) {
                conexao.close();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
    }

    ////////////////////////////// FUNÇÕES DE INSERÇÃO ////////////////////////////////////////
    public void insereDadosPessoaNoMySQL(String nome, long CPF, String contato, String Data, String Rua, String Bairro, String Cidade, String Estado) {
        Connection conexao = realizaConexaoMySQL();
        String sql_pessoa = "insert into pessoa (CPF, Nome, Telefone, DataNascimento, Rua, Bairro, Cidade, Estado) values (?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement Atuador_pessoa = conexao.prepareStatement(sql_pessoa);

            Atuador_pessoa.setLong(1, CPF);
            Atuador_pessoa.setString(2, nome);
            Atuador_pessoa.setString(3, contato); 
            Atuador_pessoa.setString(4, Data);
            Atuador_pessoa.setString(5, Rua);
            Atuador_pessoa.setString(6, Bairro);
            Atuador_pessoa.setString(7, Cidade);
            Atuador_pessoa.setString(8, Estado);

            Atuador_pessoa.execute();

            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao);
    }
    
    public void insereDadosAlunoNoMySQL(String nome, long CPF, long matricula, int periodo, String contato, String Data, String Rua, String Bairro, String Cidade, String Estado) {
        Connection conexao = realizaConexaoMySQL();
        String sql_pessoa = "insert into pessoa (CPF, Nome, Telefone, DataNascimento, Rua, Bairro, Cidade, Estado) values (?,?,?,?,?,?,?,?)";
        String sql_aluno = "insert into aluno (Matricula,CPFAluno,Periodo) values (?,?,?)";

        try {
            PreparedStatement Atuador_aluno = conexao.prepareStatement(sql_aluno);
            PreparedStatement Atuador_pessoa = conexao.prepareStatement(sql_pessoa);

            Atuador_pessoa.setLong(1, CPF);
            Atuador_pessoa.setString(2, nome);
            Atuador_pessoa.setString(3, contato); 
            Atuador_pessoa.setString(4, Data);
            Atuador_pessoa.setString(5, Rua);
            Atuador_pessoa.setString(6, Bairro);
            Atuador_pessoa.setString(7, Cidade);
            Atuador_pessoa.setString(8, Estado);

            Atuador_pessoa.execute();
            
            Atuador_aluno.setLong(1, matricula);
            Atuador_aluno.setLong(2, CPF);
            Atuador_aluno.setInt(3, periodo);

            Atuador_aluno.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        desconectaMySQL(conexao);
    }

    public void insereDadosProfessorNoMySQL(String nome, long CPF, String data_admissao, String CargoChefia, String CargoCoordenacao, double salario_bruto, String contato, String Data, String Rua, String Bairro, String Cidade, String Estado) {
        Connection conexao = realizaConexaoMySQL();
        String sql_pessoa = "insert into pessoa (CPF, Nome, Telefone, DataNascimento, Rua, Bairro, Cidade, Estado) values (?,?,?,?,?,?,?,?)";
        String sql_professor = "INSERT INTO Professor (CPFProfessor, DataAdmissao,CargoChefia, CargoCoordenacao, SalarioBruto)  values (?,?,?,?,?)";

        try {
            PreparedStatement Atuador_professor = conexao.prepareStatement(sql_professor);
            PreparedStatement Atuador_pessoa = conexao.prepareStatement(sql_pessoa);

            Atuador_pessoa.setLong(1, CPF);
            Atuador_pessoa.setString(2, nome);
            Atuador_pessoa.setString(3, contato); 
            Atuador_pessoa.setString(4, Data);
            Atuador_pessoa.setString(5, Rua);
            Atuador_pessoa.setString(6, Bairro);
            Atuador_pessoa.setString(7, Cidade);
            Atuador_pessoa.setString(8, Estado);

            Atuador_pessoa.execute();

            Atuador_professor.setString(1, data_admissao);
            Atuador_professor.setLong(2, CPF);
            Atuador_professor.setString(3, CargoChefia);
            Atuador_professor.setString(4, CargoCoordenacao);
            Atuador_professor.setDouble(5, salario_bruto);

            Atuador_professor.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao);
    }
    
    public void insereDadosEgressoNoMySQL(String matricula, String profissao, String cursoAnterior, String cursoAtual, String faixaSalarial) {
        Connection conexao = realizaConexaoMySQL();
        String sql_egresso = "INSERT INTO Egresso (MatriculaEgresso,Profissao,CursoAnterior,CursoAtual,FaixaSalarial) values (?,?,?,?,?)";

        try {
            PreparedStatement Atuador_egresso = conexao.prepareStatement(sql_egresso);
            
            Atuador_egresso.setString(1, matricula);
            Atuador_egresso.setString(2, profissao);
            Atuador_egresso.setString(3, cursoAnterior);
            Atuador_egresso.setString(4, cursoAtual);
            Atuador_egresso.setString(5, faixaSalarial);

            Atuador_egresso.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        desconectaMySQL(conexao);
    }
    
    public void insereNotasAlunoNoMySQL(String matricula, String codigo, double n1,  double n2,  double n3,  double n4,  double n5,  double n6,  double n7,  double n8,  double n9,  double n10) {
        Connection conexao = realizaConexaoMySQL();
        String sql_notas = "INSERT INTO Notas (MatriculaAluno, CodigoTurma, Nota1, Nota2, Nota3, Nota4, Nota5, Nota6, Nota7, Nota8, Nota9, Nota10) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement Atuador_notas = conexao.prepareStatement(sql_notas);
            
            Atuador_notas.setString(1, matricula);
            Atuador_notas.setString(2, codigo);
            Atuador_notas.setDouble(3, n1);
            Atuador_notas.setDouble(4, n2);
            Atuador_notas.setDouble(5, n3);
            Atuador_notas.setDouble(6, n4);
            Atuador_notas.setDouble(7, n5);
            Atuador_notas.setDouble(8, n6);
            Atuador_notas.setDouble(9, n7);
            Atuador_notas.setDouble(10, n8);
            Atuador_notas.setDouble(11, n9);
            Atuador_notas.setDouble(12, n10);

            Atuador_notas.execute();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        desconectaMySQL(conexao);
    }

    ///////////////////////////////// ATUALIZA DADOS /////////////////////////////////////
    public void atualizaDadosPessoaNoMySQL(String cpf, String contato, String Rua, String Bairro, String Cidade, String Estado) {
        Connection conexao = realizaConexaoMySQL();

        // SQL corrigido para garantir a atualização correta na tabela 'aluno' enquanto referencia 'pessoa'
        String sql = "UPDATE ementor.pessoa "
            + "SET ementor.pessoa.Telefone = ?, "
            + "ementor.pessoa.Rua = ?, "
            + "ementor.pessoa.Bairro = ?, "
            + "ementor.pessoa.Cidade = ?, "
            + "ementor.pessoa.Estado = ? "
            + "WHERE ementor.pessoa.CPF = ?;";


        try {
            PreparedStatement Atuador = conexao.prepareStatement(sql);

            Atuador.setString(1, contato);  
            Atuador.setString(2, Rua); 
            Atuador.setString(3, Bairro); 
            Atuador.setString(4, Cidade); 
            Atuador.setString(5, Estado); 
            Atuador.setString(6, cpf); 

            
            Atuador.executeUpdate();
            Atuador.close();

            // Verifica se a atualização foi bem-sucedida
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            desconectaMySQL(conexao);  // Garante que a conexão será fechada
        }
    }
    
    public void atualizaDadosAlunoNoMySQL(String cpf, String matricula, String periodo, String contato, String Rua, String Bairro, String Cidade, String Estado) {
        Connection conexao = realizaConexaoMySQL();

        String sql = "UPDATE ementor.pessoa " +
            "JOIN ementor.aluno ON ementor.aluno.CPFAluno = ementor.pessoa.CPF " +
            "SET ementor.pessoa.Telefone = ?, " +
            "ementor.pessoa.Rua = ?, " +
            "ementor.pessoa.Bairro = ?, " +
            "ementor.pessoa.Cidade = ?, " +
            "ementor.pessoa.Estado = ?, " +
            "ementor.aluno.Periodo = ?, " +
            "ementor.aluno.Matricula = ? " +
            "WHERE ementor.pessoa.CPF = ?;";

        try {
            PreparedStatement Atuador = conexao.prepareStatement(sql);
            
            Atuador.setString(1, contato);  
            Atuador.setString(2, Rua); 
            Atuador.setString(3, Bairro); 
            Atuador.setString(4, Cidade); 
            Atuador.setString(5, Estado); 

            Atuador.setString(6, periodo);  
            Atuador.setString(7, matricula); 
            Atuador.setString(8, cpf); 

            Atuador.executeUpdate();
            Atuador.close();

            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            desconectaMySQL(conexao); 
        }
    }

    public void atualizaDadosProfessorNoMySQL(String cpf, String Data_Admissao, double Salario_Bruto, String cargoChefia, String cargoCoordenacao, String contato, String Rua, String Bairro, String Cidade, String Estado) {
        Connection conexao = realizaConexaoMySQL();

        String sql = "UPDATE ementor.pessoa " +
            "JOIN ementor.professor ON ementor.professor.CPFProfessor = ementor.pessoa.CPF " +
            "SET ementor.pessoa.Telefone = ?, " +
            "ementor.pessoa.Rua = ?, " +
            "ementor.pessoa.Bairro = ?, " +
            "ementor.pessoa.Cidade = ?, " +
            "ementor.pessoa.Estado = ?, " +
            "ementor.professor.Salario_bruto = ?, " +
            "ementor.professor.Data_admissao = ? " +
            "WHERE ementor.pessoa.CPF = ?;";

        try {
            PreparedStatement Atuador = conexao.prepareStatement(sql);
            
            Atuador.setString(1, contato);  
            Atuador.setString(2, Rua); 
            Atuador.setString(3, Bairro); 
            Atuador.setString(4, Cidade); 
            Atuador.setString(5, Estado); 
            
            Atuador.setDouble(6, Salario_Bruto);
            Atuador.setString(7, Data_Admissao);
            Atuador.setString(8, cargoChefia);
            Atuador.setString(9, cargoCoordenacao);
            Atuador.setString(10, cpf);
            Atuador.executeUpdate();
            Atuador.close();
            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        desconectaMySQL(conexao);
    }
    
    public void atualizaDadosEgressoNoMySQL(String matricula, String profissao, String cursoAnterior, String cursoAtual, String faixaSalarial) {
        Connection conexao = realizaConexaoMySQL();

        String sql = "UPDATE ementor.pessoa " +
        "JOIN ementor.aluno ON ementor.aluno.CPFAluno = ementor.pessoa.CPF " +
        "JOIN ementor.egresso ON ementor.egresso.MatriculaEgresso = ementor.aluno.Matricula " +
        "SET ementor.egresso.Profissao = ?, " +
        "ementor.egresso.CursoAnterior = ?, " +
        "ementor.egresso.CursoAtual = ?, " +
        "ementor.egresso.FaixaSalarial = ? " +
        "WHERE ementor.egresso.MatriculaEgresso = ?;";

        try {
            PreparedStatement Atuador = conexao.prepareStatement(sql);
            
            Atuador.setString(1, profissao);
            Atuador.setString(2, cursoAnterior);
            Atuador.setString(3, cursoAtual);
            Atuador.setString(4, faixaSalarial);
            Atuador.setString(5, matricula);  
            
            Atuador.executeUpdate();
            Atuador.close();

            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e, "ERRO", JOptionPane.ERROR_MESSAGE);
        } finally {
            desconectaMySQL(conexao); 
        }
    }

    /////////////////////////// RECUPERA DADOS ////////////////////////////////
    public ArrayList<Pessoa> recuperaDadosPessoaDoMySQL(String tipoOrdenacao) {
        Connection conexao = realizaConexaoMySQL();
        ArrayList<Pessoa> pessoa = new ArrayList();

        try {
            String sql_selecao_pessoa = "SELECT * FROM ementor.pessoa ORDER BY " + tipoOrdenacao + ";";
            PreparedStatement atuador_selecao_pessoa = conexao.prepareStatement(sql_selecao_pessoa);
            ResultSet ResultadoSelecao = atuador_selecao_pessoa.executeQuery(); 
           
            while (ResultadoSelecao.next()) {
                Pessoa ObjetoPessoa = new Pessoa();
                
                ObjetoPessoa.CPF = ResultadoSelecao.getLong("CPF");
                ObjetoPessoa.nome = ResultadoSelecao.getString("Nome");
                ObjetoPessoa.data_nascimento = ResultadoSelecao.getString("DataNascimento");
                ObjetoPessoa.telefone = ResultadoSelecao.getString("Telefone");
                ObjetoPessoa.rua = ResultadoSelecao.getString("Rua");
                ObjetoPessoa.bairro = ResultadoSelecao.getString("Bairro");
                ObjetoPessoa.cidade = ResultadoSelecao.getString("Cidade");
                ObjetoPessoa.estado = ResultadoSelecao.getString("Estado");

                pessoa.add(ObjetoPessoa);
            }
            ResultadoSelecao.close();
            atuador_selecao_pessoa.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        desconectaMySQL(conexao); //Fecha a conexão do Banco de Dados
        return pessoa;
    }
    
    public ArrayList<Aluno> recuperaDadosAlunoDoMySQL(String tipoOrdenacao) {
        Connection conexao = realizaConexaoMySQL();//Estabelece conexão
        ArrayList<Aluno> Academico = new ArrayList();//Cria uma lista chamada Academico do Tipo Aluno

        try {
            String sql_selecao_aluno = "SELECT *FROM ementor.pessoa, ementor.aluno WHERE pessoa.CPF=aluno.CPFAluno ORDER BY " + tipoOrdenacao + ";";
            PreparedStatement atuador_selecao_aluno = conexao.prepareStatement(sql_selecao_aluno);
            ResultSet ResultadoSelecao = atuador_selecao_aluno.executeQuery(); //É aqui que fica o resultado da selação do MySQL
            /*Secao para percorrer todas as linhas resultantes da seleção- Logo, deve-se usar um laço de repetição  */
            while (ResultadoSelecao.next()) {//Laço de repetição para percorrer todo o conjuto de resultados "ResultSet" trazidos pela Query
                Aluno ObjetoAluno = new Aluno();//Cria objeto aluno
                /*Seção para inserir em cada atributo do objetoAluno os valores dos campos do MySQL */
                ObjetoAluno.CPF = ResultadoSelecao.getLong("CPF");
                ObjetoAluno.nome = ResultadoSelecao.getString("Nome");
                ObjetoAluno.data_nascimento = ResultadoSelecao.getString("DataNascimento");
                ObjetoAluno.telefone = ResultadoSelecao.getString("Telefone");
                ObjetoAluno.setMatricula(ResultadoSelecao.getInt("Matricula"));
                ObjetoAluno.setPeriodo(ResultadoSelecao.getInt("Periodo"));

                Academico.add(ObjetoAluno);//Adiciona à Lista o Objeto Atual        

            }
            ResultadoSelecao.close();
            atuador_selecao_aluno.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao); //Fecha a conexão do Banco de Dados
        return Academico;
    }
    
    
    public ArrayList<Notas> recuperaNotasAlunoDoMySQL(String matricula) { //////////////ALTERARRRR
        Connection conexao = realizaConexaoMySQL();
        ArrayList<Notas> notas = new ArrayList();

        try {
            String sql_selecao_notas = "SELECT  Pessoa.Nome,Turma.Codigo, Turma.NomeTurma, " +
                                            "Notas.Nota1, Notas.Nota2, Notas.Nota3, Notas.Nota4, Notas.Nota5, " +
                                            "Notas.Nota6, Notas.Nota7, Notas.Nota8, Notas.Nota9, Notas.Nota10 " +
                                            "FROM Aluno " +
                                            "JOIN Pessoa ON Aluno.CPFAluno = Pessoa.CPF " +
                                            "JOIN Notas ON Aluno.Matricula = Notas.MatriculaAluno " +
                                            "JOIN Turma ON Notas.CodigoTurma = Turma.Codigo " +
                                            "WHERE Aluno.Matricula = "+matricula+";";
            PreparedStatement atuador_selecao_notas = conexao.prepareStatement(sql_selecao_notas);
            ResultSet ResultadoSelecao = atuador_selecao_notas.executeQuery(); 
            while (ResultadoSelecao.next()) {
                Notas ObjetoNotas = new Notas();
                
                ObjetoNotas.nome = ResultadoSelecao.getString("Nome");
                ObjetoNotas.codigo = ResultadoSelecao.getString("Codigo");
                ObjetoNotas.nomeTurma = ResultadoSelecao.getString("NomeTurma");
                
                ObjetoNotas.nota1 = ResultadoSelecao.getDouble("Nota1");
                ObjetoNotas.nota2 = ResultadoSelecao.getDouble("Nota2");
                ObjetoNotas.nota3 = ResultadoSelecao.getDouble("Nota3");
                ObjetoNotas.nota4 = ResultadoSelecao.getDouble("Nota4");
                ObjetoNotas.nota5 = ResultadoSelecao.getDouble("Nota5");
                ObjetoNotas.nota6 = ResultadoSelecao.getDouble("Nota6");
                ObjetoNotas.nota7 = ResultadoSelecao.getDouble("Nota7");
                ObjetoNotas.nota8 = ResultadoSelecao.getDouble("Nota8");
                ObjetoNotas.nota9 = ResultadoSelecao.getDouble("Nota9");
                ObjetoNotas.nota10 = ResultadoSelecao.getDouble("Nota10");

                notas.add(ObjetoNotas);      
            }
            ResultadoSelecao.close();
            atuador_selecao_notas.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        desconectaMySQL(conexao); 
        return notas;
    }

    public ArrayList<Professor> recuperaDadosProfessorDoMySQL(String tipoOrdenacao) {
        Connection conexao = realizaConexaoMySQL();//Estabelece conexão
        ArrayList<Professor> Academico = new ArrayList();//Cria uma lista chamada Academico do Tipo Aluno

        try {
            String sql_selecao_professor = "SELECT *FROM ementor.pessoa, ementor.professor WHERE pessoa.CPF=professor.CPFProfessor ORDER BY " + tipoOrdenacao + ";";
            PreparedStatement atuador_selecao_professor = conexao.prepareStatement(sql_selecao_professor);
            ResultSet ResultadoSelecao = atuador_selecao_professor.executeQuery(); //É aqui que fica o resultado da selação do MySQL
            /*Secao para percorrer todas as linhas resultantes da seleção- Logo, deve-se usar um laço de repetição  */
            while (ResultadoSelecao.next()) {//Laço de repetição para percorrer todo o conjuto de resultados "ResultSet" trazidos pela Query
                Professor ObjetoProfessor = new Professor();//Cria objeto professor
                /*Seção para inserir em cada atributo do objetoAluno os valores dos campos do MySQL */
                ObjetoProfessor.CPF = ResultadoSelecao.getLong("CPF");
                ObjetoProfessor.nome = ResultadoSelecao.getString("Nome");
                ObjetoProfessor.data_nascimento = ResultadoSelecao.getString("DataNascimento");
                ObjetoProfessor.telefone = ResultadoSelecao.getString("Telefone");
                ObjetoProfessor.setData_admissao(ResultadoSelecao.getString("Data_Admissao"));
                ObjetoProfessor.setSalario_bruto(ResultadoSelecao.getDouble("Salario_Bruto"));

                Academico.add(ObjetoProfessor);//Adiciona à Lista o Objeto Atual        

            }
            ResultadoSelecao.close();
            atuador_selecao_professor.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao); //Fecha a conexão do Banco de Dados
        return Academico;
    }
    
     public ArrayList<Egresso> recuperaDadosEgressoDoMySQL() {
        Connection conexao = realizaConexaoMySQL();//Estabelece conexão
        ArrayList<Egresso> egresso = new ArrayList();//Cria uma lista chamada Academico do Tipo Aluno

        try {
            String sql_selecao_aluno = "SELECT *FROM ementor.egresso;";
            PreparedStatement atuador_selecao_aluno = conexao.prepareStatement(sql_selecao_aluno);
            ResultSet ResultadoSelecao = atuador_selecao_aluno.executeQuery(); 
            
            while (ResultadoSelecao.next()) {
                Egresso ObjetoEgresso = new Egresso();
                
                ObjetoEgresso.matricula = ResultadoSelecao.getInt("MatriculaEgresso");
                ObjetoEgresso.profissao_atual = ResultadoSelecao.getString("Profissao");
                ObjetoEgresso.faixa_salarial = ResultadoSelecao.getString("FaixaSalarial");
                ObjetoEgresso.curso_anterior = ResultadoSelecao.getString("CursoAnterior");
                ObjetoEgresso.curso_atual = ResultadoSelecao.getString("CursoAtual");

                egresso.add(ObjetoEgresso);     

            }
            ResultadoSelecao.close();
            atuador_selecao_aluno.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao); //Fecha a conexão do Banco de Dados
        return egresso;
    }
    

    //////////////////////////////// FUNÇÕES DE BUSCA ///////////////////////////////////////////
    public boolean pessoaExite(String CPF) {
        Connection conexao = realizaConexaoMySQL();
        boolean pessoa = false;
        try {
            String sql_selecao_pessoa = "SELECT * FROM ementor.Pessoa WHERE Pessoa.CPF = " + CPF + ";";
            PreparedStatement atuador_selecao_pessoa = conexao.prepareStatement(sql_selecao_pessoa);
            ResultSet ResultadoSelecao = atuador_selecao_pessoa.executeQuery();

            if (ResultadoSelecao.next()) {
                pessoa = true;
            } else {
                System.out.println("Nenhuma pessoa encontrada com esse CPF.");
            }

            ResultadoSelecao.close();
            atuador_selecao_pessoa.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {
            desconectaMySQL(conexao); // Certifique-se de sempre fechar a conexão
        }
        return pessoa;
    }
    
    public Pessoa buscaPessoa(String CPF) {
        Connection conexao = realizaConexaoMySQL();
        Pessoa pessoa = new Pessoa();
        pessoa = null;
        try {
            String sql_selecao_pessoa = "SELECT * FROM ementor.Pessoa WHERE Pessoa.CPF = " + CPF + ";";
            PreparedStatement atuador_selecao_pessoa = conexao.prepareStatement(sql_selecao_pessoa);
            ResultSet ResultadoSelecao = atuador_selecao_pessoa.executeQuery();

            while (ResultadoSelecao.next()) {//Laço de repetição para percorrer todo o conjuto de resultados "ResultSet" trazidos pela Query
                //ResultadoSelecao.first();
                Aluno ObjetoPessoa = new Aluno();//Cria objeto aluno
                /*Seção para inserir em cada atributo do objetoAluno os valores dos campos do MySQL */
                ObjetoPessoa.CPF = ResultadoSelecao.getLong("CPF");
                ObjetoPessoa.nome = ResultadoSelecao.getString("Nome");
                ObjetoPessoa.data_nascimento = ResultadoSelecao.getString("DataNascimento");
                ObjetoPessoa.telefone = ResultadoSelecao.getString("Telefone");
                ObjetoPessoa.rua = ResultadoSelecao.getString("Rua");
                ObjetoPessoa.bairro = ResultadoSelecao.getString("Bairro");
                ObjetoPessoa.cidade = ResultadoSelecao.getString("Cidade");
                ObjetoPessoa.estado = ResultadoSelecao.getString("Estado");

                pessoa = ObjetoPessoa;      

            }
            
            ResultadoSelecao.close();
            atuador_selecao_pessoa.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {
            desconectaMySQL(conexao); // Certifique-se de sempre fechar a conexão
        }
        return pessoa;
    }

    public Aluno buscaAluno(String CPF) {
        Connection conexao = realizaConexaoMySQL();//Estabelece conexão
        Aluno Academico = new Aluno();//Cria um vetor chamado Academico do Tipo Aluno
        Academico = null;
        try {
            String sql_selecao_aluno = "SELECT *FROM ementor.pessoa, ementor.aluno WHERE pessoa.CPF=aluno.CPFAluno and aluno.CPFAluno=" + CPF + ";";
            PreparedStatement atuador_selecao_aluno = conexao.prepareStatement(sql_selecao_aluno);
            ResultSet ResultadoSelecao = atuador_selecao_aluno.executeQuery(); //É aqui que fica o resultado da selação do MySQL
            /*Secao para percorrer todas as linhas resultantes da seleção- Logo, deve-se usar um laço de repetição  */
            // ResultadoSelecao.previous();
            while (ResultadoSelecao.next()) {//Laço de repetição para percorrer todo o conjuto de resultados "ResultSet" trazidos pela Query
                //ResultadoSelecao.first();
                Aluno ObjetoAluno = new Aluno();//Cria objeto aluno
                /*Seção para inserir em cada atributo do objetoAluno os valores dos campos do MySQL */
                ObjetoAluno.CPF = ResultadoSelecao.getLong("CPF");
                ObjetoAluno.nome = ResultadoSelecao.getString("Nome");
                ObjetoAluno.data_nascimento = ResultadoSelecao.getString("DataNascimento");
                ObjetoAluno.telefone = ResultadoSelecao.getString("Telefone");
                ObjetoAluno.setMatricula(ResultadoSelecao.getInt("Matricula"));
                ObjetoAluno.setPeriodo(ResultadoSelecao.getInt("Periodo"));
                
                ObjetoAluno.rua = ResultadoSelecao.getString("Rua");
                ObjetoAluno.bairro = ResultadoSelecao.getString("Bairro");
                ObjetoAluno.cidade = ResultadoSelecao.getString("Cidade");
                ObjetoAluno.estado = ResultadoSelecao.getString("Estado");

                Academico = ObjetoAluno;//Adiciona ao vetor de Aluno o Objeto Atual        

            }
            ResultadoSelecao.close();
            atuador_selecao_aluno.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao); //Fecha a conexão do Banco de Dados
        return Academico;
    }

    public Professor buscaProfessor(String CPF) {
        Connection conexao = realizaConexaoMySQL();//Estabelece conexão
        Professor Academico = new Professor();//Cria um vetor chamado Academico do Tipo Aluno
        Academico = null;
        try {
            String sql_selecao_professor = "SELECT *FROM ementor.pessoa, ementor.professor WHERE pessoa.CPF=professor.CPFProfessor and professor.CPFProfessor=" + CPF + ";";
            PreparedStatement atuador_selecao_professor = conexao.prepareStatement(sql_selecao_professor);
            ResultSet ResultadoSelecao = atuador_selecao_professor.executeQuery(); //É aqui que fica o resultado da selação do MySQL
            /*Secao para percorrer todas as linhas resultantes da seleção- Logo, deve-se usar um laço de repetição  */
            // ResultadoSelecao.previous();
            while (ResultadoSelecao.next()) {//Laço de repetição para percorrer todo o conjuto de resultados "ResultSet" trazidos pela Query
                //ResultadoSelecao.first();
                Professor ObjetoProfessor = new Professor();//Cria objeto aluno
                /*Seção para inserir em cada atributo do objetoAluno os valores dos campos do MySQL */
                ObjetoProfessor.CPF = ResultadoSelecao.getLong("CPF");
                ObjetoProfessor.nome = ResultadoSelecao.getString("Nome");
                ObjetoProfessor.data_nascimento = ResultadoSelecao.getString("DataNascimento");
                ObjetoProfessor.telefone = ResultadoSelecao.getString("Telefone");
                ObjetoProfessor.setData_admissao(ResultadoSelecao.getString("Data_Admissao"));
                ObjetoProfessor.setSalario_bruto(ResultadoSelecao.getDouble("Salario_Bruto"));
                
                ObjetoProfessor.rua = ResultadoSelecao.getString("Rua");
                ObjetoProfessor.bairro = ResultadoSelecao.getString("Bairro");
                ObjetoProfessor.cidade = ResultadoSelecao.getString("Cidade");
                ObjetoProfessor.estado = ResultadoSelecao.getString("Estado");

                Academico = ObjetoProfessor;//Adiciona ao vetor de Aluno o Objeto Atual        

            }
            ResultadoSelecao.close();
            atuador_selecao_professor.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao); //Fecha a conexão do Banco de Dados
        return Academico;
    }
    
    public Egresso buscaEgresso(String matricula) {
        Connection conexao = realizaConexaoMySQL();//Estabelece conexão
        Egresso egresso = new Egresso();//Cria um vetor chamado Academico do Tipo Aluno
        egresso = null;
        try {
            String sql_selecao_egresso = "SELECT *FROM ementor.aluno, ementor.egresso WHERE aluno.Matricula=egresso.MatriculaEgresso and egresso.MatriculaEgresso=" + matricula + ";";
            PreparedStatement atuador_selecao_egresso = conexao.prepareStatement(sql_selecao_egresso);
            ResultSet ResultadoSelecao = atuador_selecao_egresso.executeQuery(); 
            
            while (ResultadoSelecao.next()) {
                Egresso ObjetoEgresso = new Egresso();
                
                ObjetoEgresso.matricula = ResultadoSelecao.getInt("Matricula");
                ObjetoEgresso.profissao_atual = ResultadoSelecao.getString("Profissao");
                ObjetoEgresso.curso_anterior = ResultadoSelecao.getString("CursoAnterior");
                ObjetoEgresso.curso_atual = ResultadoSelecao.getString("CursoAtual");
                ObjetoEgresso.faixa_salarial = ResultadoSelecao.getString("FaixaSalarial");

                egresso = ObjetoEgresso;
            }
            ResultadoSelecao.close();
            atuador_selecao_egresso.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        desconectaMySQL(conexao);
        return egresso;
    }

    ///////////////////////////////////// FUNÇÕES DE USUÁRIO //////////////////////////////////////////////////////
    public void insereUsuariosNoMySQL(String nome, String senha, int nivel_acesso, String cpf_usuario) {
        Connection conexao = realizaConexaoMySQL();
        String sql_usuario = "insert into usuario (NomeUsuario, Senha, NivelAcesso, CPFUsuario) values (?,?,?,?)";

        try {//Aqui serão aplicados todos os recursos para efetivar a inserção dos daddo nas Tabelas do MySQL
            PreparedStatement Atuador_usuario = conexao.prepareStatement(sql_usuario);

            if (pessoaExite(cpf_usuario) == true) {
                Atuador_usuario.setString(1, nome);//Substitui a segunda interrogação no insert into aluno
                Atuador_usuario.setString(2, senha); //Substitui a terceira interrogação no insert into aluno
                Atuador_usuario.setInt(3, nivel_acesso);//Substitui a última interrogação no insert into aluno
                Atuador_usuario.setString(4, cpf_usuario);//Substitui a última interrogação no insert into aluno

                Atuador_usuario.execute();//Nesse momento estará sendo lançado o comando insert into "fisisicamente" no MySQL
                JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não há nenhuma pessoa com esse CPF cadastrada.", "ERRO", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao);
    }

    public void atualizaUsuariosNoMySQL(String email, String login, String senha, int nivel_acesso) {
        Connection conexao = realizaConexaoMySQL();
        String sql = "update ementor.usuario set Email=" + email + ", login=" + login + ", Senha=" + senha + "and Nivel_Acesso=" + nivel_acesso + ";";

        //update ementor.pessoa set pessoa.Nome="Fulado de tal" where pessoa.CPF="12345678910". 
        try {//Aqui serão aplicados todos os recursos para efetivar a inserção dos daddo nas Tabelas do MySQL
            PreparedStatement Atuador = conexao.prepareStatement(sql);

            /*Seção para setar os campos no atuador */
            Atuador.execute();//Nesse momento estará sendo lançado o comando update "fisisicamente" no MySQL

            JOptionPane.showMessageDialog(null, "Dados Atualizados com Sucesso", "Salvar", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao);
    }

    public ArrayList<Usuario> recuperaUsuariosDoMySQL(String tipoOrdenacao) {
        Connection conexao = realizaConexaoMySQL();//Estabelece conexão
        ArrayList<Usuario> user = new ArrayList();//Cria uma lista chamada Academico do Tipo Aluno

        try {
            String sql_selecao_usuario = "SELECT *FROM ementor.usuario ORDER BY " + tipoOrdenacao + ";";
            PreparedStatement atuador_selecao_usuario = conexao.prepareStatement(sql_selecao_usuario);
            ResultSet ResultadoSelecao = atuador_selecao_usuario.executeQuery(); //É aqui que fica o resultado da selação do MySQL
            /*Secao para percorrer todas as linhas resultantes da seleção- Logo, deve-se usar um laço de repetição  */
            while (ResultadoSelecao.next()) {//Laço de repetição para percorrer todo o conjuto de resultados "ResultSet" trazidos pela Query
                Usuario ObjetoUsuario = new Usuario();//Cria objeto aluno
                /*Seção para inserir em cada atributo do objetoAluno os valores dos campos do MySQL */
                ObjetoUsuario.nome = ResultadoSelecao.getString("Nome");
                ObjetoUsuario.email = ResultadoSelecao.getString("Email");
                ObjetoUsuario.login = ResultadoSelecao.getString("Login");
                ObjetoUsuario.senha = (ResultadoSelecao.getString("Senha"));
                ObjetoUsuario.nivel_acesso = (ResultadoSelecao.getInt("NivelAcesso"));

                user.add(ObjetoUsuario);//Adiciona à Lista o Objeto Atual        

            }
            ResultadoSelecao.close();
            atuador_selecao_usuario.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao); //Fecha a conexão do Banco de Dados
        return user;
    }

    public Usuario buscaUsuario(String login, String senha) {
        Connection conexao = realizaConexaoMySQL();//Estabelece conexão
        Usuario user = new Usuario();//Cria um vetor chamado Academico do Tipo Aluno
        user = null;
        try {
            String sql_selecao_usuario = "SELECT *FROM ementor.usuario WHERE usuario.Login='" + login + "' and usuario.Senha='" + senha + "';";
            PreparedStatement atuador_selecao_usuario = conexao.prepareStatement(sql_selecao_usuario);
            ResultSet ResultadoSelecao = atuador_selecao_usuario.executeQuery(); //É aqui que fica o resultado da selação do MySQL
            /*Secao para percorrer todas as linhas resultantes da seleção- Logo, deve-se usar um laço de repetição  */
            // ResultadoSelecao.previous();
            while (ResultadoSelecao.next()) {//Laço de repetição para percorrer todo o conjuto de resultados "ResultSet" trazidos pela Query
                //ResultadoSelecao.first();
                Usuario ObjetoUsuario = new Usuario();//Cria objeto aluno
                /*Seção para inserir em cada atributo do objetoAluno os valores dos campos do MySQL */
                ObjetoUsuario.nome = ResultadoSelecao.getString("Nome");
                ObjetoUsuario.email = ResultadoSelecao.getString("Email");
                ObjetoUsuario.login = ResultadoSelecao.getString("Login");
                ObjetoUsuario.senha = ResultadoSelecao.getString("Senha");
                ObjetoUsuario.nivel_acesso = (ResultadoSelecao.getInt("Nivel_Acesso"));

                user = ObjetoUsuario;//Adiciona ao vetor de Aluno o Objeto Atual        

            }
            ResultadoSelecao.close();
            atuador_selecao_usuario.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        }
        desconectaMySQL(conexao); //Fecha a conexão do Banco de Dados
        return user;
    }

    public int recuperaNivel() {
        Connection conexao = realizaConexaoMySQL(); // Estabelece conexão
        int nivel = 0;
        try {
            String nome = Login.TUsuario.getText();
            String sql_selecao_login = "SELECT * FROM Usuario WHERE Usuario.NomeUsuario = '" + nome + "';";
            PreparedStatement atuador_selecao_login = conexao.prepareStatement(sql_selecao_login);
            ResultSet ResultadoSelecao = atuador_selecao_login.executeQuery();

            if (ResultadoSelecao.next()) {  // Mova o cursor para a primeira linha, se existir
                nivel = ResultadoSelecao.getInt("NivelAcesso");
            } else {
                System.out.println("Nenhum usuário encontrado com esse nome.");
            }

            ResultadoSelecao.close();
            atuador_selecao_login.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Algum imprevisto ocorreu: " + e + "", "ERRO", JOptionPane.ERROR_MESSAGE);

        } finally {
            desconectaMySQL(conexao); // Certifique-se de sempre fechar a conexão
        }
        return nivel;
    }

}
