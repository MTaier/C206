package br.inatel.Classes;

import java.util.Date;

public class Pagamento {
    private static int contador = 1;
    private int id;
    private double valor;
    private Date dataPagamento;
    private String metodoPagamento;

    public Pagamento(double valor, Date dataPagamento, String metodoPagamento) {
        this.id = contador++;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.metodoPagamento = metodoPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void realizarPagamento(double valor) {
        System.out.println("Pagamento de " + valor + " realizado com sucesso!");
    }
}
