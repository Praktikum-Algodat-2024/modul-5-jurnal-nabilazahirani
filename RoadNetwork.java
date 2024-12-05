public class RoadNetwork {
    public int V;
    public int[][] graph;
    public String[] cities = {"Korda", "Witeka", "El Scaro","Lonogo", "Sofia", "Enklang", "Copia", "Lutaros", "Brahe", "Calle Mort", "Akaku"};

    public RoadNetwork(int vertices) {
        this.V = vertices;
        graph = new int [V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = 0;
            }
        }
    }


        public void addEdge(int u, int v, int weight) {
            graph[u][v] = weight;
            graph[v][u] = weight;
        }
    }

     