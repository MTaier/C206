import java.util.ArrayList;

public class Cozinheiro extends Pirata{
    private ArrayList<Receita> livroDeReceitas = new ArrayList<>();

    public ArrayList<Receita> getLivroDeReceitas() {
        return livroDeReceitas;
    }

    public Cozinheiro(String nome, String comidaFavorita, int poder) {
        super(nome, comidaFavorita, poder);
    }

    public String prepararPrato(int index) {
        return "Preparando " + livroDeReceitas.get(index).getNome();
    }

    public void mostrarReceitas() {
        try {
            for (int i = 0; i < livroDeReceitas.size(); i++) {
                System.out.println(livroDeReceitas.get(i).getNome());
            }
        } catch (NullPointerException e) {
            System.out.println("Erro " + e);
        }
    }

    public void criarPrato(String nome, int dificuldade) {
        livroDeReceitas.add(new Receita(nome, dificuldade));
    }
}
