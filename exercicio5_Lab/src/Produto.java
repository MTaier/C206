public class Produto {
    private double preco;
    private String nome;

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostraInfo() {
        System.out.println("Preço: " + this.preco +
                "\nNome: " + this.nome);
    }
}
