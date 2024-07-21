package com.mycompany.bancounesp;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que guarda os dados do Banco e contém métodos para casdastrar e buscar contas e agências, 
 * chamar operações de depósito e saque, e também tem métodos 
 * para transferência, pix e alterar senha (os quais chamam outros métodos das classes Agencia e Conta).
 * @author Amanda
 */

public class Banco {
    private int numeroBanco;
    private String nome;
    private String cnpj;
    private String endereco;
    protected Conta contaLogada;
    protected ArrayList<Agencia> agencias = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    
    /**
     * Construtor para gravar os dados do Banco.
     * @param nome String - nome do banco
     * @param numero int - número do banco
     * @param cnpj String - CNPJ do banco
     * @param endereco String - endereço do banco
     */
    public Banco(String nome, int numero, String cnpj, String endereco) {
        this.numeroBanco = numero;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }
    
    //getters e setters

    public int getNumero() {
        return numeroBanco;
    }

    public void setNumero(int numero) {
        this.numeroBanco = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Conta getContaLogada() {
        return contaLogada;
    }

    public void setContaLogada(Conta contaLogada) {
        this.contaLogada = contaLogada;
    }

    public ArrayList<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(ArrayList<Agencia> agencias) {
        this.agencias = agencias;
    }
    /**
     * Método para login que verifica se os dados passados pelo usuário estão corretos.
     * @param numAgencia int - número da agência do usuário
     * @param numConta int - número da conta do usuário
     * @param senha String - senha do usuário
     * @return boolean - retorna TRUE se a conta foi logada ou FALSE caso contrário
     */
    public boolean logarCliente(int numAgencia, int numConta, String senha){
        Agencia agenciaEncontrada = buscarAgencia(numAgencia); //busca a agência
        if(agenciaEncontrada != null){ //se encontrar a agência
            Conta contaEncontrada = agenciaEncontrada.buscarConta(numConta, senha); //busca a conta
            if(contaEncontrada != null){ //se encontrar a conta com a senha correta
                contaLogada = contaEncontrada; //entra na conta
                return true;
            }
        }
        return false;
    }
 
    /**
     * Método para depósito que chama o método "depositar" na classe Conta.
     * @param deposito double - valor que deseja depositar
     */
    public void realizarDeposito(double deposito){
        this.contaLogada.depositar(deposito);
    }
    
    /**
     * Método para saque que chama o método "sacar" na classe Conta.
     * @param saque double - valor que deseja sacar
     * @return double - retorna o valor do saldo após o saque
     */
    public double realizarSaque(double saque){
        return this.contaLogada.sacar(saque);
    }
    
    /**
     * Método para verificar o saldo que chama o método "getSaldo" da classe Conta.
     * @return double - retorna o valor atual do saldo
     */
    public double saldo(){
        return this.contaLogada.getSaldo();
    }
    
    /**
     * Método para criar objetos do tipo Agencia.
     * @param nome String - nome da agência 
     * @param codigo int - código da agência
     * @param endereco String - endereço da agência
     */
    public void cadastrarAgencia(String nome, int codigo, String endereco){
        Agencia agencia = new Agencia(nome, codigo, endereco);
        cadastrarAgencia(agencia); //chama o método para adicionar a agencia na lista
    }
    
    /**
     * Método para adicionar uma agência, já criada anteriormente, na lista de agências.
     * @param agencia Agencia - objeto do tipo Agencia
     */
    public void cadastrarAgencia(Agencia agencia){
        agencias.add(agencia);
    }
    
    /**
     * Método para criar objetos do tipo Conta e adicioná-los na lista de contas presente na classe Agencia.
     * @param numAgencia int - número da agência do cliente
     * @param numConta int - número da conta do cliente
     * @param nome String - nome do cliente
     * @param endereco String - endereço do cliente
     * @param cpf String - CPF do cliente
     * @param dataNasc String - data de nascimento do cliente
     * @param senha String - senha do cliente
     * @param saldo double - saldo do cliente
     */
    public void cadastrarConta(int numAgencia, int numConta, String nome, String endereco, String cpf, String dataNasc, String senha, double saldo){
        Conta conta = new Conta(nome, dataNasc, endereco, cpf, saldo, numConta, senha);
        for (Agencia item : agencias) {
                if (item.getCodigo() == numAgencia) {
                    item.cadastrarConta(conta);
                }
        }
    }
    
    /**
     * Método para buscar um agência a partir de seu código.
     * @param codigo int - código da agência procurada
     * @return Agencia - retorna a agencia desejada ou NULL caso não a encontre
     */
    public Agencia buscarAgencia(int codigo){
        for (Agencia item : agencias) {
            if (item.getCodigo() == codigo) {
                return item;
            }
        }
        return null;
    }

    /**
     * Método para transferência a partir dos números da agência e conta para qual deseja transferir.
     * <p>
     * Basicamente, após verificar se os dados estão corretos e se é possível realizar a transferência, 
     * é feito um saque na contaLogada (está transferindo) e um depósito na contaEncontrada (está recebendo).
     * @param numAgencia int - número da agência para qual será trasferido
     * @param numConta int - número da conta para qual será transferido
     * @return boolean - retorna TRUE se a transferência foi feita ou FALSE caso contrário
     */
    public boolean transferencia(int numAgencia, int numConta){
        double valor;
        int opcao;
        Conta contaEncontrada;
        Agencia agenciaEncontrada = buscarAgencia(numAgencia); //encontra a agência
        
        if(agenciaEncontrada != null){ 
            contaEncontrada = agenciaEncontrada.buscarConta(numConta); //encontra a conta
            if(contaEncontrada != null){
                do{
                    //verifica se é a conta certa para transferir
                    System.out.println("Deseja transferir para " + contaEncontrada.getNome() + "?");
                    System.out.println("(1) Sim");
                    System.out.println("(2) Não, tentar novamente");
                    opcao = scan.nextInt();
                    switch(opcao){
                        case 1 -> {
                            do{
                                System.out.println("Qual valor gostaria de transferir para " + contaEncontrada.getNome() + "?");
                                System.out.print("R$");
                                valor = scan.nextDouble();
                                if(valor > 0 && contaLogada.transferir(valor)){
                                    contaEncontrada.depositar(valor);
                                    return true;
                                }else{
                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println("\t\tValor inválido. Tente novamente.");
                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println();
                                }
                            }while(valor <= 0 || valor > contaLogada.getSaldo());
                        }

                        case 2 -> {
                            return false;
                        }
                        default -> {
                            System.out.println("------------------------------------------------------------------------");
                            System.out.println("\t\tOpção inválida. Tente novamente.");
                            System.out.println("------------------------------------------------------------------------");
                            System.out.println();
                        }
                    }
                }while(opcao < 1 || opcao > 2);
            }else{
                System.out.println("Número da conta inválido.");
                System.out.println();
            }
        }else{
            System.out.println("Número da agência inválido.");
            System.out.println();
        }
        return false;
    }
    
    /**
     * Método para fazer pix apartir do cpf, após coletar esse 
     * dado e encontrar a conta para qual quer fazer o pix, verifica se é mesmo a conta certa.
     * <p>
     * Este método utiliza a mesma lógica do método de transferência: 
     * após verificar se os dados estão corretos e se é possível realizar o pix, 
     * é feito um saque na contaLogada (está transferindo) 
     * e um depósito na contaEncontrada (está recebendo).
     * @param chaveCPF String - CPF para o qual deseja fazer o pix
     * @return boolean - retorna TRUE caso o pix seja feito ou FALSE caso contrário
     */
    public boolean pix(String chaveCPF){
        double valor;
        int opcao;
        for(Agencia item : agencias){ 
            Conta conta = item.buscarConta(chaveCPF);
            if(conta != null){ //se achar a conta para a qual quero transferir
                do{
                    //verifica se é a conta certa para transferir
                    System.out.println("Deseja transferir para " + conta.getNome() + "?");
                    System.out.println("(1) Sim");
                    System.out.println("(2) Não, tentar novamente");
                    opcao = scan.nextInt();
                    switch(opcao){
                        case 1 -> {
                            do{
                                System.out.println("Qual é o valor da transferência?");
                                System.out.print("R$");
                                valor = scan.nextDouble();
                                if(valor > 0 && contaLogada.transferir(valor)){
                                    conta.depositar(valor);
                                    return true;
                                }else{
                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println("\t\tValor inválido.");
                                    System.out.println("\t\tNão foi possível transferir. Tente novamente.");
                                    System.out.println("------------------------------------------------------------------------");
                                    System.out.println();
                                }
                            }while(valor <= 0 || valor > contaLogada.getSaldo());
                        }
                        case 2 -> {
                            return false;
                        }
                        default -> {
                            System.out.println("------------------------------------------------------------------------");
                            System.out.println("\t\tOpção inválida. Tente novamente.");
                            System.out.println("------------------------------------------------------------------------");
                            System.out.println();
                        }
                    }
                }while(opcao < 1 || opcao > 2);
            }
        }
        return false;
    }
    
    /**
     * Método para sair da conta logada.
     * <p>
     * O método irá setar como null o campo contaLogada, perdendo sua referência, 
     * ou seja, depois disso, os outros métodos da classe Banco não terão mais acesso às 
     * operações do menu, deixando de funcionar o campo contaLogada.
     */
    public void deslogarConta(){
        this.contaLogada = null;
    }
    
    /**
     * Método para alterar a senha do usuário.
     * <p>
     * Só será permitido alterar a senha se inserir corretamente a senha antiga, 
     * tendo três tentativas para tal. 
     * Observação: a senha é alterada momentâneamente (apenas durante a atual execução do programa, ou seja, 
     * caso reinicie a execução do código a senha voltará a ser a original que está no arquivo "contas.txt", 
     * afinal, os arquivos serão lidos novamente), 
     * pois não há alteração da senha no arquivo de contas ("contas.txt").
     * @return boolean - retorna TRUE caso a senha tenha sido alterada ou FALSE caso contrário
     */
    public boolean alterarSenha(){
        boolean valido;
        String senhaAntiga, senhaNova;
        int tentativas = 0;
        do{
            System.out.print("Digite sua senha atual: ");
            senhaAntiga = scan.nextLine();
            valido = contaLogada.validarSenha(senhaAntiga);
            if(valido){
                System.out.print("Digite sua nova senha: ");
                senhaNova = scan.nextLine();
                contaLogada.setSenha(senhaAntiga, senhaNova);
                return true;
            }else{
                System.out.println("------------------------------------------------------------------------");
                System.out.println("\t\tSenha inválida");
                System.out.println("\t\tVocê tem até 3 tentativas.");
                System.out.println("\t\t(Número de tentativas: " + (tentativas + 1) + ")");
                System.out.println("------------------------------------------------------------------------");
                tentativas++;
            }
        }while(!valido && tentativas < 3);
        return false;
    }
}