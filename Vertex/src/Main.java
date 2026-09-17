public class Main {
    public static void main(String[] args) {
        // Criando nosso grafo de Strings
        Graph<String> redeSocial = new Graph<>();

        // 1. Criando os vértices (Precisamos criar antes para o addEdge não dar erro!)
        redeSocial.addVertex("Alice");
        redeSocial.addVertex("Bob");
        redeSocial.addVertex("Carlos");
        redeSocial.addVertex("Diana");
        redeSocial.addVertex("Eva");
        redeSocial.addVertex("Felipe");
        redeSocial.addVertex("Gabriel");
        redeSocial.addVertex("Helena"); // Helena não seguirá ninguém e ninguém a seguirá (vértice isolado)

        // 2. Criando as conexões (Arestas Direcionadas: A -> B significa "A segue B")
        redeSocial.addEdge("Alice", "Bob");

        redeSocial.addEdge("Bob", "Carlos");

        redeSocial.addEdge("Bob", "Eva");



        // 3. Gerando o código para desenhar!
        System.out.println("--- Copie o texto abaixo e cole no site Edotor.net ou WebGraphviz ---");
        System.out.println();

        redeSocial.printGraph();

        redeSocial.printGraphviz();
    }
}