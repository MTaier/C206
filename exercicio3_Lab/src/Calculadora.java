public class Calculadora {
    private static float PI = 3.14159f;

    public static double circunferencia(Double raio){
        return 2*PI*raio;
    }

    public static double volumeEsfera(double raio){
        return (4*PI*Math.pow(raio, 3))/3;
    }

    public static double volumeCilindro(double raio, double altura){
        return PI*Math.pow(raio, 2)*altura;
    }
}
