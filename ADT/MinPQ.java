public class MinPQ<Key extends Comparable<Key>>
{
	private  int N;
	private  Key[] pq;
	public MinPQ(int capacity)
	{
		pq=(Key[])new Comparable[capacity];
                N=0;
	}
	public MinPQ()
	{
		pq=(Key[])new Comparable[1];
	}
	public void insert(Key k)
	{
                System.out.println(pq.length);
		int capacity=pq.length;
                
		if(N>=capacity-1)
			resize(2*capacity);
		pq[++N]=k;
		swim(N);
	}
	public Key deleteMin()
	{
                assert(N>0);
		int capacity=pq.length;
		if(N==capacity/4)
			resize(capacity/4);
		Key max=pq[1];
		exch(1,N--);
		sink(1);
		pq[N+1]=null;
		return max;
	}
        public int size(){
            return N;
        }
        public Key min() {
            assert(!isEmpty());
            return pq[1];
         }
        public boolean isEmpty()
	{
		return N==0;
	}
        private boolean isMinHeap(int k) {
            if (k > N) return true;
            int left = 2*k, right = 2*k + 1;
            if (left  <= N && greater(k, left))  return false;
            if (right <= N && greater(k, right)) return false;
            return isMinHeap(left) && isMinHeap(right);
         }
	private void resize(int capacity)
	{
                assert(capacity>N);
		Key[] x=(Key[])new Comparable[capacity];
                for(int i=1;i<=N;i++)
                    x[i]=pq[i];
		pq=x;
	}
	private void swim(int k)
	{
		while(k>1 && greater(k/2,k))
		{
			exch(k,k/2);
			k=k/2;
		}
	}
	private void sink(int k)
	{
		while(2*k<=N)
		{
			int j=2*k;
			if(greater(j,j+1))
				j++;
			if(!greater(k,j))
                            break;
			exch(k,j);
			k=j;
		}
	}
	private boolean greater(int i,int j)
	{
		return pq[i].compareTo(pq[j])>0;
	}
	private void exch(int i,int j)
	{
		Key k=pq[i];
		pq[i]=pq[j];
		pq[j]=k;
	}
        public static void main(String[] args) {
            MaxPQ<Integer> obj=new MaxPQ<>();
            for(int i=0;i<1298888888;i++){
                //System.out.println("oops");
             obj.insert(9);
                //System.out.println("oops");
            }
            System.out.println(obj.deleteMax());
   
}
}


		
