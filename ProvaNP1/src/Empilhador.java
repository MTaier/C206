public class Empilhador extends Robo{
    private Pacote[] pacotes;
    private int pesoMaximo;
    int pesoTotal = 0;

    public Empilhador(int energia, String nome, int pesoMaximo) {
        super(energia, nome);
        this.pacotes = new Pacote[5];
        this.pesoMaximo = pesoMaximo;
    }

    public void adicionaPacote(int peso) {
        for (int i = 0; i < pacotes.length; i++) {
            if (pacotes[i] == null) {
                if (pesoTotal + peso <= pesoMaximo) {
                    pacotes[i] = new Pacote(peso);
                    System.out.println("Pacote adicionado com sucesso");
                    pesoTotal += peso;
                    break;
                } else {
                    System.out.println("Peso máximo alcançado");
                    System.out.println("");
                    break;
                }
            }
        }
    }

    public void removePacote(int posicao) {
        for (int i = 0; i < pacotes.length; i++) {
            if (i == posicao){
                pacotes[i] = null;
            }
        }
    }

    public void mostraPacotes() {
        for (int i = 0; i < pacotes.length; i++) {
            if (pacotes[i] != null) {
                System.out.println(pacotes[i].getPeso());
            }
        }
        System.out.println("");
    }
}
