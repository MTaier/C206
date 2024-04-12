public class Main {
    public static void main(String[] args) {
        Garra garra = new Garra(12);
        Camera camera = new Camera(500);
        BracoArticulado bracoArticulado = new BracoArticulado(20, "Braço Articulado", 6);
        Empilhador empilhador = new Empilhador(20, "Empilhador", 100);

        System.out.println(bracoArticulado.getEnergia());
        System.out.println(empilhador.getEnergia());
        System.out.println("");
        bracoArticulado.trabalhar();
        bracoArticulado.trabalhar();
        empilhador.trabalhar();
        empilhador.trabalhar();
        System.out.println("");
        System.out.println(bracoArticulado.getEnergia());
        System.out.println(empilhador.getEnergia());
        System.out.println("");
        bracoArticulado.trocarEnergia(empilhador);
        System.out.println(empilhador.getEnergia());
        System.out.println(bracoArticulado.getEnergia());
        System.out.println("");
        bracoArticulado.recarregar(7);
        System.out.println(bracoArticulado.getEnergia());
        System.out.println("");

        empilhador.adicionaPacote(25);
        empilhador.adicionaPacote(50);
        empilhador.adicionaPacote(26);
        empilhador.mostraPacotes();
        empilhador.removePacote(1);
        empilhador.mostraPacotes();
    }
}