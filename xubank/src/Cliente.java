import java.util.*;

abstract class Cliente {
    protected String nome;
    protected String CPF;
    private String senha;
    protected List<Conta> contas;

    public Cliente(String nome, String CPF, String senha) {
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.contas = new ArrayList<>();
    }

    public String getCPF() {
        return CPF;
    }

    public String getSenha() {
        return senha;
    }
    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public abstract void acumularPontos();

    public double obterSaldoPorID(int ID) {
        for (Conta conta : contas) {
            if (conta.getID() == (ID)) {
                return conta.saldo;
            }
        }
        return 0;
    }

    public Conta obterContaPorID(int ID) {
        for (Conta conta : contas) {
            if (conta.getID() == (ID)) {
                return conta;
            }
        }
        return null;
    }
}