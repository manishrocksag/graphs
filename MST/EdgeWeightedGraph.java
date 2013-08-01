public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private final Bag<Edge>[] adj;
    public EdgeWeightedGraph(int V){
        this.V=V;
        adj=(Bag<Edge>[])new Bag[V];
        for(int v=0;v<V;v++)
            adj[v]=new Bag<>();       
    }
    public void addEdge(Edge e){
        E++;
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }
    public int E(){
        return E;
    }
    public int V(){
        return V;
    }
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
     public Iterable<Edge> edges() {
        Bag<Edge> list = new Bag<>();
        for (int v = 0; v < V; v++) {
            int selfLoops = 0;
            for (Edge e : adj(v)) {
                if (e.other(v) > v) {
                    list.add(e);
                }
                // only add one copy of each self loop
                else if (e.other(v) == v) {
                    if (selfLoops % 2 == 0) list.add(e);
                    selfLoops++;
                }
            }
        }
        return list;
    }

    
}
