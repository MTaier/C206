//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Autor autor = new Autor("J. K. Rowling");
        Saga saga = new Saga(8);
        Livro livro = new Livro("Harry Potter", 500);

        autor.adicionarSaga(saga);
        saga.adicionarLivro(livro);

        autor.listarSagas();

        Banda banda = new Banda("Queen", 4);

        banda.adicionarMusica(new Musica("Bohemian Rapsody", "Live at Wembley '86"));
        banda.adicionarMusica(new Musica("Radio Ga Ga", "Live at Wembley '86"));
        banda.tocarShow();
        banda.tocarMusica(1);

        banda.deletarMusica("Bohemian Rapsody");
        banda.tocarShow();
    }
}