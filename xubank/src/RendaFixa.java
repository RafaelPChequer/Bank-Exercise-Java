class RendaFixa extends Conta {
    private double rendimentoContratado;

    public RendaFixa(int ID, double saldoInicial, double rendimentoContratado) {
        super(ID, saldoInicial);
        this.rendimentoContratado = rendimentoContratado;
    }

    @Override
    public void aplicarTaxas() {
        saldo += saldo * rendimentoContratado; // Aplica o rendimento contratado
    }
}