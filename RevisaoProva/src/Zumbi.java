import java.sql.SQLOutput;

public class Zumbi extends Monstro{
    private int numeroDeCerebrosComidos;

    public Zumbi(String nome, int idade, int vida, int energia, int numeroDeCerebrosComidos) {
        super(nome, idade, vida, energia);
        this.numeroDeCerebrosComidos = numeroDeCerebrosComidos;
    }

    public void atacarComMordida(Monstro monstroAlvo){
        System.out.println("Zumbi usou mordida em " + monstroAlvo.getNome());
        monstroAlvo.setVida(monstroAlvo.getVida() - this.numeroDeCerebrosComidos);
        numeroDeCerebrosComidos = 0;
    }
}
