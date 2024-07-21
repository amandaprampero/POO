package trabalho.biblioteca;

/**
 * Classe Professor herda Usuario e define o método de multa.
 * @author Amanda
 */
public class Professor extends Usuario{
    //atributos
    private String departamento;
    private String titulacao;

    /**
     * Construtor para guardar os dados dos professores.
     * @param nome String - nome do professor
     * @param cpf String - CPF do professor
     * @param matricula int - número da matrícula
     * @param senha String - senha do professor
     * @param departamento String - departamento do professor
     * @param titulacao String - titulação do professor
     */
    public Professor(String nome, String cpf, String matricula, String senha, String departamento, String titulacao) {
        //subclasse Professor herda os atributos de sua superclasse Usuario
        super(nome, cpf, matricula, senha);
        this.departamento = departamento;
        this.titulacao = titulacao;
    }
   
    /**
     * Método para definir o valor da multa por dia de atraso.
     * @return retorna o valor da multa por dia de atraso
     */
    @Override
    public double multa() {
        double multa = 6.25; //valor da multa por dia de atraso
        return multa;
    }
    
}