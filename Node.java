class Node {
    String nama, parent;
    int jarak;   
    Node next;

    public Node(String nama, int jarak, String parent) {
        this.nama = nama;
        this.jarak = jarak;
        this.parent = parent;
        this.next = null;
    }
}
class Edge {
    String from, to;
    int jarak;
    Edge next;

    public Edge (String from, String to, int jarak) {
        this.from = from;
        this.to = to;
        this.jarak = jarak;
        this.next = null;
    }
}