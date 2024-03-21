public class Saga {
    private int nota;
    private Livro[] livros;

    public Saga(int nota) {
        this.nota = nota;
        this.livros = new Livro[10];
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void listarLivros(){
        for (Livro livro : livros) {
            if (livro != null) {
                System.out.println(livro.getTitulo());
                System.out.println(livro.getPaginas());
            }
        }
    }

    public void adicionarLivro(Livro livro){
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null){
                livros[i] = livro;
                break;
            }
        }
    }
}
