package trabalho.biblioteca;

/**
 * Classe para realizar empréstimos e devoluções de itens.
 * @author Amanda
 */
public abstract class Item implements Emprestavel{
    //atributos que serão herdados por Livro, Revista e CD
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantidadeDisponivel;
    private int quantidadeEmprestada;
    protected Emprestimo emprestimo;
 
    /**
     * Construtor para guardar os dados dos itens.
     * @param titulo String - nome do item
     * @param autor String - nome do autor do item
     * @param anoPublicacao int - ano de publicação do item
     * @param quantidadeDisponivel int - quantidade de itens disponíveis
     * @param quantidadeEmprestada int - quantidade de itens emprestados
     */
    public Item(String titulo, String autor, int anoPublicacao, 
                 int quantidadeDisponivel, int quantidadeEmprestada) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeEmprestada = quantidadeEmprestada;
    }
    
    /**
     * Construtor que inicia a quantidade emprestada como ZERO (utilizado para cadastro).
     * @param titulo String - nome do item
     * @param autor String - nome do autor do item
     * @param anoPublicacao int - ano de publicação do item
     * @param quantidadeDisponivel int - quantidade de itens disponíveis
     */
    public Item(String titulo, String autor, int anoPublicacao, 
                 int quantidadeDisponivel) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.quantidadeEmprestada = 0;
    }
 
    /**
     * Método que faz o empréstimo de um item, diminuindo a quantidade disponível 
     * e aumentando a quantidade emprestada. Chama o método emprestarItem na 
     * classe Emprestimo que por sua vez chama um método na classe Usuario 
     * que adiciona um empréstimo na lista de empréstimos do usuário.
     * @param emprestimo
     * @param contaLogada
     */
    @Override
    public void emprestimo(Emprestimo emprestimo, Usuario contaLogada){
        if(emprestimo.getItem() instanceof Livro){
            emprestimo.emprestarItem(emprestimo, contaLogada);
            emprestimo.getItem().setQuantidadeEmprestada(emprestimo.getItem().getQuantidadeEmprestada()+1);
            emprestimo.getItem().setQuantidadeDisponivel(emprestimo.getItem().getQuantidadeDisponivel()-1);
            System.out.println("Empréstimo bem sucedido!");
        }
        if(emprestimo.getItem() instanceof Revista){
            emprestimo.emprestarItem(emprestimo, contaLogada);
            emprestimo.getItem().setQuantidadeEmprestada(emprestimo.getItem().getQuantidadeEmprestada()+1);
            emprestimo.getItem().setQuantidadeDisponivel(emprestimo.getItem().getQuantidadeDisponivel()-1);
            System.out.println("Empréstimo bem sucedido!");
        }
        if(emprestimo.getItem() instanceof CD){
            emprestimo.emprestarItem(emprestimo, contaLogada);
            emprestimo.getItem().setQuantidadeEmprestada(emprestimo.getItem().getQuantidadeEmprestada()+1);
            emprestimo.getItem().setQuantidadeDisponivel(emprestimo.getItem().getQuantidadeDisponivel()-1);
            System.out.println("Empréstimo bem sucedido!");
        }
    }
    
    /**
     * Método que devolve um item.
     * Chama o método devolverItem na classe Emprestimo que já faz o cálculo
     * da multa se houver atrasos.
     * @param item 
     * @param contaLogada
     */
    @Override
    public void devolucao(Item item, Usuario contaLogada){
        if(item instanceof Livro){
            emprestimo.devolverItem(item, contaLogada);
            item.setQuantidadeEmprestada(item.getQuantidadeEmprestada()-1);
            item.setQuantidadeDisponivel(item.getQuantidadeDisponivel()+1);
            System.out.println("Devolução bem sucedida!");
        }
        if(item instanceof Revista){
            emprestimo.devolverItem(item, contaLogada);
            item.setQuantidadeEmprestada(item.getQuantidadeEmprestada()-1);
            item.setQuantidadeDisponivel(item.getQuantidadeDisponivel()+1);
            System.out.println("Devolução bem sucedida!");
        }
        if(item instanceof CD){
            emprestimo.devolverItem(item, contaLogada);
            item.setQuantidadeEmprestada(item.getQuantidadeEmprestada()-1);
            item.setQuantidadeDisponivel(item.getQuantidadeDisponivel()+1);
            System.out.println("Devolução bem sucedida!");
        }
    }
  
    /**
     * Acessa o título do item.
     * @return retorna o título do item
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Modifica o título do item.
     * @param titulo String - título do item
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Acessa o autor do item.
     * @return retorna o autor do item
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Modifica o autor do item.
     * @param autor String - autor do item
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Acessa o ano de publicação do item.
     * @return retorna o ano de publicação do item.
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    /**
     * Modifica o ano de publicação do item.
     * @param anoPublicacao int - ano de publicação do item
     */
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    /**
     * Acessa a quantidade de itens disponíveis.
     * @return retorna a quantidade de itens disponíveis
     */
    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    /**
     * Modifica a quantidade de itens disponíveis.
     * @param quantidadeDisponivel int - quantidade de itens disponíveis
     */
    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    /**
     * Acessa a quantidade de itens emprestados.
     * @return retorna a quantidade de itens emprestados
     */
    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    /**
     * Modifica a quantidade de itens emprestados.
     * @param quantidadeEmprestada int - quantidade de itens emprestados
     */
    public void setQuantidadeEmprestada(int quantidadeEmprestada) {
        this.quantidadeEmprestada = quantidadeEmprestada;
    }
    
}