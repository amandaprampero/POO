package trabalho.biblioteca;

/**
 * Classe Biblioteca possui a main para chamar o login da classe DisplayBiblioteca, 
 * passando como parâmetros os caminhos para a leitura dos arquivos.
 * @author Amanda
 */
public class Biblioteca {

    public static void main(String[] args){
        
        String itens = "D:\\Perfil Amanda\\Documents\\unesp\\projetos\\Biblioteca\\items.txt";
        String usuarios = "D:\\Perfil Amanda\\Documents\\unesp\\projetos\\Biblioteca\\usuarios.txt";
        DisplayBiblioteca displayBiblioteca = new DisplayBiblioteca(itens, usuarios);
        displayBiblioteca.login();
        
    }
}