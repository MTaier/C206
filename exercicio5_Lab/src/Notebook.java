public class Notebook extends Produto {
    private String processador;
    private String memoria;

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public String getMemoria() {
        return memoria;
    }

    public void setMemoria(String memoria) {
        this.memoria = memoria;
    }

    public void instalarAplicativo() {
        System.out.println("Instalando...");
    }

    @Override
    public void mostraInfo() {
        super.mostraInfo();
        System.out.println("Processador : " + this.getProcessador() +
                "\nMemoria: " + this.getMemoria());
    }
}
