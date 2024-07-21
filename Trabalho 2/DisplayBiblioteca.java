package trabalho.biblioteca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe para leitura dos arquivos e login de usuários.
 * @author Amanda
 */
public class DisplayBiblioteca{
    //private Item item;
    //private Usuario usuario;
    protected BibliotecaUnesp biblioteca = new BibliotecaUnesp();
    Scanner scan = new Scanner(System.in);

    /**
     * Construtor que recebe o caminho do arquivo "items.txt" e "usuarios.txt" e faz a leitura.
     * @param itens String - caminho do arquivo de itens
     * @param usuarios String - caminho do arquivo de usuários
     */
    public DisplayBiblioteca(String itens, String usuarios){
         File arquivoItens = new File(itens);
         lerArquivoItens(arquivoItens);
         
         File arquivoUsuarios = new File(usuarios);
         lerArquivoUsuarios(arquivoUsuarios);    
    }
    
    /**
     * Método da tela inicial para fazer login.
     */
    public void login(){
        //variáveis
        int opcao;
        //tela inicial
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\t\tSeja bem vindo(a) a Biblioteca!");
        System.out.println();
        
            do{
                System.out.println("(1) Criar conta");
                System.out.println("(2) Login");
                System.out.println("(3) Administrador");
                System.out.println();
                System.out.print("Opção: ");
                opcao = scan.nextInt();
                switch(opcao){
                    case 1 -> criarConta();
                    case 2 -> loginUsuario();
                    case 3 -> loginAdm();
                    default -> {
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("\t\tOpção inválida. Tente novamente.");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println();
                    } 
                }
            }while(opcao < 1 || opcao > 3);  
    }
    
    
    /**
     * Método que permite o usuário criar uma conta.
     */
    public void criarConta(){
        int opcao;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\t\tCRIAR CONTA");
        System.out.println();
        do{
            System.out.println("Escolha o tipo de usuário a ser cadastrado:");
            System.out.println("(1) Aluno");
            System.out.println("(2) Professor");
            System.out.println("(3) Assessor Técnico");
            System.out.println();
            System.out.print("Opção: ");
            opcao = scan.nextInt();
        }while(opcao < 1 || opcao > 3);
        
        switch (opcao) {
            case 1 -> {
                try{
                    scan.nextLine();
                    System.out.print("Digite seu nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Digite seu CPF: ");
                    String cpf = scan.nextLine();
                    System.out.print("Digite sua matrícula: ");
                    String matricula = scan.nextLine();
                    System.out.print("Digite uma senha: ");
                    String senha = scan.nextLine();
                    System.out.print("Digite seu curso: ");
                    String curso = scan.nextLine();
                    System.out.print("Digite seu período: ");
                    String periodo = scan.nextLine();
                
                    //cria um novo usuário e faz o cadastro
                    Aluno aluno = new Aluno(nome, cpf, matricula, senha, curso, periodo);
                    if(biblioteca.cadastrarUsuario(aluno)){
                        System.out.println("Cadastrado com sucesso!");
                        login();
                    }else{
                        System.out.println("Não foi possível cadastrar.");
                        login();
                    }
                }catch(InputMismatchException e){
                    scan.nextLine();
                    System.out.println("Informações inválidas.");
                    login();
                }    
            }
            case 2 -> {
                try{
                    scan.nextLine();
                    System.out.print("Digite seu nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Digite seu CPF: ");
                    String cpf = scan.nextLine();
                    System.out.print("Digite sua matrícula: ");
                    String matricula = scan.nextLine();
                    System.out.print("Digite uma senha: ");
                    String senha = scan.nextLine();
                    System.out.print("Digite seu departamento: ");
                    String departamento = scan.nextLine();
                    System.out.print("Digite sua titulação: ");
                    String titulacao = scan.nextLine();
                
                    //cria um novo usuário e faz o cadastro
                    Professor prof = new Professor(nome, cpf, matricula, senha, departamento, titulacao);
                    if(biblioteca.cadastrarUsuario(prof)){
                        System.out.println("Cadastrado com sucesso!");
                        login();
                    }else{
                        System.out.println("Não foi possível cadastrar.");
                        login();
                    }
                }catch(InputMismatchException e){
                    scan.nextLine();
                    System.out.println("Informações inválidas.");
                    login();
                } 
            }
            case 3 -> {
                try{
                    scan.nextLine();
                    System.out.print("Digite seu nome: ");
                    String nome = scan.nextLine();
                    System.out.print("Digite seu CPF: ");
                    String cpf = scan.nextLine();
                    System.out.print("Digite sua matrícula: ");
                    String matricula = scan.nextLine();
                    System.out.print("Digite uma senha: ");
                    String senha = scan.nextLine();
                    System.out.print("Digite sua seção: ");
                    String secao = scan.nextLine();
               
                    //cria um novo usuário e faz o cadastro
                    AssessorTecnico assessor = new AssessorTecnico(nome, cpf, matricula, senha, secao);
                    if(biblioteca.cadastrarUsuario(assessor)){
                        System.out.println("Cadastrado com sucesso!");
                        login();
                    }else{
                        System.out.println("Não foi possível cadastrar.");
                        login();
                    }
                }catch(InputMismatchException e){
                    scan.nextLine();
                    System.out.println("Informações inválidas.");
                    login();
                } 
            }
            default -> {
                System.out.println("Opção inválida.");
            }
        }
    }
    
