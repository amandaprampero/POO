package trabalho.biblioteca;

/**
 * Classe AssessorTecnico herda Usuario e define o método de multa.
 * @author Amanda
 */
public class AssessorTecnico extends Usuario{
    //atributos
    private String secao;

    /**
     * Construtor para guardar os dados do assessor tecnico.
     * @param nome String - nome do assessor tecnico
     * @param cpf String = CPF do assessor tecnico
     * @param senha String - senha do assessor tecnico
     * @param matricula int - número da matrícula
     * @param secao String - seção(Acadêmica, Pos-Graduaç̃ao, Graduaç̃ao, Administrativa etc)
     */
    public AssessorTecnico(String nome, String cpf, String matricula, String senha, String secao) {
        super(nome, cpf, matricula, senha);
        this.secao = secao;
    }

    /**
     * Método para definir o valor da multa por dia de atraso.
     * @return retorna o valor da multa por dia de atraso
     */
    @Override
    public double multa() {
        double multa = 5.75; //valor da multa por dia de atraso
        return multa;
    }
    
}