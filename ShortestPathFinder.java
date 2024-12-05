class ShortestPathFinder {
    public static void findShortestPaths(String start, EdgeList edges) {
        LinkedList visited = new LinkedList();
        LinkedList unvisited = new LinkedList();
        unvisited.add(start, 0, null);

        while (unvisited.head != null) {
            Node currentNode = unvisited.getMinDistanceNode();
            unvisited.remove(currentNode.nama);
            visited.add(currentNode.nama, currentNode.jarak, currentNode.parent);

            LinkedList neighbors = edges.getNeighbors(currentNode.nama);
            Node temp = neighbors.head;
            while (temp != null) {
                if (!visited.contains(temp.nama)) {
                    int newDistance = currentNode.jarak + edges.getDistance(currentNode.nama, temp.nama);
                    if (!unvisited.contains(temp.nama)) {
                        unvisited.add(temp.nama, newDistance, currentNode.nama);
                    } else {
                        unvisited.updateDistance(temp.nama, newDistance, currentNode.nama);
                    }
                }
                temp = temp.next;
            }
        }
        visited.sortByDistance();
        Node temp = visited.head;
        while (temp != null) {
            printRoute(temp.nama, visited);
            temp = temp.next;
        }
    }

    public static void printRoute(String nama, LinkedList visited) {
        StringBuilder route = new StringBuilder();
        buildRoute(nama, visited, route);
        System.out.println(route);
    }

    public static void buildRoute(String nama, LinkedList visited, StringBuilder route) {
        Node temp = visited.head;
        while (temp != null) {
            if (temp.nama.equals(nama)) {
                if (temp.parent != null) {
                    buildRoute(temp.parent, visited, route);
                    route.append(" => ");
                }
                route.append(temp.nama);
                return;
            }
            temp = temp.next;
        }
    }
}
