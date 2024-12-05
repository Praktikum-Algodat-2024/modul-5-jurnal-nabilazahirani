class EdgeList {
    Edge head;
    public void add(String from, String to, int jarak) {
        Edge newEdge = new Edge(from, to, jarak);
        if (head == null) {
            head = newEdge;
        } else {
            Edge temp = head;
            while (temp.next != null) {temp = temp.next;}
            temp.next = newEdge;
        }
    }

    public LinkedList getNeighbors(String nama) {
        LinkedList neighbors = new LinkedList();
        Edge temp = head;
        while (temp != null) {
            if (temp.from.equals(nama)) {neighbors.add(temp.to, temp.jarak, nama);} 
            else if (temp.to.equals(nama)) {neighbors.add(temp.from, temp.jarak, nama);}
            temp = temp.next;
        }
        return neighbors;
    }

    public int getDistance(String from, String to) {
        Edge temp = head;
        while (temp != null) {
            if ((temp.from.equals(from) && temp.to.equals(to)) || (temp.from.equals(to) && temp.to.equals(from))) {
                return temp.jarak; 
            }
            temp = temp.next;
        }
        return Integer.MAX_VALUE; 
    }
}

