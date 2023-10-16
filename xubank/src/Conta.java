import java.util.ArrayList;
import java.util.List;

// Classe base para contas bancárias
abstract class Conta {
    protected int ID;
    protected double saldo;
    List<Double> extrato = new ArrayList<>();

    public Conta(int ID, double saldoInicial) {
        this.ID = ID;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getID() {
        return ID;
    }

    public void depositar(double valor) {
        saldo += valor;
        extrato.add(valor);
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            extrato.add(-valor);
            return true; // Saque bem-sucedido
        } else {
            return false; // Saldo insuficiente
        }
    }

    public void exibirExtrato() {
        System.out.println("Extrato da conta (ID: " + ID + "):");
        for (int i = 0; i < extrato.size(); i++) {
            double transacao = extrato.get(i);
            if (transacao >= 0) {
                System.out.println("Depósito: " + transacao);
            } else {
                System.out.println("Saque: " + transacao);
            }
        }
    }

    public abstract void aplicarTaxas();
}
