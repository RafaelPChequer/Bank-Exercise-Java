// Subclasses para diferentes tipos de contas
class ContaCorrente extends Conta {
    private static final double TAXA_MENSAL = 20.0;
    private static final double LIMITE = 200.0;

    public ContaCorrente(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void aplicarTaxas() {
        saldo -= TAXA_MENSAL;
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= saldo + LIMITE) {
            saldo -= valor;
            return true; // Saque bem-sucedido
        } else {
            return false; // Saldo insuficiente
        }
    }
}