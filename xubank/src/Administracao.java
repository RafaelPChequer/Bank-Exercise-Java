import java.util.ArrayList;
import java.util.List;

public class Administracao {
    private List<Cliente> listaClientes;

    // Construtor
    public Administracao() {
        listaClientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente obterClientePorCPF(String CPF) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCPF().equals(CPF)) {
                return cliente;
            }
        }
        return null; // Se o CPF não for encontrado, retorna null
    }

    public boolean verificarSenha(String CPF, String senha) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCPF().equals(CPF)) {
                if(cliente.getSenha().equals(senha)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void transferencia(String CPF1, String senha, int ID1, String CPF2, int ID2, double valor) {
        if(verificarSenha(CPF1, senha)) {
            Cliente clienteTransferindo = obterClientePorCPF(CPF1);
            Cliente clienteRecebendo = obterClientePorCPF(CPF2);
            Conta contaTransferindo = clienteTransferindo.obterContaPorID(ID1);
            Conta contaRecebendo = clienteRecebendo.obterContaPorID(ID2);
            contaTransferindo.sacar(valor);
            contaRecebendo.depositar(valor);
        }
    }

    public void sacar(String CPF, String senha, int ID, double valor) {
        if(verificarSenha(CPF, senha)) {
            Cliente clienteDeposito = obterClientePorCPF(CPF);
            Conta contaDeposito = clienteDeposito.obterContaPorID(ID);
            contaDeposito.sacar(valor);
        }
    }

    public void depositar(String CPF, String senha, int ID, double valor) {
        if(verificarSenha(CPF, senha)) {
            Cliente clienteSaque = obterClientePorCPF(CPF);
            Conta contaSaque = clienteSaque.obterContaPorID(ID);
            contaSaque.depositar(valor);
        }
    }
}
