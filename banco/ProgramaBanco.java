package banco;

import javax.swing.*;
import java.util.ArrayList;

public class ProgramaBanco {
    public static void main(String[] args) {
        BancoList banco = new BancoList("IBank", "098.876.980/0001-08", new ArrayList<>());
        boolean continuar = true;
        JOptionPane.showMessageDialog(null, "Bem vindo ao Ibank! :D");
        while (continuar) {
            String opcao = JOptionPane.showInputDialog("Escolha uma opção para seguir com a operação:\n" +
                    "1. Abrir Conta\n 2. Sacar\n 3.Transferir\n 4. Depositar\n 5. Pesquisar Saldo\n 6. Sair");
            if (opcao.equals("1")) {
                String cpf = JOptionPane.showInputDialog("Digite seu CPF:");
                String numConta = JOptionPane.showInputDialog("Digite a Conta:");
                String numAgencia = JOptionPane.showInputDialog("Digite a Agência:");
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor inicial de sua conta:"));
                banco.abrirConta(cpf, numConta, numAgencia, valor);


            }
            else if (opcao.equals("2")) {
                String numConta = JOptionPane.showInputDialog("Digite a Conta:");
                String numAgencia = JOptionPane.showInputDialog("Digite a Agência:");
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja sacar de sua conta:"));
                double sacar = banco.sacarDeConta(numConta, numAgencia, valor);
                JOptionPane.showMessageDialog(null, "Valor atual de sua conta é: " + sacar);


            }

            else if (opcao.equals("3")) {
                String numConta = JOptionPane.showInputDialog("Digite a Conta de Origem:");
                String numAgencia = JOptionPane.showInputDialog("Digite a Agência de Origem:");
                String numContaDestino = JOptionPane.showInputDialog("Digite a Conta de Destino:");
                String numAgenciaDestino = JOptionPane.showInputDialog("Digite a Agência de Destino:");
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja transferir da conta de destino:"));
                Conta conta = new Conta();
                banco.transferir(numConta, numAgencia, numContaDestino, numAgenciaDestino, valor);

            }

            else if (opcao.equals("4")) {
                String numConta = JOptionPane.showInputDialog("Digite a Conta que você deseja depositar:");
                String numAgencia = JOptionPane.showInputDialog("Digite a Agência:");
                double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor que deseja depositar na sua conta:"));
                double saldo = banco.depositarEmConta(numConta, numAgencia, valor);

                JOptionPane.showMessageDialog(null, "O Saldo atual da Conta após a operação é: "+ saldo);
            }

            else if (opcao.equals("5")) {
                String numConta = JOptionPane.showInputDialog("Digite a Conta que deseja consultar o saldo:");
                String numAgencia = JOptionPane.showInputDialog("Digite agora a Agência:");
                double saldo = banco.pesquisarSaldoDaConta(numConta, numAgencia);
                JOptionPane.showMessageDialog(null, "O Saldo atual da Conta é de "+ saldo);


            }
            else{
                JOptionPane.showMessageDialog(null, "O IBank agradece sua vinda! Até Mais! :)");
                continuar = false;
            }

        }
    }
}
