import java.io.*;
import java.util.*;

class Main  {
    // Coded By
    // Breno
    public static HashMap<Integer, ArrayList<Integer>> adjListOut = new HashMap<Integer, ArrayList<Integer>>();
   
    public static void printAsnwer(BufferedWriter bw, int numTasks, ArrayList<Integer> seqTasks) throws NumberFormatException, IOException {
        if (seqTasks.size() < numTasks) {
            bw.write("Sandro fails.\n");
        }
        else {
            for (int i = 0; i < seqTasks.size()-1; i++) {
                bw.write(seqTasks.get(i) + " ");
            }
            bw.write(seqTasks.get(seqTasks.size()-1) + "\n");
        }
    }
   
    public static void toposort(int numTasks, int[] degrees, ArrayList<Integer> seqTasks) {
        Queue<Integer> zeroDegree = new PriorityQueue<Integer>();
        for (int i = 1; i <= numTasks; i++) {
            if (degrees[i] == 0) {
                zeroDegree.add(i);
            }
        }
       
        while (zeroDegree.size() > 0) {
            int currTask = zeroDegree.poll();
            seqTasks.add(currTask);
            ArrayList<Integer> list = adjListOut.get(currTask);
            for (int i = 0; i < list.size(); i++) {
                degrees[list.get(i)]--;
                if (degrees[list.get(i)] == 0) {
                    zeroDegree.add(list.get(i));
                }
            }
        }
    }
   
    public static void readDependencies(BufferedReader br, int numDependencies, int[] degrees) throws NumberFormatException, IOException {
        for (int i = 0; i < numDependencies; i++) {
            int task1 = reader(br);
            int task2 = reader(br);
            adjListOut.get(task1).add(task2);
            degrees[task2]++;
        }
    }
   
    public static void initAdjList(int numTasks) {
        for (int i = 1; i <= numTasks; i++) {
            adjListOut.put(i, new ArrayList<Integer>());
        }
    }
   
    static int reader(BufferedReader br) throws NumberFormatException, IOException {     
        int n;
        int resp = 0;      
      
        while (true) {         
            n = br.read();         
            if (n >= '0' && n <= '9') {
                break;
            } 
        }
           
        while (true) {         
            resp = resp*10 + n-'0';         
            n = br.read();         
            if (n < '0' || n > '9') {
                break;     
            }
        }
      
        return resp;     
    }
   
    public static void process() throws NumberFormatException, IOException {   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       
        int numTasks = reader(br);
        int numDependencies = reader(br);
       
        initAdjList(numTasks);
       
        int[] degrees = new int[numTasks+1];
        readDependencies(br, numDependencies, degrees);
       
        ArrayList<Integer> seqTasks = new ArrayList<Integer>();
        toposort(numTasks, degrees, seqTasks);
       
        printAsnwer(bw, numTasks, seqTasks);
       
        bw.flush();
        bw.close();
               
        return;
    }
   
    public static void main(String[] args) throws NumberFormatException, IOException {
        Main m = new Main();
        m.process();

        System.exit(0);
    }
}