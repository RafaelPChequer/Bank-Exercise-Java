import java.util.*;

public class Grafo {
    private Map<Cidade, List<Estrada>> adjacencias;

    public Grafo() {
        this.adjacencias = new HashMap<>();
    }

    public void adicionarEstrada(Estrada estrada) {
        adjacencias.computeIfAbsent(estrada.getOrigem(), k -> new ArrayList<>()).add(estrada);
        adjacencias.computeIfAbsent(estrada.getDestino(), k -> new ArrayList<>()); // Garante que todas as cidades estejam no grafo.
    }

    public Map<Cidade, List<Estrada>> getAdjacencias() {
        return adjacencias; // Retorna o mapa de adjacências.
    }
    public void buscaEmProfundidade(Cidade raiz) {
        Set<Cidade> visitados = new HashSet<>();
        Stack<Cidade> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            Cidade cidade = pilha.pop();

            if (!visitados.contains(cidade)) {
                visitados.add(cidade);
                System.out.println("Recomendado: " + cidade.getNome());

                for (Estrada estrada : adjacencias.get(cidade)) {
                    pilha.push(estrada.getDestino());
                }
            }
        }

        // Verificar cidades não conectadas
        for (Cidade c : adjacencias.keySet()) {
            if (!visitados.contains(c)) {
                System.out.println("Grafo não conexo(Cidades não conectadas):");
                break;
            }
        }
        for (Cidade c : adjacencias.keySet()) {
            if (!visitados.contains(c)) {
                System.out.println("Cidade não conectada: " + c.getNome());
            }
        }
    }

    // Método para verificar se um vértice pode ser adicionado ao ciclo de Hamilton.
    public boolean podeAdicionar(Cidade cidade, List<Cidade> caminho) {
        // Verifica se a cidade já está no caminho
        if (caminho.contains(cidade)) {
            return false;
        }

        // Verifica se há uma estrada entre a última cidade do caminho e esta cidade
        Cidade ultimaCidade = caminho.get(caminho.size() - 1);
        return adjacencias.get(ultimaCidade).stream().anyMatch(e -> e.getDestino().equals(cidade));
    }

    // Método recursivo para encontrar um ciclo de Hamilton.
    public boolean encontrarCicloHamiltoniano(Cidade cidadeAtual, List<Cidade> caminho, Cidade raiz) {
        if (caminho.size() == adjacencias.size()) {
            // O caminho inclui todas as cidades, verifique se há uma estrada de volta para a raiz.
            return adjacencias.get(cidadeAtual).stream().anyMatch(e -> e.getDestino().equals(raiz));
        }

        for (Estrada estrada : adjacencias.get(cidadeAtual)) {
            if (podeAdicionar(estrada.getDestino(), caminho)) {
                caminho.add(estrada.getDestino());

                // Recursão
                if (encontrarCicloHamiltoniano(estrada.getDestino(), caminho, raiz)) {
                    return true;
                }

                // Se chegar aqui, então não encontramos um ciclo válido; remova a última cidade e tente outra.
                caminho.remove(caminho.size() - 1);
            }
        }

        return false;
    }

    public List<Cidade> getCicloHamiltoniano(Cidade raiz) {
        List<Cidade> caminho = new ArrayList<>();
        caminho.add(raiz);
        if (!encontrarCicloHamiltoniano(raiz, caminho, raiz)) {
            return Collections.emptyList(); // Retorna lista vazia se não houver ciclo.
        }
        return caminho; // Retorna o ciclo encontrado.
    }
}
