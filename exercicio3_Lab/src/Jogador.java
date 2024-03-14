public class Jogador {
    private Arma arma;
    private int energia;
    private int vida;

    public Jogador(){
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public Jogador(Arma arma, int energia, int vida){
        this.arma = arma;
        this.energia = energia;
        this.vida = vida;
    }

    public void atacar(Jogador alvo){
        if (this.energia >= this.arma.getCustoDeEnergia()){
            this.energia -= this.arma.getCustoDeEnergia();
            alvo.vida -= this.arma.getDano();
            System.out.println("Acertou! Vida do alvo: " + alvo.vida);
            System.out.println("Energia restante: " + this.energia);
        }
        else {
            System.out.println("Sem energia suficiente para atacar!");
        }
    }

    public String toString(){
        return "Energia: " + this.energia + "\nVida: " + this.vida + "\nDano: " + this.arma.getDano() + "\nCusto de Energia: " + this.arma.getCustoDeEnergia();
    }
}