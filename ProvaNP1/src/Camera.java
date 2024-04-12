public class Camera {
    private int qualidade;

    public Camera(int qualidade) {
        this.qualidade = qualidade;
    }

    public int acharPecas() {
        int numeroRandomico = (int) ((Math.random() * 9) + 1);
        return numeroRandomico;
    }
}
