package br.inatel.Classes;

import java.util.Date;

public class Locacao {
    private static int contador = 1;
    private int id;
    private Cliente cliente;
    private Filme filme;
    private Date dataLocacao;
    private Date dataDevolucao;
    private Pagamento pagamento;
    private boolean devolvido;

    public Locacao(Cliente cliente, Filme filme) {
        this.id = contador++;
        this.cliente = cliente;
        this.filme = filme;
        this.dataLocacao = new Date();
        this.dataDevolucao = null;
        this.pagamento = null;
        this.devolvido = false;
    }

    public int getId() {
        return id;
    }

    public Filme getFilme() {
        return filme;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public double calcularMulta(Date dataDevolucaoReal) {
        long diferenca = dataDevolucaoReal.getTime() - dataLocacao.getTime();
        long diasAtraso = diferenca / (1000 * 60 * 60 * 24);
        if (diasAtraso > 0) {
            return diasAtraso * 2.50; // Exemplo de multa de 2.50 por dia de atraso
        }
        return 0;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
}
