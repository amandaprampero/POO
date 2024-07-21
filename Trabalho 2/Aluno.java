package trabalho.biblioteca;

/**
 * Classe Aluno herda Usuarioe define o método de multa.
 * @author Amanda
 */
public class Aluno extends Usuario{
    //atributos
    private String curso;
    private String periodo;

    /**
     * Construtor para guardar os dados dos alunos.
     * @param nome String - nome do aluno
     * @param cpf String - CPF do aluno
     * @param matricula int - número da matrícula
     * @param senha String - senha do aluno
     * @param curso String - curso do aluno
     * @param periodo String - período do aluno
     */
    public Aluno(String nome, String cpf, String matricula, String senha, String curso, String periodo) {
        //subclasse Aluno herda os atributos de sua superclasse Usuario
        super(nome, cpf, matricula, senha);
        this.curso = curso;
        this.periodo = periodo;
    }
    
    /**
     * Método para definir o valor da multa por dia de atraso.
     * @return retorna o valor da multa por dia de atraso
     */
    @Override
    public double multa() {
        double multa = 5.0; //valor da multa por dia de atraso
        return multa;
    }
    
}
