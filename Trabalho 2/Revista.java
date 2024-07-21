package trabalho.biblioteca;

/**
 * Classe Revista herda Item.
 * @author Amanda
 */
public class Revista extends Item{
    //atritubos
    private int volumeRevista;
    private int numero;
    
    /**
     * Construtor para guardar os dados das revistas.
     * @param titulo String - nome da revista
     * @param autor String - nome do autor da revista
     * @param anoPublicacao int - ano de publicação da revista
     * @param quantidadeDisponivel int - quantidade de revistas disponíveis
     * @param quantidadeEmprestada int - quantidade de revistas emprestados
     * @param volumeRevista int - volume da revista
     * @param numero int - numero da revista
     */
    public Revista(String titulo, String autor, int anoPublicacao, 
                     int quantidadeDisponivel, int quantidadeEmprestada, int volumeRevista, int numero) {
        //subclasse Revista herda os atributos de sua superclasse Item
        super(titulo, autor, anoPublicacao, quantidadeDisponivel, quantidadeEmprestada);
        this.volumeRevista = volumeRevista;
        this.numero = numero;
    }
    
    /**
     * Construtor inicial: sem a quantidade emprestada (utilizado para cadastro).
     * @param titulo String - nome da revista
     * @param autor String - nome do autor da revista
     * @param anoPublicacao int - ano de publicação da revista
     * @param quantidadeDisponivel int - quantidade de revistas disponíveis
     * @param volumeRevista int - volume da revista
     * @param numero int - numero da revista 
     */
    public Revista(String titulo, String autor, int anoPublicacao, 
                     int quantidadeDisponivel, int volumeRevista, int numero) {
        //subclasse Revista herda os atributos de sua superclasse Item
        super(titulo, autor, anoPublicacao, quantidadeDisponivel);
        this.volumeRevista = volumeRevista;
        this.numero = numero;
    }
    
    /**
     * Acessa o volume da revista.
     * @return retorna o volume da revista
     */
    public int getVolumeRevista() {
        return volumeRevista;
    }

    /**
     * Modifica o valor do volume da revista. 
     * @param volumeRevista int - volume da revista
     */
    public void setVolumeRevista(int volumeRevista) {
        this.volumeRevista = volumeRevista;
    }

    /**
     * Acessa o número da revista.
     * @return retorna o número da revista
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Modifica o valor do número da revista.
     * @param numero int - número da revista
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
}