    /**
     * Método para fazer o login do usuário.
     */
    public void loginUsuario(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\t\tLOGIN");
        System.out.println();
        
        try{
            System.out.println("Para entrar em sua conta, por favor, informe os dados abaixo:");
            System.out.println();
            scan.nextLine();
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("CPF: ");
            String cpf = scan.nextLine();
            System.out.print("Senha: ");
            String senha = scan.nextLine();
            System.out.println();

            //se possível, loga o usuário e chama o menu com as opções 
            if(biblioteca.logarUsuario(nome, cpf, senha)){
                menuUsuario();
            }else{
                System.out.println("Não foi possível logar.");
                login();
            } 
        }catch(InputMismatchException e){
            scan.nextLine();
            System.out.println("Informações inválidas.");
            login();
        } 
    }
 
    /**
     * Método para fazer o login do Administrador,  
     * o qual pode fazer o cadastro de itens.
     */
    public void loginAdm(){
        try{
            System.out.println("Para entrar em sua conta, por favor, informe os dados abaixo:");
            System.out.println();
            scan.nextLine();
            System.out.print("Nome: ");
            String nome = scan.nextLine();
            System.out.print("CPF: ");
            String cpf = scan.nextLine();
            System.out.print("Senha: ");
            String senha = scan.nextLine();
            System.out.println();

            //se possível, loga o adm e chama o menu com as opções
            if(biblioteca.logarUsuario(nome, cpf, senha)){
                menuAdm();
            }else{
                System.out.println("Não foi possível logar.");
                login();
            } 
        }catch(InputMismatchException e){
            scan.nextLine();
            System.out.println("Informações inválidas.");
            login();
        } 
    }
    
    /**
     * Método para mostrar as opções do usuário após o login.
     */
    private void menuUsuario(){
        int opcao;
        System.out.println("\t\tBem vindo(a) " + biblioteca.contaLogada.getNome() + "!");
        System.out.println();
        do{
            do{
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Consultar empréstimos");
                System.out.println("2 - Buscar livros disponíveis");
                System.out.println("3 - Buscar revistas disponíveis");
                System.out.println("4 - Buscar CDs disponíveis");
                System.out.println("5 - Devolução");
                System.out.println("6 - Empréstimo");
                System.out.println("7 - Sair");
                System.out.println("------------------------------------------------------------------------");
                System.out.print("Opção: ");
                opcao = scan.nextInt();

                switch(opcao){
                    case 1 -> verEmprestimos();
                    case 2 -> operacaoBusca("livro");
                    case 3 -> operacaoBusca("revista");
                    case 4 -> operacaoBusca("cd");
                    case 5 -> operacaoDevolucao();
                    case 6 -> operacaoEmprestimo();
                    case 7 -> operacaoSair();
                    default -> { 
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("\t\tOpção inválida. Tente novamente.");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println();
                    }
                }
            }while(opcao < 1 || opcao > 7);
        }while(opcao != 7);
    }
    
