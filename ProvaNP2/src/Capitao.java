public class Capitao extends Pirata implements Comandar{
    private int numeroDeSeguidores;

    public Capitao(String nome, String comidaFavorita, int poder, int numeroDeSeguidores) {
        super(nome, comidaFavorita, poder);
        this.numeroDeSeguidores = numeroDeSeguidores;
    }

    public int getNumeroDeSeguidores() {
        return numeroDeSeguidores;
    }

    public void setNumeroDeSeguidores(int numeroDeSeguidores) {
        this.numeroDeSeguidores = numeroDeSeguidores;
    }

    public void conquistarNovoSeguidor(Pirata pirata) {
        if (this.getPoder() >= pirata.getPoder()) {
            System.out.println("Pirata " + pirata.getNome() + " recrutado");
            this.setNumeroDeSeguidores(getNumeroDeSeguidores() + 1);
        } else {
            System.out.println("Capitão sem poder suficiente");
        }

//        this.lutar(pirata);
//        if (this.lutar(pirata) == this){
//            System.out.println("Pirata " + pirata.getNome() + " recrutado");
//            this.setNumeroDeSeguidores(getNumeroDeSeguidores() + 1);
//        } else {
//            System.out.println("Capitão sem poder suficiente");
//        }
    }

    @Override
    public void darOrdens() {
        System.out.println("O capitão está ordenando " + this.getNumeroDeSeguidores() + " tripulantes");
    }

    @Override
    public void mudarRota() {
        System.out.println("O capitão está mudando a rota");
    }
}
