public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno(674, 60, 60, 5, "Ze");
        Arma arma = new Arma(2, 8);
        Jogador defensor = new Jogador();
        Jogador atacante = new Jogador(arma, 10, 10);
        Gato gato = new Gato("Preto", 3, 7);
        Rato rato = new Rato(5.63f);

        System.out.println(aluno.toString());
        aluno.calculaMedia();

        System.out.println(atacante.toString());
        atacante.atacar(defensor);

        rato.esconder();
        gato.cacar(rato);
        rato.procurarComida();
        gato.cacar(rato);
    }
}