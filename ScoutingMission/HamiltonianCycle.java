/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DSAssignment2022;


import java.util.Scanner;



import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class HamiltonianCycle {
    
    private int numOfVertices;
    private int startPoint;
    private int[] hamiltonianPath;
    private int[][] adjacencyMatrix;
    private int persistStartPoint;
    
    public HamiltonianCycle(int[][] adjacencyMatrix, int startPoint){
        this.adjacencyMatrix = adjacencyMatrix;
        this.hamiltonianPath = new int[adjacencyMatrix.length];
        this.numOfVertices = adjacencyMatrix.length;
        
        this.persistStartPoint = startPoint;
        this.startPoint = this.hamiltonianPath[startPoint]; //setting index 0 to be the choosen starting point
     
    }
    
    public void solve(){
           
        if(findFeasibleSolution(1)){
            showHamiltonianPath();
        } else{
            System.out.println("No path found!");
        }
        
    }

    private boolean findFeasibleSolution(int position) {
        if(position == numOfVertices){
            if(adjacencyMatrix[hamiltonianPath[position-1]][hamiltonianPath[startPoint]] == 1){
               return true;  
            } else{
                return false;
            }
        }
        
        for(int vertexIndex = 1; vertexIndex<numOfVertices; vertexIndex++){
            if(isFeasible(vertexIndex,position)){
                hamiltonianPath[position] = vertexIndex;
            
            if(findFeasibleSolution(position+1)){
                return true;
            }
            //Backtrack!!
            }
           
        }
        return false;
    }

    //not feasible means it is not connected
    private boolean isFeasible(int vertexIndex, int actualPosition) {
        //first criteria: whether two nodes are connected?
        if( adjacencyMatrix[hamiltonianPath[actualPosition-1]][vertexIndex] == 0 ){
            return false; //meaning they are not connected
        }
        
        //second criteria: whether we have visited it or not
        for(int i=0; i<actualPosition; i++){
            if(hamiltonianPath[i] == vertexIndex)
                return false;
        }
        return true;
    }
    
    private void showHamiltonianPath() {
        System.out.println("Path found!");

        int[] normalizedPath = new int[hamiltonianPath.length];
        int startPointIndex = findIndex(hamiltonianPath, this.persistStartPoint); 
        int rightShifts = hamiltonianPath.length - startPointIndex;

        System.arraycopy(hamiltonianPath, startPointIndex, normalizedPath, 0, rightShifts);
        System.arraycopy(hamiltonianPath, 0, normalizedPath, rightShifts, startPointIndex);
        
        for(int i=0; i< normalizedPath.length; i++)
            System.out.print(normalizedPath[i]+ " --> ");
        
        System.out.print(normalizedPath[0]);
           
    }
    
    public static int findIndex(int hamiltonianPath[], int index)
    {
  
        // if array is Null
        if (hamiltonianPath == null) {
            return -1;
        }
  
        // find length of array
        int length = hamiltonianPath.length;
        int i = 0;
  
        // traverse in the array
        while (i < length) {
  
            // if the i-th element is t
            // then return the index
            if (hamiltonianPath[i] == index) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }
    
    
    public static void main(String[] args) {
                        //0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13,14,15
        int[][] matrix ={{0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},// 0
                         {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},// 1
                         {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0},// 2
                         {0, 0, 1, 0, 0, 0, 0, 0, 0, 0 ,1, 0, 0, 0, 0, 0},// 3
                         {0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},// 4
                         {1, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0},// 5
                         {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1},// 6
                         {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},// 7
                         {0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},// 8
                         {0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1},// 9
                         {0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},// 10
                         {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},// 11
                         {0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},// 12
                         {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},// 13
                         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1},// 14
                         {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0},// 15
    };
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter starting point: ");
        int startpoint = sc.nextInt();
        System.out.println();
        
        HamiltonianCycle graph1 = new HamiltonianCycle(matrix,startpoint);
        graph1.solve();
        System.out.println();
    }
}