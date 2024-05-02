import java.util.Arrays;

public class Equipe {
    private Carro carro;
    private Piloto[] pilotos = new Piloto[4];
    private Piloto pilotoAtual;
    private String nome;

    public Equipe(String nome) {
        this.nome = nome;
    }

    public Carro getCarro() {
        return carro;
    }

    private boolean trocarPilotoAtual(int pilotoID) {
        if (pilotoID >= 0 && pilotoID < pilotos.length && pilotos[pilotoID] != null) {
            pilotoAtual = pilotos[pilotoID];
            return true;
        }
        return false;
    }

    private boolean trocarPneu(int tipoDePneu) {
        if (tipoDePneu >= 1 && tipoDePneu <= 5) {
            carro.setTipoDePneu(tipoDePneu);
            return true;
        }
        return false;
    }

    public void pitStop(int tipoDePneu, int pilotoID) {
        boolean trocaPiloto = trocarPilotoAtual(pilotoID);
        boolean trocaPneu = trocarPneu(tipoDePneu);

        if (trocaPiloto && trocaPneu) {
            System.out.println("Pit stop realizado com sucesso!");
            System.out.println("O piloto " + pilotos[pilotoID].getNome() + " assumiu a direção!");
        } else {
            System.out.println("Falha ao realizar pit stop. Verifique os dados do piloto e o tipo de pneu.");
        }
    }

    public boolean adicionarPiloto(Piloto piloto) {
        for (int i = 0; i < pilotos.length; i++) {
            if (pilotos[i] == null) {
                pilotos[i] = piloto;
                piloto.setId(i);
                return true;
            }
        }
        return false;
    }

    public boolean retirarPiloto(int pilotoID) {
        for (int i = 0; i < pilotos.length; i++) {
            if (pilotos[i] != null && pilotos[i].getId() == pilotoID) {
                pilotos[i] = null;
                return true;
            }
        }
        return false;
    }

    public void mostrarPilotos() {
        for (Piloto piloto : pilotos) {
            if (piloto != null) {
                System.out.println(piloto.getNome());
                System.out.println(piloto.getIdade());
                System.out.println(piloto.getNacionalidade());
                System.out.println("");
            }
        }
    }

    public void constroiCarro(int tipoDePneu, int potencia, boolean turbo) {
        this.carro = new Carro(tipoDePneu, potencia, turbo);
        System.out.println("Carro construído com sucesso!");
    }

    @Override
    public String toString() {
        return "Equipe " + this.nome;
    }
}
