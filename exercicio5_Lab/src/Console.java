public class Console extends Produto {
    private String geracao;
    private String marca;

    public String getGeracao() {
        return geracao;
    }

    public void setGeracao(String geracao) {
        this.geracao = geracao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void jogar() {
        System.out.println("Em jogo!");
    }

    @Override
    public void mostraInfo() {
        super.mostraInfo();
        System.out.println("Marca: " + this.getMarca() +
                "\nGeração: " + this.getGeracao());
    }
}
