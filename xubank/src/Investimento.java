class Investimento extends Conta {
    private static final double TAXA = 0.015; // 1.5%
    private double rendimentoDiario;

    public Investimento(double saldoInicial, double rendimentoDiario) {
        super(saldoInicial);
        this.rendimentoDiario = rendimentoDiario;
    }

    @Override
    public void aplicarTaxas() {
        saldo += saldo * rendimentoDiario - (saldo * TAXA); // Aplica rendimento diário e taxa
    }
}