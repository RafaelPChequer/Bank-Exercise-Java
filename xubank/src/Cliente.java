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

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public abstract void acumularPontos();
}