    /**
     * Método para mostrar as opcões do Administrador após o login.
     */
    private void menuAdm(){
        int opcao;
        System.out.println("\t\tBem vindo(a) " + biblioteca.contaLogada.getNome() + "!");
        System.out.println();
        do{
            do{
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Cadastrar item");
                System.out.println("2 - Consultar empréstimos de usuário");
                System.out.println("3 - Sair");
                System.out.println("------------------------------------------------------------------------");
                System.out.print("Opção: ");
                opcao = scan.nextInt();

                switch(opcao){
                    case 1 -> cadastrarItem();
                    case 2 -> listaEmprestimos();
                    case 3 -> operacaoSair();
                    default -> { 
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("\t\tOpção inválida. Tente novamente.");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println();
                    }
                }
            }while(opcao < 1 || opcao > 3);
        }while(opcao != 3);
    }
    
    /**
     * Método para mostrar na tela a lista de itens emprestados pelo usuário.
     */
    private void verEmprestimos(){
        if(biblioteca.contaLogada.getItensEmprestados() != null){
            System.out.println("------------------------------------------------------------------------");
            System.out.println("\t\tMEUS EMPRÉSTIMOS");
            System.out.println();
            //busca os itens emprestados na lista de emprestimos do usuário 
            for(Emprestimo items : biblioteca.contaLogada.getItensEmprestados()){
                System.out.println(items.getItem().getTitulo());
            }
            System.out.println("------------------------------------------------------------------------");
        }else{
            System.out.println("Não possui empréstimos.");
            System.out.println();
        }
    }
    
    /**
     * Método disponível apenas para o administrador, 
     * para listagem de itens emprestados por usuário, a partir da matrícula.
     */
    private void listaEmprestimos(){
        scan.nextLine();
        System.out.print("Digite a matrícula do usuário: ");
        String numero = scan.nextLine();

        //busca os itens emprestados na lista de emprestimos do usuário, a partir da matrícula
        Usuario user = biblioteca.buscarUsuario(numero);
        if(user != null){
            System.out.println("------------------------------------------------------------------------");
            System.out.println("\t\tEMPRÉSTIMOS");
            System.out.println();
            for(Emprestimo items : user.getItensEmprestados()){
                System.out.println(items.getItem().getTitulo());
            }
            System.out.println("------------------------------------------------------------------------");
        }    
    }
    
