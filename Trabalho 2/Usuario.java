package trabalho.biblioteca;

import java.util.ArrayList;

/**
 * Classe Usuario possui construtor, métodos de busca na lista de empréstimos
 * e um método abstrato para definir a multa.
 * @author Amanda
 */
public abstract class Usuario {
    //atributos que serão herdados por Aluno, Professor e Assessor Técnico
    private String nome;
    private String matricula;
    private String cpf;
    private String senha;
    private ArrayList<Emprestimo> itensEmprestados = new ArrayList<>();
    
    /**
     * Construtor para guardar os dados dos usuários.
     * @param nome String - nome do usuario
     * @param cpf String - CPF do usuário
     * @param matricula String - número da matrícula
     * @param senha String - senha do usuário
     */
    public Usuario(String nome, String cpf, String matricula, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.senha = senha;
    }
    
    /**
     * Construtor para guardar dados do Administrador.
     * @param nome String - nome do administrador
     * @param senha String - senha do administrador
     * @param cpf String - CPF do administrador
     */
    public Usuario(String nome, String senha, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }
   
    /**
     * Método que adiciona um Emprestimo na lista de empréstimos do usuário.
     * @param emprestimo Emprestimo - emprestimo
     */
    public void adicionarEmprestimo(Emprestimo emprestimo){
        itensEmprestados.add(emprestimo);
    }

    /**
     * Método para buscar empréstimos na lista de itens emprestados do usuário,
     * se achar o item na lista, faz a devolução.
     * @param nomeItem String - nome do item emprestado
     * @return retorna o empréstimo buscado, caso encontre
     */
    public Emprestimo buscarEmprestimo(String nomeItem){
        for(Emprestimo devolver : itensEmprestados){
            if(nomeItem.equals(devolver.getItem().getTitulo())){
                //se achar o item na lista de itens emprestados, então o devolve
                devolver.getItem().emprestimo = devolver;
                //devolver.getItem().devolucao(devolver.getItem());
                return devolver;
            }
        }
        return null;
    }
    
    /**
     * Método abstrato para calcular a multa por atraso na devolução.
     * @return 
     */
    public abstract double multa();
    
    /**
     * Acessa o nome do usuário.
     * @return retorna o nome do usuário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o nome do usuário.
     * @param nome String - nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Acessa a matrícula do suário.
     * @return retorna a matrícula do usuário
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Modifica a matrícula do usuário.
     * @param matricula String - matrícula do usuário
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Acessa o CPF do usuário.
     * @return retorna o CPF do usuário
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Modifica o CPF do usuário.
     * @param cpf String - CPF do usuário
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Acessa a senha do usuário.
     * @return retorna a senha do usuário
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Modifica a senha do usuário.
     * @param senha String - senha do usuário
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * Acessa a lista de itens emprestados pelo usuário.
     * @return retorna a lista de itens emprestados pelo usuário
     */
    public ArrayList<Emprestimo> getItensEmprestados() {
        return itensEmprestados;
    }

    /**
     * Modifica a lista de itens emprestados pelo usuário.
     * @param itensEmprestados Lista de Itens emprestados
     */
    public void setItensEmprestados(ArrayList<Emprestimo> itensEmprestados) {
        this.itensEmprestados = itensEmprestados;
    }
    
}