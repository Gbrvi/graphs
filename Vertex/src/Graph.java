import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Graph <T>{

    private HashMap<Vertex<T>, List<Vertex<T>>> adjVertex;

    public Graph()
    {
        adjVertex = new HashMap<>();
    }

    public void addVertex(T data)
    {
        Vertex<T> vertex = new Vertex<>(data);

        adjVertex.putIfAbsent(vertex, new ArrayList<>());
    }

    public void RemoveVertex(T data)
    {
        // Remover todos vertices que contenha essa data antes de apaga-lo

        Vertex<T> vertex = new Vertex<>(data);

        adjVertex.values().forEach(list -> list.remove(vertex));

        adjVertex.remove(vertex);

    }

    public void addEdge(T data1, T data2)
    {
        Vertex<T> v1 = new Vertex<>(data1);
        Vertex<T> v2 = new Vertex<>(data2);

        if(!adjVertex.containsKey(v1))
        {
            throw new IllegalArgumentException("Erro: O vértice '" + data1 + "' não existe no grafo. Crie primeiro com addVertex().");
        }

        if(!adjVertex.containsKey(v2))
        {
            throw new IllegalArgumentException("Erro: O vértice '" + data2 + "' não existe no grafo. Crie primeiro com addVertex().");
        }

        adjVertex.get(v1).add(v2);
        // Criar vertices e adiciona-los apenas se existir o vertice
    }

    public void removeEdge(T origin, T destination)
    {
        // Criar vertex, pegar lista associada a ele e remover

        Vertex<T> v1 = new Vertex<>(origin);
        Vertex<T> v2 = new Vertex<>(destination);

        List<Vertex<T>> list_edge_v1 =  adjVertex.get(v1);

        if(list_edge_v1 != null)
        {
            list_edge_v1.remove(v2);
        }

    }
    public List<Vertex<T>> getAdjVertices(T data) {
        // Pegar todos vertices adjacentes
       return  adjVertex.get(new Vertex<T>(data));
    }

    public void printGraph() {

        adjVertex.forEach((origin, destination) ->
        {
            System.out.println("Vertice " + origin + " está conectado a : " + destination);
        });
    }

    // Adicione este método na sua classe Graph
    public void printGraphviz() {
        System.out.println("digraph G {"); // "digraph" significa Grafo Direcionado

        for (Map.Entry<Vertex<T>, List<Vertex<T>>> entry : adjVertex.entrySet()) {
            Vertex<T> origin = entry.getKey();
            List<Vertex<T>> destinations = entry.getValue();

            // Se o vértice não tiver conexões, imprime ele sozinho para aparecer no desenho
            if (destinations.isEmpty()) {
                System.out.println("  \"" + origin + "\";");
            }

            // Imprime a seta apontando da origem para o destino
            for (Vertex<T> dest : destinations) {
                System.out.println("  \"" + origin + "\" -> \"" + dest + "\";");
            }
        }
        System.out.println("}");
    }
}
