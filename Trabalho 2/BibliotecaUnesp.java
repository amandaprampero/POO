package trabalho.biblioteca;

import java.util.ArrayList;

/**
 * Classe BibliotecaUnesp possui listas de itens e usuários,
 * além de métodos de busca, cadastro, logar conta, verificação de disponibilidade
 * dos itens e remover itens da lista de empréstimos.
 * @author Amanda
 */
public class BibliotecaUnesp {
    protected Usuario contaLogada;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<CD> CD = new ArrayList<>();
    private ArrayList<Revista> revistas = new ArrayList<>();
    
    /**
     * Método para cadastrar usuário.
     * @param usuario Usuario - usuário para adicionar na lista
     * @return retorna TRUE se fez o cadastro e FALSE caso contrário 
     */
    public boolean cadastrarUsuario(Usuario usuario){
        return usuarios.add(usuario);
    }
    
    /**
     * Método que verifica os dados digitados pelo usuário, 
     * se estiverem corretos permite fazer o login.
     * @param nome String - nome do usuário
     * @param cpf String - CPF do usuário
     * @param senha String - senha do usuário 
     * @return boolean - retorna TRUE se a conta foi logada ou FALSE caso contrário 
     */
    public boolean logarUsuario(String nome, String cpf, String senha){
        for(Usuario conta : usuarios){
            if(conta.getNome().equals(nome) && conta.getCpf().equals(cpf)){
                if(conta.getSenha().equals(senha)){
                    contaLogada = conta;
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Método que busca um usuário na lista a partir de sua matrícula.
     * @param matricula String - matrícula do usuário
     * @return retorna a conta do usuário caso a encontre
     */
    public Usuario buscarUsuario(String matricula){
        for(Usuario conta : usuarios){
            if(matricula.equals(conta.getMatricula())){
                return conta;
            }
        }
        return null;
    }
    
    /**
     * Método para remover o empréstimo da lista após a devolução.
     * @param nome String - nome do item devolvido 
     */
    public void removerEmprestimo(String nome){
        for(Emprestimo devolvido : contaLogada.getItensEmprestados()) {
            if(devolvido.getItem().getTitulo().equals(nome)){
            contaLogada.getItensEmprestados().remove(devolvido);
            }
        }
    }
    
    /**
     * Método para sair da conta logada.
     * <p>
     * O método irá setar como null o campo contaLogada, perdendo sua referência, 
     * ou seja, depois disso, os outros métodos da classe Usuario não terão mais acesso às 
     * operações do menu, deixando de funcionar o campo contaLogada.
     */
    public void deslogarConta(){
        this.contaLogada = null;
    }
    
    /**
     * Método para cadastrar livros, criando objetos Livro e adicionando-os na lista de livros. 
     * @param titulo String - titulo do livro
     * @param autor String - nome do autor do livro
     * @param anoPublicacao int - ano de publicação do livro
     * @param quantidadeDisponivel int - quantidade de livros disponíveis
     * @param editora String - editora do livro
     * @param ISBN String - "código" do livro
     */
    public void cadastrarLivro(String titulo, String autor, int anoPublicacao, 
                               int quantidadeDisponivel, String editora, String ISBN){
        Livro livro = new Livro(titulo, autor, anoPublicacao, quantidadeDisponivel, editora, ISBN);
        livros.add(livro);
    }
    
    /**
     * Método para adicionar livro na lista de livros (usado na leitura do arquivo).
     * @param livro Livro - livro a ser adicionado
     */
    public void adicionarLivro(Livro livro){
        livros.add(livro);
    }
    
    /**
     * Método para cadastrar revistas, criando objetos Revista e adicionando-os na lista de revistas.
     * @param titulo String - titulo da revista
     * @param autor String - nome do autor da revista
     * @param anoPublicacao int - ano de publicação da revista
     * @param quantidadeDisponivel int - quantidade de revistas disponíveis
     * @param volume int - volume da revista
     * @param numero int - número da revista
     */
    public void cadastrarRevista(String titulo, String autor, int anoPublicacao, 
                                  int quantidadeDisponivel, int volume, int numero){
        Revista revista = new Revista(titulo, autor, anoPublicacao, quantidadeDisponivel, volume, numero);
        revistas.add(revista);
    }
    
    /**
     * Método para adicionar revista na lista de revistas (usado na leitura do arquivo).
     * @param revista 
     */
    public void adicionarRevista(Revista revista){
        revistas.add(revista);
    }
    
    /**
     * Método para cadastrar CDs, criando objetos CD e adicionando-os na lista de CD.
     * @param titulo String - titulo do CD
     * @param compositor String - nome do compositor do CD
     * @param anoPublicacao int - ano de publicação do CD
     * @param quantidadeDisponivel int - quantidade de CDs disponíveis
     * @param volume int - volume do CD
     * @param gravadora String - nome da gravadora do CD
     */
    public void cadastrarCD(String titulo, String compositor, int anoPublicacao, 
                            int quantidadeDisponivel, int volume, String gravadora){
        CD cd = new CD(titulo, compositor, anoPublicacao, quantidadeDisponivel, volume, gravadora);
        CD.add(cd);
    }
    
    /**
     * Método para adicionar CD na lista de CDs (usado na leitura do arquivo).
     * @param cd 
     */
    public void adicionarCD(CD cd){
        CD.add(cd);
    }
    
    /**
     * Método para buscar um livro disponível, a partir de seu nome (titulo)
     * @param nome String - título do livro
     * @return Livro - retorna o livro desejado ou NULL caso não o encontre
     */
    public Livro buscarLivro(String nome){
        for(Livro item : livros){
            if(item.getTitulo().equals(nome)){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Método para buscar uma revista disponível, a partir de seu nome (titulo)
     * @param nome String - título da revista
     * @return Revista - retorna a revista desejada ou NULL caso não a encontre
     */
    public Revista buscarRevista(String nome){
        for(Revista item : revistas){
            if(item.getTitulo().equals(nome)){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Método para buscar um CD disponível, a partir de seu nome (titulo)
     * @param nome String - título do CD
     * @return CD - retorna o CD desejado ou NULL caso não o encontre
     */
    public CD buscarCD(String nome){
        for(CD item : CD){
            if(item.getTitulo().equals(nome)){
                return item;
            }
        }
        return null;
    }
    
    /**
     * Método que verifica se um item está disponível para empréstimo.
     * Caso esteja disponível, cria um empréstimo e chama 
     * o método emprestimo na classe Item.
     * @param item Item - item que será emprestado 
     */
    public void itemDisponivel(Item item){
        if(item instanceof Livro){
            //se o livro desejado estiver disponível, faz o empréstimo
            if(item.getQuantidadeDisponivel() > 0){
                Emprestimo novo = new Emprestimo(item);
                item.emprestimo(novo, contaLogada);
            }
        }
        if(item instanceof Revista){
            //se a revista desejada estiver disponível, faz o empréstimo
            if(item.getQuantidadeDisponivel() > 0){
                Emprestimo novo = new Emprestimo(item);
                item.emprestimo(novo, contaLogada);
            }
        }
        if(item instanceof CD){
            //se o CD desejado estiver disponível, faz o empréstimo
            if(item.getQuantidadeDisponivel() > 0){
                Emprestimo novo = new Emprestimo(item);
                item.emprestimo(novo, contaLogada);
            }
        }
    }
}
