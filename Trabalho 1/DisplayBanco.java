package com.mycompany.bancounesp;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A classe DisplayBanco além de ler os arquivos de agências, contas e banco 
 * também irá fazer o login do usuário, mostrando na tela todas as operações possíveis.
 * @author Amanda
 */

public class DisplayBanco {
    private Banco meuBanco;
    Scanner scan = new Scanner(System.in);
    
    /**
     * Construtor do DisplayBanco fará a leitura de todos os arquivos, 
     * instanciando um objeto "meuBanco" do tipo Banco e 
     * criando agências e suas respectivas contas.
     * @param banco - caminho do arquivo "banco.txt"
     * @param agencias - caminho do arquivo "agencias.txt"
     * @param contas - caminho do arquivo "contas.txt"
     */
    public DisplayBanco(String banco, String agencias, String contas){
        File arquivoBanco = new File(banco);
        lerArquivoBanco(arquivoBanco); //método que instancia o objeto meuBanco do tipo Banco
        
        //criar as agências em meuBanco
        File arquivoAgencias = new File(agencias);
        lerArquivoAgencia(arquivoAgencias);
        
        //criar as contas de cada agência
        File arquivoContas = new File(contas);
        lerArquivoContas(arquivoContas);
        
    }
    
    /**
     * Método para entrar na conta do usuário após verificar se os dados 
     * fornecidos estão corretos.
     */
    public void login(){
        boolean repetir;
        
        //interface
        System.out.println("------------------------------------------------------------------------");
        System.out.println("\t\tSeja bem vindo(a) ao " + this.meuBanco.getNome() + "!");
        System.out.println();
        System.out.println("Para entrar em sua conta, por favor, informe os dados abaixo:");
        System.out.println();
        
        do{
            System.out.print("Número da agência: ");
            int numeroAgencia = scan.nextInt();
            System.out.print("Número da conta: ");
            int numeroConta = scan.nextInt();
            scan.nextLine();
            System.out.print("Senha: ");
            String senha = scan.nextLine();
            System.out.println();
        
            //verificar se as informaç̃oes fornecidas estão corretas
            if(meuBanco.logarCliente(numeroAgencia, numeroConta, senha)){
                //se os dados estiverem certos, abre o menu com as opções para o usuário
                repetir = false;
                telaUsuario();
            }else{
                repetir = true;
                System.out.println("Dados incorretos. Tente novamente.");
                System.out.println("------------------------------------------------------------------------");
            }
        }while(repetir); //se houver erros, permite o usuário tentar logar novamente 
    }
    
    /**
     * Método para mostrar ao usuário as opções de operações:
     * consultar saldo, depositar, sacar, tranferir, pix, sair da conta e alterar senha.
     */
    private void telaUsuario(){
        int opcao;
        //interface
        System.out.println("\t\tBem vindo(a) " + meuBanco.contaLogada.getNome() + "!");
        System.out.println();
        do{
            do{
                System.out.println("------------------------------------------------------------------------");
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Consultar Saldo");
                System.out.println("2 - Depósito");
                System.out.println("3 - Saque");
                System.out.println("4 - Transferência");
                System.out.println("5 - Pix");
                System.out.println("6 - Sair");
                System.out.println("7 - Alterar senha");
                System.out.println("------------------------------------------------------------------------");
                System.out.print("Opção: ");
                opcao = scan.nextInt();

                switch(opcao){
                    case 1 -> operacaoSaldo();
                    case 2 -> operacaoDeposito();
                    case 3 -> operacaoSaque();
                    case 4 -> operacaoTransferencia();
                    case 5 -> operacaoPix();
                    case 6 -> operacaoSair();
                    case 7 -> operacaoSenha();
                    default -> { 
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println("\t\tOpção inválida. Tente novamente.");
                        System.out.println("------------------------------------------------------------------------");
                        System.out.println();
                    }
                }
            }while(opcao < 1 || opcao > 7);
        }while(opcao != 6);
    }
    
