package banco;

public class Conta {
    private String cpfTitular;
    private String numConta;
    private String numAgencia;
    private double saldo;

    public Conta(String cpfTitular, String numConta, String numAgencia, double saldo) {
        this.cpfTitular = cpfTitular;
        this.numConta = numConta;
        this.numAgencia = numAgencia;
        this.saldo = saldo;
    }

    public Conta() {
        this("", "", "", 0.0);
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public String getNumAgencia() {
        return numAgencia;
    }

    public void setNumAgencia(String numAgencia) {
        this.numAgencia = numAgencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public double creditar(double valor){
        if(valor > 0){
            this.saldo += valor;
        }
        return this.saldo;
    }
    public double debitar(double valor) {
        if (saldo > 0) {
            this.saldo -= valor;
        }
        return saldo;
    }
    public String toString(){
        return "Conta número: " + this.numConta + " do cliente de CPF: " + this.cpfTitular;
    }
    void transfere(Conta destino, double valor) {
        this.saldo = this.saldo - valor;
        destino.saldo += valor;
    }
}

