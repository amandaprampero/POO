package trabalho.biblioteca;

/**
 * Interface Emprestável define os métodos para empréstimo e devoluç̃ao.
 * @author Amanda
 */
public interface Emprestavel {
    /**
     * Método abstrato para devolver itens.
     * @param item Item - item para devolver
     * @param contaLogada Usuario - conta logada
     */
    public abstract void devolucao(Item item, Usuario contaLogada);

    /**
     * Método abstrato para fazer empréstimo de itens.
     * @param emprestimo Emprestimo - novo empréstimo
     * @param contaLogada Usuario - conta logada
     */
    public abstract void emprestimo(Emprestimo emprestimo, Usuario contaLogada);
}