    /**
     * Método para fazer um depósito, caso seja possível, através da chamada 
     * do método "realizarDeposito" da classe Banco, que por sua vez chama o 
     * método "depositar" na classe Conta.
     */
    private void operacaoDeposito(){
        double valor;
        
        System.out.println("------------------------------ DEPÓSITO --------------------------------");
        System.out.println();
        do{
            System.out.print("Digite o valor a ser depositado: ");
            valor = scan.nextDouble();
            if(valor <= 0){ //só pode depositar um valor positivo
                System.out.println("------------------------------------------------------------------------");
                System.out.println("\t\tValor inválido. Tente novamente.");
                System.out.println("------------------------------------------------------------------------");
                System.out.println();
            }else{
                meuBanco.realizarDeposito(valor); // faz o depósito
                operacaoSaldo(); //mostra o saldo após o depósito
            }
        }while(valor <= 0);
    }
    
    /**
     * Método para fazer um saque, caso seja possível, através da chamada do 
     * método "realizarSaque" na classe Banco, que por sua vez chama o 
     * método "sacar" na classe Conta.
     */
    private void operacaoSaque(){
        double valor;
        
        System.out.println("-------------------------------- SAQUE ---------------------------------");
        System.out.println();
        do{
            System.out.print("Digite o valor a ser sacado: ");
            valor = scan.nextDouble();
            if(valor <= 0){
                System.out.println("------------------------------------------------------------------------");
                System.out.println("\t\tValor inválido. Tente novamente.");
                System.out.println("------------------------------------------------------------------------");
                System.out.println();
            }else{ //se o valor for válido, faz o saque
                meuBanco.realizarSaque(valor);
                operacaoSaldo(); //mostra o saldo após o saque
            }
        }while(valor <=0 || valor > meuBanco.contaLogada.getSaldo());
    }
    
    /**
     * Método para fazer um pix, caso seja possível, usando o CPF como chave, 
     * através da chamada do método "pix" na classe Banco.
     */
    private void operacaoPix(){
        Scanner scanner = new Scanner(System.in);
        boolean transferiu;
        
        System.out.println("--------------------------------- PIX ----------------------------------");
        System.out.println();
        do{
            System.out.print("Digite o CPF para o qual deseja transferir: ");
            String cpf = scanner.nextLine();
            transferiu = meuBanco.pix(cpf);
            if(transferiu){
                System.out.println("PIX realizado com sucesso!");
                operacaoSaldo(); //mostra o saldo após o pix
            }else{
                System.out.println("------------------------------------------------------------------------");
                System.out.println("\t\tNão foi possível transferir, tente novamente.");
                System.out.println("------------------------------------------------------------------------");
                System.out.println();
            }
        }while(!transferiu); //permite tentar novamente caso digite o cpf errado ou o saldo seja insuficiente para realizar a transferência
    }
    
    /**
     * Método para fazer uma transferência, caso seja possível, 
     * utilizando os números da agência e conta, através do método "transferencia" 
     * da classe Banco.
     */
    private void operacaoTransferencia(){
        int numAgencia, numConta;
        boolean transferiu;
        
        System.out.println("----------------------------- TRANSFERÊNCIA ----------------------------");
        System.out.println();
        do{
            System.out.print("Digite o número da agência: ");
            numAgencia = scan.nextInt();
            System.out.print("Digite o número da conta: ");
            numConta = scan.nextInt();
            transferiu = meuBanco.transferencia(numAgencia, numConta);
            if(transferiu){
                System.out.println("Transferência realizada com sucesso!");
                operacaoSaldo(); //mostra o saldo após a transferência
            }
        }while(!transferiu); //permite tentar novamente caso os números da conta e agência estejam errados ou se fosse transferir para a pessoa errada
    }
    
    /**
     * Método para ver o Saldo através do método "saldo" da classe Banco, 
     * que por sua vez chama o método "getSaldo" da classe Conta.
     */
    private void operacaoSaldo(){
        System.out.println("Seu saldo é: R$" + meuBanco.saldo());
        System.out.println();
    }
    
