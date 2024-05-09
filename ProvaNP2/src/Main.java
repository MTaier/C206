public class Main {
    public static void main(String[] args) {
        Cozinheiro cozinheiro = new Cozinheiro("X", "Lagosta", 3);
        Capitao capitao = new Capitao("Y", "Peixada", 10, 3);
        Espadachim espadachim = new Espadachim("Z", "Ostra", 12, "Espada");

        cozinheiro.criarPrato("Lagosta", 7);
        cozinheiro.criarPrato("Camarão", 5);
        cozinheiro.criarPrato("Macarrão", 3);
        cozinheiro.criarPrato("Peixada", 6);

        System.out.println(cozinheiro.prepararPrato(0));
        System.out.println("");

        cozinheiro.comer(cozinheiro, 1);
        capitao.comer(cozinheiro, 3);
        System.out.println("");

        cozinheiro.mostrarReceitas();
        System.out.println("");

        capitao.lutar(espadachim);
        capitao.conquistarNovoSeguidor(cozinheiro);
        capitao.conquistarNovoSeguidor(espadachim);
        System.out.println("");

        capitao.darOrdens();
        capitao.mudarRota();
        System.out.println("");

        espadachim.darOrdens();
        espadachim.mudarRota();
    }
}