public class Jogador {
    public Arma arma;
    public int energia;
    public int vida;

    public Jogador(){
        this.vida = 10;;
    }

    public Jogador(Arma arma, int energia, int vida){
        this.arma = arma;
        this.energia = energia;
        this.vida = vida;
    }

    public void atacar(Jogador alvo){
        if (this.energia >= this.arma.custoDeEnergia){
            this.energia -= this.arma.custoDeEnergia;
            alvo.vida -= this.arma.dano;
            System.out.println("Acertou! Vida do alvo: " + alvo.vida);
            System.out.println("Energia restante: " + this.energia);
        }
        else {
            System.out.println("Sem energia suficiente para atacar!");
        }
    }

    public String toString(){
        return "Energia: " + this.energia + "\nVida: " + this.vida + "\nDano: " + this.arma.dano + "\nCusto de Energia: " + this.arma.custoDeEnergia;
    }
}