    /**
     * Método para sair da conta através da chamada do método 
     * "deslogarConta" da classe Banco.
     * Após sair da conta, a tela de login reaparece.
     */
    private void operacaoSair(){
        System.out.println("Saindo da conta de " + meuBanco.contaLogada.getNome() + "...");
        System.out.println();
        meuBanco.deslogarConta();
        login();
    }
    
    /**
     * Método para alterar a senha, que só é possível se
     * lembrar a senha antiga.
     * Chama o método "alterarSenha" da classe Banco.
     */
    private void operacaoSenha(){
        boolean alterou;
        System.out.println("---------------------------- ALTERAR SENHA -----------------------------");
        System.out.println();
        alterou = meuBanco.alterarSenha();
        if(alterou){
            System.out.println("Senha alterada com sucesso!");
            System.out.println();
        }else{
            System.out.println("Não foi possível alterar sua senha.");
            System.out.println();
        }
    }
    
    /**
     * Método para ler o arquivo do Banco.
     * @param arquivoBanco - caminho do arquivo "banco.txt"
     */
    public void lerArquivoBanco(File arquivoBanco){
        // Cria um objeto Scanner para ler o arquivo
        Scanner scanner = null ;
        try {
            scanner = new Scanner( arquivoBanco ) ;
        } catch ( FileNotFoundException ex) {
            Logger.getLogger ( BancoUnesp.class.getName()).log( Level .SEVERE , null , ex);
          }

        // Lê cada linha do arquivo
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine () ;

            // Divide a linha em campos separados por #
            String[] campos = linha.split ( "#") ;
            
            //Shadowing:
            String nome = campos[0];
            int numero = Integer.valueOf(campos[1]);
            String cnpj = campos[2];
            String endereco = campos[3];
   
            this.meuBanco = new Banco(nome, numero, cnpj, endereco);
        }
    }

    /**
     * Método para ler o arquivo de Agências.
     * @param arquivoAgencias - caminho do arquivo "agencias.txt"
     */
    public void lerArquivoAgencia(File arquivoAgencias) {
        // Cria um objeto Scanner para ler o arquivo
        Scanner scanner = null ;
        try {
            scanner = new Scanner( arquivoAgencias ) ;
        } catch ( FileNotFoundException ex) {
            Logger.getLogger ( BancoUnesp.class.getName()).log( Level .SEVERE , null , ex);
          }

        // Lê cada linha do arquivo
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine () ;

            // Divide a linha em campos separados por #
            String[] campos = linha.split ( "#") ;
            
            String nome = campos[0];
            int codigo = Integer.valueOf(campos[1]);
            String endereco = campos[2];
            
            meuBanco.cadastrarAgencia(nome, codigo, endereco);

        }
    }
    
    /**
     * Método para ler o arquivo de Contas.
     * @param arquivoContas - caminho do arquivo "contas.txt"
     */
    public void lerArquivoContas(File arquivoContas){
        // Cria um objeto Scanner para ler o arquivo
        Scanner scanner = null ;
        try {
            scanner = new Scanner( arquivoContas ) ;
        } catch ( FileNotFoundException ex) {
            Logger.getLogger ( BancoUnesp.class.getName()).log( Level .SEVERE , null , ex);
          }

        // Lê cada linha do arquivo
        while (scanner.hasNextLine()) {
            String linha = scanner.nextLine () ;

            // Divide a linha em campos separados por #
            String[] campos = linha.split ( "#") ;
            
            String nome = campos[0];
            String data = campos[1];
            String endereco = campos[2];
            String cpf = campos[3];
            double saldo = Double.valueOf(campos[4]);
            int numeroAgencia = Integer.valueOf(campos[5]);
            int numeroConta = Integer.valueOf(campos[6]);
            String senha = campos[7];
            
            meuBanco.cadastrarConta(numeroAgencia, numeroConta, nome, endereco, cpf, data, senha, saldo);
            
        }
    }
}
    