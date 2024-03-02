public class Rato {
    public float velocidade;
    public boolean escondido;

    public Rato(float velocidade){
        this.velocidade = velocidade;
        this.escondido = false;
    }

    public void esconder(){
        this.escondido = true;
        System.out.println("O rato está escondido");
    }

    public void procurarComida(){
        this.escondido = false;
        System.out.println("O rato saiu do esconderijo");
    }

    public String toString(){
        return "Status do Rato \nVelocidade: " + this.velocidade + " Escondido: " + this.escondido;
    }
}
