package trabalho.biblioteca;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Quando um usuário empresta um item, um novo objeto da classe Emprestimo
 * ́e criado e adicionado à lista de empréstimos do usuário. 
 * Quando o item é devolvido, a data de devoluç̃ao real ́e atualizada no objeto
 * Emprestimo, e a multa por atraso na devoluç̃ao, se houver, ́e calculada.
 * @author Amanda
 */
public class Emprestimo {
    //private Usuario user;
    private Item item;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    
    /**
     * Construtor para guardar os dados do empréstimo.
     * @param item 
     */
    public Emprestimo(Item item){
        this.item = item;
        //pega a data atual do empréstimo
        this.dataEmprestimo = LocalDate.now();
        //chama o método para calcular a data de devolução prevista
        this.dataDevolucaoPrevista = calcularDataPrevista(dataEmprestimo);
        /*esse construtor é chamado quando acaba de fazer um empréstimo,
        ou seja, ainda não se sabe a data de devolução real
        */
        this.dataDevolucaoReal = null;
    }
    
    /**
     * Método para emprestar um item, que chama o método da classe Usuario
     * para adicionar um empréstimo na lista empréstimos do usuário. 
     * @param novoItem
     * @param contaLogada
     */
    public void emprestarItem(Emprestimo novoItem, Usuario contaLogada){
        contaLogada.adicionarEmprestimo(novoItem);
    }

    /**
     * Método para devolver itens, calculando multas por atraso se necessário.
     * Quando um item é devolvido, registra-se a data da devolução real 
     * para, a partir dela, calcular a multa por atraso na devolução.
     * @param item 
     * @param contaLogada 
     */
    public void devolverItem(Item item, Usuario contaLogada){
        //quando um item é devolvido, a data de devolução real é atualizada
        this.dataDevolucaoReal = LocalDate.now();
        double multa = calcularMulta(dataDevolucaoPrevista, dataDevolucaoReal, contaLogada);
        if(multa > 0){
            System.out.println("Multa: R$" + multa);
        }else{
            System.out.println("Devolução dentro do prazo.");
        }
    }
    
    /**
     * Acessa o item emprestado.
     * @return retorna o item emprestado
     */
    public Item getItem() {
        return item;
    }

    /**
     * Modifica o item emprestado.
     * @param item 
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * Método para calcular a data de devolução prevista, 
     * considerando 5 dias úteis a partir da data de empréstimo.
     * @param dataEmprestimo LocalDate - data do empréstimo
     * @return retorna a data de devolução prevista
     */
    public final LocalDate calcularDataPrevista(LocalDate dataEmprestimo){
        int diasUteis = 0;
        LocalDate dataAtual = dataEmprestimo;
        
        while(diasUteis < 5){
            dataAtual = dataAtual.plus(1, ChronoUnit.DAYS);
            //verifica se o dia é útil (segunda a sexta-feira)
            if (dataAtual.getDayOfWeek() != DayOfWeek.SATURDAY && dataAtual.getDayOfWeek() != DayOfWeek.SUNDAY) {
                diasUteis++;
            }
        }
        return dataAtual;
    }
    
    /**
     * Método para calcular multa por atraso na devolução.
     * Dentro do método, verifica qual o tipo de usuário para 
     * definir o valor da multa por dia de atraso.
     * @param dataDevolucaoPrevista
     * @param dataDevolucaoReal
     * @param contaLogada
     * @return 
     */
    public double calcularMulta(LocalDate dataDevolucaoPrevista, LocalDate dataDevolucaoReal, Usuario contaLogada){
        int diasAtraso = (int) ChronoUnit.DAYS.between(dataDevolucaoPrevista, dataDevolucaoReal);
        if (diasAtraso <= 0) {
            return 0; //se não atrasar, não tem multa
        } else { //se tiver atraso, calcula o valor da multa por dia de atraso
            if(contaLogada instanceof Aluno){
                double multaPorDia = contaLogada.multa();
                return multaPorDia * diasAtraso;
            }
            if(contaLogada instanceof Professor){
                double multaPorDia = contaLogada.multa();
                return multaPorDia * diasAtraso;
            }
            if(contaLogada instanceof AssessorTecnico){
                double multaPorDia = contaLogada.multa();
                return multaPorDia * diasAtraso;
            }
        }
        double multaPorDia = 5.0;
        return multaPorDia * diasAtraso;
    }
}