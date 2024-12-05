class LinkedList {
    Node head;

    public void add(String nama, int jarak, String parent) {
        Node newNode = new Node(nama, jarak, parent);
        if (head == null) {head = newNode;}
        else {
            Node temp = head;
            while (temp.next != null) {temp = temp.next;}
            temp.next = newNode;
        }
    }

    public boolean contains(String nama) {
        Node temp = head;
        while (temp != null) {
            if (temp.nama.equals(nama)) {return true;}
            temp = temp.next;
        }
        return false;
    }

    public void remove (String nama) {
        if (head != null && head.nama.equals(nama)) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp != null && temp.next != null) {
            if (temp.next.nama.equals(nama)) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    public Node getMinDistanceNode() {
        Node minNode = head;
        Node temp = head;
        while (temp != null) {
            if (temp.jarak < minNode.jarak) {minNode = temp;}
            temp = temp.next;
        }
        return minNode;
    }

    public void updateDistance(String nama, int newDistance, String parent) {
        Node temp = head;
        while (temp != null) {
            if (temp.nama.equals(nama)) {
                temp.jarak = newDistance;
                temp.parent = parent;  
                return;
            }
            temp = temp.next;
        }
    }

    public void clear() {head = null;}
    
    public void sortByDistance() {
        if (head == null || head.next == null) {
            return;
        }
    
        boolean swapped;
        do {
            swapped = false;
            Node current = head;
            while (current.next != null) {
                if (current.jarak > current.next.jarak || 
                    (current.jarak == current.next.jarak && current.nama.compareTo(current.next.nama) > 0)) {
                    String tempNama = current.nama;
                    int tempJarak = current.jarak;
                    String tempParent = current.parent;
    
                    current.nama = current.next.nama;
                    current.jarak = current.next.jarak;
                    current.parent = current.next.parent;
    
                    current.next.nama = tempNama;
                    current.next.jarak = tempJarak;
                    current.next.parent = tempParent;
    
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);
    }    

    @Override
    public String toString() {
        Node temp = head;
        StringBuilder result = new StringBuilder();
        while (temp != null) {
            result.append(temp.nama).append(" (").append(temp.jarak).append(")");
            if (temp.next != null) result.append(" => ");
            temp = temp.next;
        }return result.toString();
    }

    public void addWithPriority(String nama, int jarak, String parent) {
        Node newNode = new Node(nama, jarak, parent);
        if (head == null || head.jarak > jarak || (head.jarak == jarak && head.nama.compareTo(nama) > 0)) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null && 
                   (temp.next.jarak < jarak || (temp.next.jarak == jarak && temp.next.nama.compareTo(nama) <= 0))) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }    
}

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