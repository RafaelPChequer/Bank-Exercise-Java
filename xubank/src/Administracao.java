import java.util.List;

public class Administracao {
    private List<Cliente> listaClientes;
    private List<Conta> listaContas;

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
    public void adicionarConta(Conta conta) {
        listaContas.add(conta);
    }
}
