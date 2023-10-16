import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Set<Cidade> cidades = new HashSet<>();
        Cidade raiz = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("src/teste.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(":");
                Cidade origem = new Cidade(partes[0].trim());

                if (raiz == null) {
                    raiz = origem;  // Define a primeira cidade como raiz.
                }

                cidades.add(origem);

                String[] destinos = partes[1].split(",");
                for (String d : destinos) {
                    String[] cidadeDistancia = d.trim().split(" ");

                    if (cidadeDistancia.length < 2) {
                        System.out.println("Dados de entrada inválidos: " + d);
                        continue;
                    }

                    Cidade destino = new Cidade(cidadeDistancia[0]);
                    cidades.add(destino);

                    // Modificado para pegar os números depois do último espaço.
                    String distanciaStr = cidadeDistancia[cidadeDistancia.length - 1].replaceAll("[^0-9]", "");

                    if (distanciaStr.isEmpty()) {
                        System.out.println("Distância inválida para: " + d);
                        continue;
                    }

                    int distancia = Integer.parseInt(distanciaStr);
                    grafo.adicionarEstrada(new Estrada(origem, destino, distancia));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Realiza a busca em profundidade a partir da primeira cidade do arquivo
        if (raiz != null) {
            Map<Cidade, List<Estrada>> mapaAdjacencias = grafo.getAdjacencias();
            if (mapaAdjacencias.containsKey(raiz)) {
                for (Estrada estrada : mapaAdjacencias.get(raiz)) {
                    // Imprime cidades ligadas à raiz no formato especificado.
                    System.out.println(raiz.getNome().toUpperCase() + "; " + raiz.getNome().toLowerCase() + estrada.getDestino().getNome().toLowerCase() + "; " + estrada.getDestino().getNome().toUpperCase());
                }
            }
            System.out.println("Cidades recomendadas:");
            grafo.buscaEmProfundidade(raiz);
        }

        if (raiz != null) {
            List<Cidade> cicloHamiltoniano = grafo.getCicloHamiltoniano(raiz);
            if (!cicloHamiltoniano.isEmpty()) {
                System.out.println("Ciclo Hamiltoniano:");
                for (Cidade c : cicloHamiltoniano) {
                    System.out.print(c.getNome() + " -> ");
                }
                System.out.println(raiz.getNome()); // termina no vértice raiz
            } else {
                System.out.println("Não há ciclo Hamiltoniano disponível.");
            }
        }
    }
}
