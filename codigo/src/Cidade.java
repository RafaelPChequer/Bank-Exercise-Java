import java.util.Objects;

public class Cidade {
    private String nome;

    public Cidade(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cidade cidade = (Cidade) obj;
        return nome.equals(cidade.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