    /**
     * Método para buscar itens disponíveis, a partir de seu nome, listando os dados do item.
     * @param tipo String - tipo do item a ser buscado (livro, revista ou CD)
     */
    private void operacaoBusca(String tipo){
        if(tipo.equals("livro")){
            scan.nextLine();
            System.out.print("Digite o nome do livro desejado: ");
            String nome = scan.nextLine();
            Livro livro;
            
            livro = biblioteca.buscarLivro(nome);
            if(livro != null){
                System.out.println("------------------------------------------------------------------------");
                System.out.println("\t\t" + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Editora: " + livro.getEditora());
                System.out.println("ISBN: " + livro.getISBN());
                System.out.println("Ano de publicação: " + livro.getAnoPublicacao());
                System.out.println("Quantidade disponível: " + livro.getQuantidadeDisponivel());
                System.out.println("------------------------------------------------------------------------");
            }else{
                System.out.println("Item não encontrado.");
            }
        }
        if(tipo.equals("revista")){
            scan.nextLine();
            System.out.print("Digite o nome da revista desejada: ");
            String nome = scan.nextLine();
            Revista revista;
            
            revista = biblioteca.buscarRevista(nome);
            if(revista != null){
                System.out.println("------------------------------------------------------------------------");
                System.out.println("\t\t" + revista.getTitulo());
                System.out.println("Autor: " + revista.getAutor());
                System.out.println("Volume: " + revista.getVolumeRevista());
                System.out.println("Número: " + revista.getNumero());
                System.out.println("Ano de publicação: " + revista.getAnoPublicacao());
                System.out.println("Quantidade disponível: " + revista.getQuantidadeDisponivel());
                System.out.println("------------------------------------------------------------------------");
            }else{
                System.out.println("Item não encontrado.");
            }
        }
        if(tipo.equals("cd")){
            scan.nextLine();
            System.out.print("Digite o nome do CD desejado: ");
            String nome = scan.nextLine();
            CD cd;
            
            cd = biblioteca.buscarCD(nome);
            if(cd != null){
                System.out.println("------------------------------------------------------------------------");
                System.out.println("\t\t" + cd.getTitulo());
                System.out.println("Autor: " + cd.getAutor());
                System.out.println("Volume: " + cd.getVolumeCD());
                System.out.println("Gravadora: " + cd.getGravadora());
                System.out.println("Ano de publicação: " + cd.getAnoPublicacao());
                System.out.println("Quantidade disponível: " + cd.getQuantidadeDisponivel());
                System.out.println("------------------------------------------------------------------------");
            }else{
                System.out.println("Item não encontrado.");
            }
        }
    }
    
    /**
     * Método para cadastrar item se possível, disponível apenas para o administrador.
     */
    private void cadastrarItem(){
        int opcao;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\t\tCADASTRAR ITEM");
        do{
            System.out.println("Escolha o tipo do item a ser cadastrado:");
            System.out.println("(1) Livro");
            System.out.println("(2) Revista");
            System.out.println("(3) CD");
            System.out.println();
            System.out.print("Opção: ");
            opcao = scan.nextInt();
        }while(opcao < 1 || opcao > 3);
        
        switch (opcao) {
            case 1 -> {
                try{
                    scan.nextLine();
                    System.out.print("Digite o título: ");
                    String titulo = scan.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = scan.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int anoPubli = scan.nextInt();
                    System.out.print("Digite a quantidade disponível: ");
                    int quantidade = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Digite a editora: ");
                    String editora = scan.nextLine();
                    System.out.print("Digite o ISBN: ");
                    String isbn = scan.nextLine();

                    biblioteca.cadastrarLivro(titulo, autor, anoPubli, quantidade, editora, isbn);
                    System.out.println("Item cadastrado com sucesso!");
                }catch(InputMismatchException e){
                    scan.nextLine();
                    System.out.println("Informações inválidas.");
                }
            }
            case 2 -> {
                try{
                    scan.nextLine();
                    System.out.print("Digite o título: ");
                    String titulo = scan.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = scan.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int anoPubli = scan.nextInt();
                    System.out.print("Digite a quantidade disponível: ");
                    int quantidade = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Digite o volume: ");
                    int volume = scan.nextInt();
                    System.out.print("Digite o número: ");
                    int numero = scan.nextInt();
                    biblioteca.cadastrarRevista(titulo, autor, anoPubli, quantidade, volume, numero);
                    System.out.println("Item cadastrado com sucesso!");
                }catch(InputMismatchException e){
                    scan.nextLine();
                    System.out.println("Informações inválidas.");
                }    
            }
            case 3 -> {
                try{
                    scan.nextLine();
                    System.out.print("Digite o título: ");
                    String titulo = scan.nextLine();
                    System.out.print("Digite o autor: ");
                    String autor = scan.nextLine();
                    System.out.print("Digite o ano de publicação: ");
                    int anoPubli = scan.nextInt();
                    System.out.print("Digite a quantidade disponível: ");
                    int quantidade = scan.nextInt(); 
                    scan.nextLine();
                    System.out.print("Digite o volume: ");
                    int volume = scan.nextInt();
                    System.out.print("Digite a gravadora: ");
                    String gravadora = scan.nextLine();
                
                    biblioteca.cadastrarCD(titulo, autor, anoPubli, quantidade, volume, gravadora);
                    System.out.println("Item cadastrado com sucesso!");
                }catch(InputMismatchException e){
                    scan.nextLine();
                    System.out.println("Informações inválidas.");
                }
            }
            default -> {
                System.out.println("Opção inválida.");
            }
        }
    }
    
    /**
     * Método para devolver um item, faz a busca na lista de empréstimos e 
     * caso encontre, faz a devolução e aplica multas se necessário.
     */
    private void operacaoDevolucao(){
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\t\tDEVOLUÇÃO");

        try{
            System.out.print("Digite o nome do item: ");
            String nome = scan.nextLine();
            Emprestimo emprestimo = biblioteca.contaLogada.buscarEmprestimo(nome);

            if(emprestimo != null){
                /*se achar o item na lista de itens emprestados, então o devolve.
                  O método devolucao na classe Item faz chamadas internas que calculam a multa.
                */
                emprestimo.getItem().devolucao(emprestimo.getItem(), biblioteca.contaLogada);
                biblioteca.removerEmprestimo(nome);
            }else{
                System.out.println("Item não emprestado.");
            }
        }catch(InputMismatchException e){
            scan.nextLine();
            System.out.println("Informações inválidas.");
        }
    }
    
    /**
     * Método para fazer o empréstimo de um item, a partir de seu nome.
     * Se o item desejado existir e estiver disponível, então faz o empréstimo.
     */
    private void operacaoEmprestimo(){
        int opcao;
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\t\tFAZER EMPRÉSTIMO");
        do{
            System.out.println("Escolha o tipo do item: ");
            System.out.println("(1) Livro");
            System.out.println("(2) Revista");
            System.out.println("(3) CD");
            System.out.println();
            System.out.print("Opção: ");
            opcao = scan.nextInt();
        }while(opcao < 1 || opcao > 3);
        
        switch (opcao) {
            case 1 -> {
                scan.nextLine();
                System.out.print("Digite o nome do livro: ");
                String nome = scan.nextLine();
                Livro livro;
                livro = biblioteca.buscarLivro(nome);
                //se o livro existir, verifica se está disponível e então faz o empréstimo (métodos internos)
                if(livro != null){    
                    biblioteca.itemDisponivel(livro);
                }else{
                    System.out.println("Item não encontrado.");
                }   
            }
            case 2 -> {
                scan.nextLine();
                System.out.print("Digite o nome da revista: ");
                String nome = scan.nextLine();
                Revista revista;
                revista = biblioteca.buscarRevista(nome);
                //se a revista existir, verifica se está disponível e então faz o empréstimo (métodos internos)
                if(revista != null){    
                biblioteca.itemDisponivel(revista);
                }else{
                    System.out.println("Item não encontrado.");
                }
            }
            case 3 -> {
                scan.nextLine();
                System.out.print("Digite o nome do CD: ");
                String nome = scan.nextLine();
                CD cd;
                cd = biblioteca.buscarCD(nome);
                //se o CD existir, verifica se está disponível e então faz o empréstimo (métodos internos)
                if(cd != null){   
                    biblioteca.itemDisponivel(cd);
                }else{
                    System.out.println("Item não encontrado.");
                }     
            }
            default -> {
                System.out.println("Opção inválida.");
            }
        }
    }
    
    /**
     * Método para sair da conta através da chamada do método 
     * "deslogarConta" da classe BibliotecaUnesp.
     * Após sair da conta, a tela de login reaparece.
     */
    private void operacaoSair(){
        System.out.println("Saindo da conta de " + biblioteca.contaLogada.getNome() + "...");
        System.out.println();
        biblioteca.deslogarConta();
        login();
    }
    
    /**
     * Método para ler o arquivo de itens.
     * @param arquivoItens Arquivo de itens
     */
    public void lerArquivoItens(File arquivoItens){
        // Cria um objeto Scanner para ler o arquivo
        Scanner scanner = null ;
        try {
            scanner = new Scanner( arquivoItens ) ;
        } catch ( FileNotFoundException ex) {
            Logger.getLogger ( Biblioteca.class.getName()).log( Level .SEVERE , null , ex);
          }

        // Lê cada linha do arquivo
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine () ;

            // Divide a linha em campos separados por #
            String[] campos = linha.split ( "#") ;
            
            String tipo = campos[0];
            
            //Lê os dados das Revistas e as cadastra na lista de revistas
            if(tipo.equals("Revista")){
                String titulo = campos[1];
                String autor = campos[2];
                int anoPublicacao = Integer.valueOf(campos[3]);
                int quantidadeDisponivel = Integer.valueOf(campos[4]);
                int volume = Integer.valueOf(campos[5]);
                int numero = Integer.valueOf(campos[6]);
                
                Revista revista = new Revista(titulo, autor, anoPublicacao, quantidadeDisponivel, volume, numero);
                biblioteca.adicionarRevista(revista);
            }
            
            //Lê os dados dos Livros e os cadastra na lista de livros
            if(tipo.equals("Livro")){
                String titulo = campos[1];
                String autor = campos[2];
                int anoPublicacao = Integer.valueOf(campos[3]);
                int quantidadeDisponivel = Integer.valueOf(campos[4]);
                String editora = campos[5];
                String ISBN = campos[6];
                
                Livro livro = new Livro(titulo, autor, anoPublicacao, quantidadeDisponivel, editora, ISBN);
                biblioteca.adicionarLivro(livro);
                
            }
            
            //Lê os dados dos CDs e os cadastra na lista de CDs
            if(tipo.equals("CD")){
                String titulo = campos[1];
                String compositor = campos[2];
                int anoPublicacao = Integer.valueOf(campos[3]);
                int quantidadeDisponivel = Integer.valueOf(campos[4]);
                int volume = Integer.valueOf(campos[5]);
                String gravadora = campos[6];
                
                CD cd = new CD(titulo, compositor, anoPublicacao, quantidadeDisponivel, volume, gravadora);
                biblioteca.adicionarCD(cd);
                
            }
        }
    }
    
