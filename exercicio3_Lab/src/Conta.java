public class Conta {
    private double saldo;
    private double limite;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double valor) {
        this.saldo = valor;
    }

    public double getLimite() {
        return limite;
    }

    public String toString(){
        return "Saldo: " + this.getSaldo() + "\nLimite: " + this.getLimite();
    }

    public Conta(double saldo, double limite) {
        this.saldo = saldo;
        this.limite = limite;
    }
}
