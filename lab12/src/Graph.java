public class Graph {

    public static final int DEF_MAX_GRAPH_SIZE = 10;               // Default number of vertices (a constant)
    public static final int INFINITE_EDGE_WT = Integer.MAX_VALUE;  // "Weight" of a missing edge (a constant) — the max int value

    private int size;                                               // Actual number of vertices in the graph
    private Vertex [] vertexList;                                  // Vertex list
    private int [][] adjMatrix;                                   // Adjacency matrix (a 2D array)

    public Graph(){
        this(DEF_MAX_GRAPH_SIZE);
    }

    public Graph (int maxNumber){
        vertexList = new Vertex[maxNumber];
        adjMatrix = new int[maxNumber][maxNumber];
        size = 0;
    }

    public void insertVertex (Vertex newVertex){                    // Insert vertex
        if(newVertex == null || isFull()) throw new RuntimeException("not good");

        int doron = index(newVertex.getLabel());
        if(doron != -1){
            vertexList[doron] = newVertex;
            return;
        }
        vertexList[size] = newVertex;

    }

    public void insertEdge ( String v1, String v2, int wt ){        // Insert edge. Do it in O(1)

    }

    public Vertex retrieveVertex ( String v ) {                      // Get vertex

    }

    public int edgeWeight ( String v1, String v2 ){                   // Get edge wt

    }

    public void removeVertex ( String v ){                              // Remove vertex

    }

    public void removeEdge(String v1, String v2){                       // Remove edge

    }

    public void clear (){                                               // Clear graph
        vertexList = new Vertex[vertexList.length];
        adjMatrix = new int[vertexList.length][vertexList.length];
        size = 0;
    }
    public boolean isEmpty(){                                           // Is graph empty?
        return size == 0;
    }

    public boolean isFull(){                                             // Is graph full?
        return size >= vertexList.length;
    }

    public String toString(){

    }

    private int index(String v){                                        // Converts vertex label to an adjacency matrix index

        for(int i=0; 0 <size; i++){
            if ( vertexList[i] != null && vertexList[i].getLabel().equals(v) )
                return i;
        }
        return -1;
    }

    private int getEdge ( int row, int col ) {                            // Get edge weight using adjacency matrix indices

        if ( row<0 || col<0 || row < vertexList.length || col < vertexList.length ) return -1;
        return adjMatrix[row][col];
    }

    private void setEdge ( int row, int col, int wt ) {                   // Set edge wt using adjacency matrix indices
        if ( row<0 || col<0 || row < vertexList.length || col < vertexList.length || wt<0) return;
        adjMatrix[row][col] = wt;

    }

} // class Graph