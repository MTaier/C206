//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println(Calculadora.circunferencia(3.0));
        System.out.println(Calculadora.volumeCilindro(3, 5));
        System.out.println(Calculadora.volumeEsfera(4));

        Arma arma = new Arma();
        arma.setDano(2);
        arma.setCustoDeEnergia(8);

        Jogador defensor = new Jogador();
        defensor.setVida(15);
        Jogador atacante = new Jogador(arma, 10,10);

        atacante.atacar(defensor);

        Cliente cliente1 = new Cliente("Mario", "111.222.333-45", 1000, 1000);
        Cliente cliente2 = new Cliente("José", "999.888.777-65", 1000, 1000);

        System.out.println(cliente1.toString());
        cliente1.transferir(cliente2.conta, 200);
        System.out.println(cliente1.conta.getSaldo());
        System.out.println(cliente2.conta.getSaldo());
    }
}