    /**
     * Método para ler o arquivo de usuários.
     * @param arquivoUsuarios Arquivo de usuários
     */
    
    public void lerArquivoUsuarios(File arquivoUsuarios){
        // Cria um objeto Scanner para ler o arquivo
        Scanner scanner = null ;
        try {
            scanner = new Scanner( arquivoUsuarios ) ;
        } catch ( FileNotFoundException ex) {
            Logger.getLogger ( Biblioteca.class.getName()).log( Level .SEVERE , null , ex);
          }

        // Lê cada linha do arquivo
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine () ;

            // Divide a linha em campos separados por #
            String[] campos = linha.split ( "#") ;
            
            String tipo = campos[0];
            
            //Lê os dados do Aluno e o cadastra na lista de usuários
            if(tipo.equals("Aluno")){
                String nome = campos[1];
                String matricula = campos[2];
                String cpf = campos[3];
                String curso = campos[4];
                String periodo = campos[5];
                String senha = campos[6];
               
                Aluno aluno = new Aluno(nome, cpf, matricula, senha, curso, periodo);
                biblioteca.cadastrarUsuario(aluno);
            }
            
            //Lê os dados do Professor e o cadastra na lista de usuários
            if(tipo.equals("Professor")){
                String nome = campos[1];
                String matricula = campos[2];
                String cpf = campos[3];
                String departamento = campos[4];
                String titulacao = campos[5];
                String senha = campos[6];
                
                Professor prof = new Professor(nome, cpf, matricula, senha, departamento, titulacao);
                biblioteca.cadastrarUsuario(prof);
            }
            
            //Lê os dados do AssessorTecnico e o cadastra na lista de usuários
            if(tipo.equals("Tecnico")){
                String nome = campos[1];
                String matricula = campos[2];
                String cpf = campos[3];
                String secao = campos[4];
                String senha = campos[5];
                
                AssessorTecnico assessor = new AssessorTecnico(nome, cpf, matricula, senha, secao);
                biblioteca.cadastrarUsuario(assessor);
            }
            
            //Lê os dados do Administrador e o cadastra na lista de usuários
            if(tipo.equals("Administrador")){
                String nome = campos[1];
                String senha = campos[2];
                String cpf = campos[3];
                
                Administrador adm = new Administrador(nome, senha, cpf);
                biblioteca.cadastrarUsuario(adm);
            }
        }
    }
}