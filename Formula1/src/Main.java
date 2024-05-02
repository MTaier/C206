public class Main {
    public static void main(String[] args) {
        Equipe equipe = new Equipe("Red Bull");
        Piloto piloto1 = new Piloto("Verstappen", 26, "Holanda");
        Piloto piloto2 = new Piloto("Perez", 34, "Mexico");
        Piloto piloto3 = new Piloto("Hamilton", 39, "Inglaterra");
        Piloto piloto4 = new Piloto("Norris", 24, "Inglaterra");

        equipe.adicionarPiloto(piloto1);
        equipe.adicionarPiloto(piloto2);
        equipe.adicionarPiloto(piloto3);
        equipe.adicionarPiloto(piloto4);
        equipe.mostrarPilotos();
        equipe.retirarPiloto(3);
        equipe.mostrarPilotos();
        equipe.constroiCarro(4, 1014, true);
        piloto1.correr(equipe.getCarro());
        equipe.pitStop(2,2);
        equipe.pitStop(6,1);
        equipe.pitStop(5,1);
    }
}