class ClienteGold extends Cliente {
    public ClienteGold(String nome, String CPF, String senha) {
        super(nome, CPF, senha);
    }

    @Override
    public void acumularPontos() {
        // Lógica para acumular pontos
    }
}