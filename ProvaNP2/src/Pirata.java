public class Pirata{
    private String nome;
    private String comidaFavorita;
    private int poder;

    public Pirata(String nome, String comidaFavorita, int poder) {
        this.nome = nome;
        this.comidaFavorita = comidaFavorita;
        this.poder = poder;
    }

    public String getNome() {
        return nome;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public void comer(Cozinheiro cozinheiro, int index) {
        cozinheiro.prepararPrato(index);
        if(cozinheiro.prepararPrato(index).equals("Preparando " + this.comidaFavorita)) {
            System.out.println("O poder do pirata aumentou em 10");
            setPoder(getPoder() + 10);
        }
        else {
            System.out.println("O poder do pirata aumentou em 5");
            setPoder(getPoder() + 5);
        }
    }

    public Pirata lutar(Pirata pirata) {
        System.out.println("O pirata " + this.getNome() + " está lutando contra o pirata " + pirata.getNome());
        if (this.getPoder() >= pirata.getPoder()) {
            return this;
        }
        else {
            return pirata;
        }
    }
}
