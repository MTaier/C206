//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        Console console = new Console();
        Produto produto = new Produto();

        produto.setNome("Eletrônicos");
        produto.setPreco(4000.00);

        notebook.setProcessador("i9");
        notebook.setMemoria("1TB");
        notebook.setNome("Dell G7");
        notebook.setPreco(5000.00);

        console.setGeracao("5");
        console.setMarca("Sony");
        console.setNome("Playstation");
        console.setPreco(3500.00);

        produto.mostraInfo();
        console.mostraInfo();
        notebook.mostraInfo();
    }
}