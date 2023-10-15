class Poupanca extends Conta {
    private static final double RENDIMENTO = 0.005; // 0.5%

    public Poupanca(double saldoInicial) {
        super(saldoInicial);
    }

    @Override
    public void aplicarTaxas() {
        saldo += saldo * RENDIMENTO; // Aplica o rendimento mensal
    }
}