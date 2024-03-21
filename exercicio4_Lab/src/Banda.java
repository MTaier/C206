import java.util.Objects;

public class Banda {
    private Musica[] musicas;
    private String nome;
    private int numeroDeIntegrantes;

    public Banda(String nome, int numeroDeIntegrantes) {
        this.musicas = new Musica[10];
        this.nome = nome;
        this.numeroDeIntegrantes = numeroDeIntegrantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDeIntegrantes() {
        return numeroDeIntegrantes;
    }

    public void setNumeroDeIntegrantes(int numeroDeIntegrantes) {
        this.numeroDeIntegrantes = numeroDeIntegrantes;
    }

    public void tocarMusica(int posicao){
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null){
                if (i == posicao){
                    System.out.println("Tocando musica: " + musicas[i].getNome());
                }
            }
        }
    }

    public void tocarShow(){
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null){
                System.out.println("Tocando " + musicas[i].getNome());
            }
        }
    }

    public boolean adicionarMusica(Musica musica){
        for (int i = 0; i < musicas.length; i++) {
            if(musicas[i] == null){
                musicas[i] = musica;
                return true;
            }
        }
        System.out.println("Album Cheio");
        return false;
    }

    public boolean deletarMusica(String nome){
        for (int i = 0; i < musicas.length; i++) {
            if (musicas[i] != null){
                if (Objects.equals(musicas[i].getNome(), nome)) {
                    musicas[i] = null;
                    return true;
                }
            }
        }
        return false;
    }
}
