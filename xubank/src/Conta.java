// Classe base para contas bancárias
abstract class Conta {
    protected double saldo;

    public Conta(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true; // Saque bem-sucedido
        } else {
            return false; // Saldo insuficiente
        }
    }

    public abstract void aplicarTaxas();
}
