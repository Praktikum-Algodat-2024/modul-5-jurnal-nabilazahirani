public class RoadNetwork {
    public int V;
    public int[][] graph;
    public String[] cities = {"Korda", "Witeka", "El Scaro","Lonogo", "Sofia", "Enklang", "Copia", "Lutaros", "Brahe", "Calle Mort", "Akaku"};

    public RoadNetwork(int vertices) {
        this.V = vertices;
        graph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = 0;
            }
        }
    }

    public void addEdge(int u, int v, int weight) {
        if (u >= 0 && u < V && v >= 0 && v < V) {
            graph[u][v] = weight;
            graph[v][u] = weight;
        } else {
            throw new IllegalArgumentException("Vertex index out of bounds");
        }
    }

    public int getWeight(int u, int v) {
        if (u >= 0 && u < V && v >= 0 && v < V) {
            return graph[u][v];
        }
        throw new IllegalArgumentException("Vertex index out of bounds");
    }

    public boolean isConnected(int u, int v) {
        if (u >= 0 && u < V && v >= 0 && v < V) {
            return graph[u][v] > 0;
        }
        return false;
    }

    public String getCityName(int index) {
        if (index >= 0 && index < cities.length) {
            return cities[index];
        }
        throw new IllegalArgumentException("City index out of bounds");
    }
}