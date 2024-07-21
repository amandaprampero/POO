package trabalho.biblioteca;

/**
 * Classe Livro herda Item.
 * @author Amanda
 */
public class Livro extends Item{
    //atributos
    private String editora;
    private String ISBN;
    
    /**
     * Construtor para guardar os dados dos livros.
     * @param titulo String - nome do livro
     * @param autor String - nome do autor do livro
     * @param anoPublicacao int - ano de publicação do livro
     * @param quantidadeDisponivel int - quantidade de livros disponíveis
     * @param quantidadeEmprestada int - quantidade de livros emprestados
     * @param editora String - nome da editora do livro
     * @param ISBN String - "código" do livro
     */
    public Livro(String titulo, String autor, int anoPublicacao, 
                 int quantidadeDisponivel, int quantidadeEmprestada, String editora, String ISBN){
        //subclasse Livro herda os atributos de sua superclasse Item
        super(titulo, autor, anoPublicacao, quantidadeDisponivel, quantidadeEmprestada);
        this.editora = editora;
        this.ISBN = ISBN;
    }
    
    //construtor inicial: sem a quantidade emprestada (utilizado para cadastro)
    /**
     * Construtor inicial: sem a quantidade emprestada (utilizado para cadastro).
     * @param titulo String - nome do livro
     * @param autor String - nome do autor do livro
     * @param anoPublicacao int - ano de publicação do livro
     * @param quantidadeDisponivel int - quantidade de livros disponíveis
     * @param editora String - nome da editora do livro
     * @param ISBN String - "código" do livro
     */
    public Livro(String titulo, String autor, int anoPublicacao, 
                 int quantidadeDisponivel, String editora, String ISBN){
        //subclasse Livro herda os atributos de sua superclasse Item
        super(titulo, autor, anoPublicacao, quantidadeDisponivel);
        this.editora = editora;
        this.ISBN = ISBN;
    }
    
    /**
     * Acessa o nome da editora.
     * @return retorna o nome da editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * Modifica a editora.
     * @param editora String - nome da editora
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * Acessa o ISBN.
     * @return retorna o ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * Modifica o valor do ISBN.
     * @param ISBN String - ISBN
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
}