import UnionFind.*;
public class KruskalMST {
    private Queue<Edge> mst=new Queue<>();
    public KruskalMST(EdgeWeightedGraph G){
        MinPQ<Edge> pq=new MinPQ<>();
        for(Edge e:G.edges())
            pq.insert(e);
        WeightedQuickUnionUF uf=new WeightedQuickUnionUF((G.V()));
        while(!pq.isEmpty()&&mst.size()<G.V()-1){
            Edge e=pq.deleteMin();
            int v=e.either();
            int w=e.other(v);
            if(!uf.isConnected(v, w)){
                uf.union(v, w);
                mst.enqueue(e);
            }
        }
    }
        public Iterable<Edge> edges(){
            return mst;
        }
}