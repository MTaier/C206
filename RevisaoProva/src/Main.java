//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Bruxa bruxa = new Bruxa("bruxa",1000, 50, 400);
        Vampiro vampiro = new Vampiro("vampiro",450, 600, 160, 65, false);
        Zumbi zumbi = new Zumbi("zumbi",45, 100, 86, 6);

        bruxa.aprenderFeitico("Avada", 10);
        bruxa.aprenderFeitico("Lumos", 2);
        bruxa.listarFeiticos();
        bruxa.lancarFeitico(vampiro, 1);
        bruxa.esquecerFeitico(1);
        bruxa.listarFeiticos();

        vampiro.transformar();
        vampiro.transformar();
        vampiro.atacarComMordida(zumbi);
        vampiro.recuperarVida();

        zumbi.atacarComMordida(bruxa);
        zumbi.assustar(vampiro);
    }
}