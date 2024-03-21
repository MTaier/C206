public class Autor {
    private String nome;
    private Saga[] sagas;

    public Autor(String nome) {
        this.nome = nome;
        this.sagas = new Saga[10];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Saga[] getSagas() {
        return sagas;
    }

    public void setSagas(Saga[] sagas) {
        this.sagas = sagas;
    }

    public void listarSagas(){
        for (Saga saga : sagas) {
            if (saga != null) {
                System.out.println("Autor: " + this.nome);
                System.out.println("Nota da Saga: " + saga.getNota());
                saga.listarLivros();
            }
        }
    }

    public void adicionarSaga(Saga saga){
        for (int i = 0; i < sagas.length; i++) {
            if (sagas[i] == null){
                sagas[i] = saga;
                break;
            }
        }
    }
}
