class ClienteGold extends Cliente {
    private static final double TAXA_MENSAL = 10;
    private static final int PONTOS_MENSAL = 10;
    private static final int PONTOS_POR_SALDO = 10;

    public ClienteGold(String nome, String CPF, String senha) {
        super(nome, CPF, senha);
    }

    @Override
    public void acumularPontos() {
        int pontos = PONTOS_MENSAL;
        for (Conta conta : contas) {
            pontos += conta.getSaldo() / 1000 * PONTOS_POR_SALDO;
        }
    }
}