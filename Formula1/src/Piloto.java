public class Piloto {
    private String nome;
    private int idade;
    private String nacionalidade;
    private static int idGeral = 0;
    private int id;

    public Piloto(String nome, int idade, String nacionalidade) {
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        idGeral++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void correr(Carro carro) {
        System.out.println("O piloto " + this.nome + " está controlando o carro.");
        carro.correr();
    }

    @Override
    public String toString() {
        return "Piloto{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", id=" + id +
                '}';
    }
}
