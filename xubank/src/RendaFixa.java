class RendaFixa extends Conta {
    private double rendimentoContratado;

    public RendaFixa(double saldoInicial, double rendimentoContratado) {
        super(saldoInicial);
        this.rendimentoContratado = rendimentoContratado;
    }

    @Override
    public void aplicarTaxas() {
        saldo += saldo * rendimentoContratado; // Aplica o rendimento contratado
    }
}