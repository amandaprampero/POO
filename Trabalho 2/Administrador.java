package trabalho.biblioteca;

/**
 * Classe Administrador herda Usuario, pode cadastrar itens e ver a listagem 
 * de itens emprestados pelos usuários, a partir de sua matrícula.
 * @author Amanda
 */
public class Administrador extends Usuario{

    /**
     * Construtor para guardar os dados do administrador.
     * @param nome String - nome
     * @param senha String - senha
     * @param cpf String - CPF
     */
    public Administrador(String nome, String senha, String cpf){
        super(nome, senha, cpf);
    }
    
    /**
     * Administrador não possui multas.
     * @return 
     */
    @Override
    public double multa() {
        throw new UnsupportedOperationException("Administrador não tem multas."); 
    }
    
}