package com.mycompany.bancounesp;

/**
 * Classe para guardar os dados das contas e realizar as operações de depósito, 
 * saque, transferência e validação de senha.
 * @author Amanda
 */
public class Conta {
    private int numeroConta;
    private double saldo;
    private String nome;
    private String endereco;
    private String cpf;
    private String dataNascimento;
    private String senha;
    
    /**
     * Construtor para guardar os dados das contas.
     * @param nome String - nome do cliente
     * @param data String - data de nascimento do cliente
     * @param endereco String - endereço do cliente
     * @param cpf String - CPF do cliente
     * @param saldo double - saldo do cliente
     * @param numeroConta int - número da conta do cliente
     * @param senha String - senha do cliente
     */
    public Conta(String nome, String data, String endereco, String cpf, double saldo, int numeroConta, String senha){
        this.nome = nome;
        this.dataNascimento = data;
        this.endereco = endereco;
        this.cpf = cpf;
        this.saldo = saldo;
        this.numeroConta = numeroConta;
        this.senha = senha;
    }
    
    /**
     * Método para depositar um valor ao saldo da conta.
     * @param deposito double - valor a ser depositado
     */
    public void depositar(double deposito){
        this.setSaldo(this.getSaldo() + deposito);
    }
    
    /**
     * Método para sacar um valor do saldo da conta, caso seja possível.
     * @param saque double - valor a ser sacado
     * @return double - retorna o saldo após o saque
     */
    public double sacar(double saque){
        if(this.getSaldo() >= saque){ //se possuir saldo para retirar
            this.setSaldo(this.getSaldo() - saque);
        }else{
            System.out.println("Saldo insuficiente para saque.");
        }
        return this.getSaldo();
    }
    
    /**
     * Método para verificar se o saque é possível e faze-lo, usado nas operações de pix e trasnferência. 
     * @param valor double - valor a ser sacado
     * @return boolean - retorna TRUE caso seja feito o saque ou FALSE caso contrário
     */
    public boolean transferir(double valor){
        if(this.getSaldo() >= valor){ //se possuir saldo para retirar
            this.setSaldo(this.getSaldo() - valor);
            return true;
        }else{
            System.out.println("Saldo insuficiente para realizar a transferência.");
        }
        return false;
    }
    
    /**
     * Método para validar a senha, comparando a senha digitada pelo usuário e a senha da conta.
     * @param senhaComparar String - senha digitada pelo usuário
     * @return boolean - retorna TRUE se a senha estiver correta ou FALSE caso contrário
     */
    public boolean validarSenha(String senhaComparar){
        return (this.senha.equals(senhaComparar));
    }

    
    //métodos set e get

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    /**
     * Método para alterar senha a partir da senha antiga.
     * Só é possível fazer a alteração se a senha antiga for validada.
     * @param senhaAtual String - senha antiga
     * @param senhaNova String - senha nova
     */
    public void setSenha(String senhaAtual, String senhaNova) {
        if(validarSenha(senhaAtual)){
            this.senha = senhaNova;
        }
    }
}
