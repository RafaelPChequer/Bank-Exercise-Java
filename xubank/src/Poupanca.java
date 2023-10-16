class Poupanca extends Conta {
    private static final double RENDIMENTO = 0.005; // 0.5%

    public Poupanca(int ID, double saldoInicial) {
        super(ID, saldoInicial);
    }

    @Override
    public void aplicarTaxas() {
        saldo += saldo * RENDIMENTO; // Aplica o rendimento mensal
    }
}