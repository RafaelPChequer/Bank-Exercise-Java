public class Estrada {
    private Cidade origem;
    private Cidade destino;
    private int distancia;

    public Estrada(Cidade origem, Cidade destino, int distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Cidade getOrigem() {
        return origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public int getDistancia() {
        return distancia;
    }
}
