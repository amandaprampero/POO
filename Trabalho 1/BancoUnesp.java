package com.mycompany.bancounesp;

/**
 * Classe BancoUnesp possui a main para chamar o login da classe DisplayBanco 
 * passando como parâmetros os caminhos para a leitura dos arquivos. 
 * @author Amanda
 */
public class BancoUnesp {

    public static void main(String[] args) {
 
        String banco = "D:\\Perfil Amanda\\Documents\\unesp\\projetos\\BancoUnesp\\banco.txt";
        String agencias = "D:\\Perfil Amanda\\Documents\\unesp\\projetos\\BancoUnesp\\agencias.txt";
        String contas = "D:\\Perfil Amanda\\Documents\\unesp\\projetos\\BancoUnesp\\contas.txt";
        DisplayBanco displayBanco = new DisplayBanco(banco, agencias, contas);
        displayBanco.login();
    }
}