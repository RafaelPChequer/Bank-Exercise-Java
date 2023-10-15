// Subclasses de diferentes tipos de clientes
class ClienteRegular extends Cliente {
    public ClienteRegular(String nome, String CPF, String senha) {
        super(nome, CPF, senha);
    }

    @Override
    public void acumularPontos() {
        // Não acumula pontos
    }
}