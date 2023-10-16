class ClienteVip extends Cliente {
    private static final double MENSALIDADE = 30;
    private static final int PONTOS_MENSAL = 35;
    private static final int PONTOS_POR_SALDO = 30;

    public ClienteVip(String nome, String CPF, String senha) {
        super(nome, CPF, senha);
    }

    @Override
    public void acumularPontos() {
        int pontosMensal = PONTOS_MENSAL;
        for (Conta conta : contas) {
            double pontos = conta.getSaldo() / 2000 * PONTOS_POR_SALDO;
        }
    }
}