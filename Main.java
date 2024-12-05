public class Main {
        private static final EdgeList edges1;
        private static final EdgeList edges2;
        private static final EdgeList edges3;

        static {
            edges1 = new EdgeList();
            edges1.add("Theta", "Kappa", 3);
            edges1.add("Theta", "Iota", 4);
            edges1.add("Theta", "Mu", 4);
            edges1.add("Theta", "Epsilon", 5);
            edges1.add("Theta", "Delta", 7);
            edges1.add("Delta", "Eta", 2);
            edges1.add("Delta", "Beta", 3);
            edges1.add("Kappa", "Nu", 7);
            edges1.add("Mu", "Lambda", 8);
            edges1.add("Mu", "Omnicron", 8);
            edges1.add("Epsilon", "Zeta", 8);
            edges1.add("Mu", "Xi", 10);
            edges1.add("Delta", "Alpha", 9);
            edges1.add("Delta", "Gamma", 17);
            edges1.add("Nu", "Omega", 9);
            edges1.add("Beta", "Gamma", 7);
            edges1.add("Xi", "Sigma", 5);

            edges2 = new EdgeList();
            edges2.add("Alpha", "Beta", 8);
            edges2.add("Alpha", "Delta", 9);
            edges2.add("Alpha", "Eta", 10);
            edges2.add("Delta", "Epsilon", 4);
            edges2.add("Beta", "Gamma", 7);
            edges2.add("Delta", "Theta", 7);
            edges2.add("Eta", "Lambda", 9);
            edges2.add("Theta", "Kappa", 3);
            edges2.add("Theta", "Iota", 4);
            edges2.add("Theta", "Mu", 4);
            edges2.add("Epsilon", "Zeta", 9);
            edges2.add("Kappa", "Nu", 7);
            edges2.add("Lambda", "Xi", 7);
            edges2.add("Mu", "Omnicron", 8);
            edges2.add("Xi", "Sigma", 5);
            edges2.add("Nu", "Omega", 9);

            edges3 = new EdgeList();
            edges3.add("Mu", "Theta", 4);
            edges3.add("Theta", "Kappa", 3);
            edges3.add("Theta", "Iota", 4);
            edges3.add("Mu", "Lambda", 8);
            edges3.add("Mu", "Omnicron", 8);
            edges3.add("Theta", "Epsilon", 5);
            edges3.add("Mu", "Xi", 10);
            edges3.add("Theta", "Delta", 7);
            edges3.add("Beta", "Gamma", 7);
            edges3.add("Omnicron", "Nu", 3);
            edges3.add("Delta", "Eta", 2);
            edges3.add("Delta", "Beta", 3);
            edges3.add("Xi", "Sigma", 5);
            edges3.add("Epsilon", "Zeta", 9);
            edges3.add("Omnicron", "Omega", 10);
            edges3.add("Alpha", "Delta", 9);
        }

        public static void main(String[] args) {
            ShortestPathFinder.findShortestPaths("Theta", edges1);
            System.out.println();
            ShortestPathFinder.findShortestPaths("Alpha", edges2);
            System.out.println();
            ShortestPathFinder.findShortestPaths("Mu", edges3);
        }
}