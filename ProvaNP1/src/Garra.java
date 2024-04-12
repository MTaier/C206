public class Garra {
    private int pressao;

    public Garra(int pressao) {
        this.pressao = pressao;
    }

    public void agarrarPeca() {
        System.out.println("Agarrando peça padrão");
    }

    public void agarrarPeca(int posicao) {
        System.out.println("Agarrando peça na posição " + posicao);
    }
}
