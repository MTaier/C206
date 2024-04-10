public class Bruxa extends Monstro{
    Feitico[] feiticos;

    public Bruxa(String nome, int idade, int vida, int energia) {
        super(nome, idade, vida, energia);
        this.feiticos = new Feitico[5];
    }

    public boolean aprenderFeitico(String nome, int poder) {
        for (int i = 0; i < feiticos.length; i++) {
            if (feiticos[i] == null) {
                feiticos[i] = new Feitico(nome, poder);
                return true;
            }
        }
        System.out.println("Não foi possível aprender o feitiço");
        return false;
    }

    public void listarFeiticos(){
        for (Feitico feitico : feiticos)
            if (feitico != null) {
                System.out.println("Nome: " + feitico.getNome() + ", Poder: " + feitico.getPoder());
            }
    }

    public void esquecerFeitico(int posicao){
        for (int i = 0; i < feiticos.length; i++) {
            if (i == posicao){
                feiticos[i] = null;
            }
        }
    }

    public void lancarFeitico(Monstro monstroAlvo, int posicao){
        System.out.println("Feitiço " + feiticos[posicao].getNome() + " lançado");
        monstroAlvo.setVida(monstroAlvo.getVida() - feiticos[posicao].getPoder());
        this.setEnergia(this.getEnergia() - feiticos[posicao].getPoder());
    }
}
