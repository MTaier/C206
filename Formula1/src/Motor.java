public class Motor {
    private int potencia;
    private boolean turbo;

    public Motor(int potencia, boolean turbo) {
        this.potencia = potencia;
        this.turbo = turbo;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "potencia=" + potencia +
                ", turbo=" + turbo +
                '}';
    }
}
