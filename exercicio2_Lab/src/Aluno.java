import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Aluno {
    public int matricula;
    public int np1;
    public int np2;
    public int periodo;
    public String nome;

    public Aluno(int matricula, int np1, int np2, int periodo, String nome){
        this.matricula = matricula;
        this.np1 = np1;
        this.np2 = np2;
        this.periodo = periodo;
        this.nome = nome;
    }

    public int calculaMedia(){
        int media = (np1 + np2)/2;

        if (media >= 60){
            System.out.println("Aprovado");
            System.out.println("Media do aluno: " + media);
        }
        else if (media >= 30){
            System.out.println("Fazer NP3");
            System.out.println("Media do aluno: " + media);
            calculaNP3(media);
        }
        else {
            System.out.println("Reprovado");
            System.out.println("Media do aluno: " + media);
        }

        return media;
    }

    public int calculaNP3(int media){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Entre com a nota da NP3: ");
        int np3 = entrada.nextInt();

        int novaMedia = (media + np3) / 2;

        if (novaMedia >= 50){
            System.out.println("Aprovado!");
            System.out.println("Media do aluno: " + novaMedia);
        }
        else {
            System.out.println("Reprovado!");
            System.out.println("Media do aluno: " + novaMedia);
        }
        entrada.close();

        return novaMedia;
    }

    public String toString(){
        return "Matricula: " + this.matricula + " NP1: " + this.np1 + " NP2: " + this.np2 + " Periodo: " + this.periodo + " Nome: " + this.nome;
    }
}
