public class Monstro {
    private String nome;
    private int idade;
    private int vida;
    private int energia;

    public Monstro(String nome, int idade, int vida, int energia) {
        this.nome = nome;
        this.idade = idade;
        this.vida = vida;
        this.energia = energia;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public String getNome() {
        return nome;
    }

    public void assustar(Monstro alvo){
        System.out.println(this.getNome() + " assustou " + alvo.getNome());
    }
}
