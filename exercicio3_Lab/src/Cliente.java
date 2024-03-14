public class Cliente {
    private String nome;
    private String cpf;
    public Conta conta;

    public boolean sacarDinheiro(double valor){
        if (this.conta.getSaldo() >= valor) {
            this.conta.setSaldo(this.conta.getSaldo() - valor);
            System.out.println("Saque realizado!");
            return true;
        } else {
            System.out.println("Saqui inválido!");
            return false;
        }
    }

    public void depositarDinheiro(double valor){
        this.conta.setSaldo(this.conta.getSaldo() + valor);
    }

    public boolean comprarComCredito(double valor){
        if ((this.conta.getSaldo() + this.conta.getLimite()) >= valor) {
            this.conta.setSaldo(this.conta.getSaldo() - valor);
            System.out.println("Compra aprovada!");
            return true;
        } else {
            System.out.println("Compra inválida!");
            return false;
        }
    }

    public boolean transferir(Conta contaParaReceber, double valor){
        if (this.conta.getSaldo() >= valor) {
            contaParaReceber.setSaldo(contaParaReceber.getSaldo() + valor);
            this.conta.setSaldo(this.conta.getSaldo() - valor);
            System.out.println("Tranferência aprovada!");
            return true;
        } else {
            System.out.println("Transferência inválida!");
            return false;
        }
    }

    public String toString(){
        return "Nome: " + this.nome + "\nCPF: " + this.cpf + "\n" + conta.toString();
    }

    public Cliente(String nome, String cpf, double saldo, double limite) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = new Conta(saldo, limite);
    }
}
