public class Vampiro extends Monstro{
    private int medidorDeSangue;
    private boolean formaDeMorcego;

    public Vampiro(String nome, int idade, int vida, int energia, int medidorDeSangue, boolean formaDeMorcego) {
        super(nome, idade, vida, energia);
        this.medidorDeSangue = medidorDeSangue;
        this.formaDeMorcego = formaDeMorcego;
    }

    public void transformar(){
        if (!formaDeMorcego){
            System.out.println("Transformando em morcego!");
            formaDeMorcego = true;
        } else {
            System.out.println("Transformando em vampiro!");
            formaDeMorcego = false;
        }
    }

    public void recuperarVida(){
        this.setVida(getVida() + medidorDeSangue);
        medidorDeSangue = 0;
    }

    public void atacarComMordida(Monstro monstroAlvo){
        System.out.println("Vampiro usou mordida em " + monstroAlvo.getNome());
        monstroAlvo.setVida(monstroAlvo.getVida() - 7);
    }
}
