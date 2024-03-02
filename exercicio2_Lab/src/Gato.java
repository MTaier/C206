public class Gato {
    public String cor;
    public int idade;
    public int velocidade;

    public Gato(String cor, int idade, int velocidade){
        this.cor = cor;
        this.idade = idade;
        this.velocidade = velocidade;
    }

    public void brincar(){
        System.out.println("O gato esta brincando");
    }

    public void cacar(Rato rato){
        if (!rato.escondido && this.velocidade > rato.velocidade){
            System.out.println("Caça bem sucedida!");
        }
        else {
            System.out.println("O rato escapou!");
        }
    }

    public String toString(){
        return "Status do Gato \nCor: " + this.cor + " Idade: " + this.idade + " Velocidade: " + this.velocidade;
    }
}
