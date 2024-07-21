package trabalho.biblioteca;

/**
 * Classe CD herda Item.
 * @author Amanda
 */
public class CD extends Item{
    //atributos
    private int volumeCD;
    private String gravadora;
    
    /**
     * Construtor para guardar os dados das revistas.
     * @param titulo String - nome do CD
     * @param autor String - nome do autor do CD
     * @param anoPublicacao int - ano de publicação do CD
     * @param quantidadeDisponivel int - quantidade de CDs disponíveis
     * @param quantidadeEmprestada int - quantidade de CDs emprestados
     * @param volumeCD int - volume do CD
     * @param gravadora String - gravadora do CD
     */
    public CD(String titulo, String autor, int anoPublicacao, int quantidadeDisponivel, 
               int quantidadeEmprestada, int volumeCD, String gravadora) {
        //subclasse CD herda os atributos de sua superclasse Item
        super(titulo, autor, anoPublicacao, quantidadeDisponivel, quantidadeEmprestada);
        this.volumeCD = volumeCD;
        this.gravadora = gravadora;
    }
    
    /**
     * Construtor inicial: sem a quantidade emprestada (utilizado para cadastro).
     * @param titulo String - nome do CD
     * @param autor String - nome do autor do CD
     * @param anoPublicacao int - ano de publicação do CD
     * @param quantidadeDisponivel int - quantidade de CDs disponíveis
     * @param volumeCD int - volume do CD
     * @param gravadora String - gravadora do CD 
     */
    public CD(String titulo, String autor, int anoPublicacao, 
            int quantidadeDisponivel, int volumeCD, String gravadora) {
        //subclasse CD herda os atributos de sua superclasse Item
        super(titulo, autor, anoPublicacao, quantidadeDisponivel);
        this.volumeCD = volumeCD;
        this.gravadora = gravadora;
    }
    
    /**
     * Acessa o volume do CD.
     * @return retorna o volume do CD
     */
    public int getVolumeCD() {
        return volumeCD;
    }

    /**
     * Modifica o valor do volume do CD
     * @param volumeCD int - volume do CD
     */
    public void setVolumeCD(int volumeCD) {
        this.volumeCD = volumeCD;
    }

    /**
     * Acessa o nome da gravadora.
     * @return String - nome da gravadora
     */
    public String getGravadora() {
        return gravadora;
    }

    /**
     * Modifica a gravadora.
     * @param gravadora String - nome da gravadora
     */
    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
    
}