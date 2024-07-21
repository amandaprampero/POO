package com.mycompany.bancounesp;

import java.util.ArrayList;

/**
 * Classe que grava os dados das agências e adiciona uma lista de contas para cada uma. 
 * Além disso, as contas são cadastradas nessa classe, assim como sua busca (utilizando sobrecarga).
 * @author Amanda
 */
public class Agencia {
    private int codigo;
    private String nome;
    private String endereco;
    protected ArrayList<Conta> contas = new ArrayList<>();
    
    /**
     * Construtor para guardar os dados das agências.
     * @param nome String - nome da agência
     * @param codigo int - código da agência
     * @param endereco String - endereço da agência
     */
    public Agencia (String nome, int codigo, String endereco) {
        this.nome = nome;
        this.codigo = codigo;
        this.endereco = endereco;
    }

    //getters e setters

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }
    
    /**
     * Método para adicionar uma conta, já criada anteriormente, na lista de contas de sua agência correspondente.
     * @param conta Conta - objeto do tipo Conta 
     */
    public void cadastrarConta(Conta conta){
        contas.add(conta);
    }
    
    /**
     * Método para buscar conta a partir de seu número e validar sua senha, utilizando o método "validarSenha" da classe Conta.
     * @param numConta int - número da conta
     * @param senha String - senha da conta
     * @return Conta - retorna a conta caso a encontre ou NULL caso contrário
     */
    public Conta buscarConta(int numConta, String senha){
        for (Conta item : contas) {
            if (item.getNumeroConta() == numConta && item.validarSenha(senha)) {
                return item;
            }
        }
        return null;
    }
    
    /**
     * Método para buscar conta a partir de seu número.
     * @param numConta int - número da conta procurada
     * @return Conta - retorna a conta caso a encontre ou NULL caso contrário
     */
    public Conta buscarConta(int numConta){
        int i;
        int tamanho = contas.toArray().length;
        for(i=0; i<tamanho; i++){ //laço para encontrar a conta
            if (contas.get(i).getNumeroConta() == numConta) {
                return contas.get(i);
            }
        }
        return null; //se não encontrar a conta
    }
    
    /**
     * Método para buscar conta a partir de seu CPF, utilizado no método para fazer pix.
     * @param cpf String - CPF da conta procurada
     * @return Conta - retorna a conta caso a encontre ou NULL caso contrário
     */
    public Conta buscarConta(String cpf){
        for (Conta item : contas) {
            if (item.getCpf().equals(cpf)) {
                return item;
            }
        }
        return null;
    }
    
}
