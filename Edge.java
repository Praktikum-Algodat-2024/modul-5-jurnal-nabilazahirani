class Edge {
    String from, to;
    int jarak;
    Edge next;

    public Edge(String from, String to, int jarak) {
        this.from = from;
        this.to = to;
        this.jarak = jarak;
        this.next = null;
    }
}
