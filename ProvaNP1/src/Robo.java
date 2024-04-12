public class Robo {
    private int energia;
    private String nome;
    private static int totalDeRobos;
    private int energiaMaxima;

    public Robo(int energia, String nome) {
        this.energia = energia;
        this.nome = nome;
        this.energiaMaxima = 20;
    }

    public void trabalhar() {
        this.energia -= 3;
    }

    public void trocarEnergia(Robo roboAlvo) {
        if (this.energia - 5 >= 0 && roboAlvo.energia + 5 <= 20) {
            this.energia -= 5;
            roboAlvo.energia += 5;
        } else {
            System.out.println("Não foi possível transferir energia");
        }
    }

    public void recarregar(int horas) {
        if (this.energia + horas >= 20) {
            this.energia = energiaMaxima;
        } else {
            this.energia += horas;
        }

    }

    public int getEnergia() {
        return energia;
    }
}
