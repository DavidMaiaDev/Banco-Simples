package banco;

import javax.swing.*;
import java.util.ArrayList;

public class BancoList {
    private String nome;
    private String cnpj;
    private ArrayList<Conta> contas;

    public BancoList(String nome, String cnpj, ArrayList<Conta> contas) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = contas;
    }

    public double pesquisarSaldoDaConta(String numConta, String numAg) {
        double saldo = 0.0;
        for (Conta c : this.contas) {
            if (c.getNumConta().equals(numConta) && c.getNumAgencia().equals(numAg)) {
                saldo = c.getSaldo();
                break;
            }
        }
        return saldo;
    }


    public void transferir(String numConta, String numAgen, String numContaDestino, String numAgenDestino, double valor) {
        Conta contaOrigem = null;
        Conta contaDestino = null;

        for(Conta c : this.contas) {
            if(c.getNumConta().equals(numConta) && c.getNumAgencia().equals(numAgen)){
                contaOrigem = c;
            }
            else if(c.getNumConta()!=(numConta) && c.getNumAgencia()!=(numAgen)){
                contaDestino = c;
            }
       }
      if(contaOrigem != null && contaDestino != null){
            contaOrigem.debitar(valor);
            contaDestino.creditar(valor);
        }
    }

    public void abrirConta(String cpfTitular, String numConta, String numAgen, double saldoInicial){
        Conta conta = new Conta(cpfTitular, numConta, numAgen, saldoInicial);
        this.contas.add(conta);
        JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
    }

    public double sacarDeConta(String numConta, String numAgen, double valor){
        double novoSaldo = 0.0;
        for(Conta c : this.contas){
            if(c.getNumConta().equals(numConta) &&  c.getNumAgencia().equals(numAgen)){
                novoSaldo = c.debitar(valor);
                break;
            }
        }
        return novoSaldo;

    }
    public double depositarEmConta(String numConta, String numAgen, double valor){
        double addValor = 0.0;
        for(Conta c : this.contas){
            if(c.getNumConta().equals(numConta) && c.getNumAgencia().equals(numAgen)){
                addValor = c.creditar(valor);
                break;
            }
        }
        return addValor;
    }


}

