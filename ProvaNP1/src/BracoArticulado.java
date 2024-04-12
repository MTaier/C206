public class BracoArticulado extends Robo{
    private int numeroDeArticulacoes;
    private Garra garra;
    private Camera camera = new Camera(500);

    public BracoArticulado(int energia, String nome, int numeroDeArticulacoes) {
        super(energia, nome);
        this.garra = new Garra(12);
        this.numeroDeArticulacoes = numeroDeArticulacoes;
    }

    @Override
    public void trabalhar() {
        super.trabalhar();
        garra.agarrarPeca(camera.acharPecas());
        garra.agarrarPeca();
    }
}
