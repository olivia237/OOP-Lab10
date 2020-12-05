    package it.unibo.oop.lab.workers02;
    
    import java.util.ArrayList;
import java.util.List;
    
    public class MultiThreadedSumMatrix {
    private final int n;
    
    
    public MultiThreadedSumMatrix(final int n) {
        this.n = n;
    }
    
    private static class Worker extends Thread {
        private final double[][] matrix;
        private final int startpos;
        private final int nelem;
        private long risultato;

        
        public Worker(final double[][] matrix, final int startpos, final int nelem) {
            super();
            this.matrix=matrix;
            this.startpos=startpos;
            this.nelem=nelem;
        }
    
        public void run() {
            for (int i= startpos; i<matrix.length && i<startpos+nelem; i++) {
                for(final double d : this.matrix[i]) {
           this.risultato +=d;
                }
            }
       }
    
    public double getRisultato() {
    return this.risultato;
    }
 }
    
    public double sum(final double[][] matrix) throws InterruptedException {
        final int size = matrix.length/n * matrix.length%n;
        final List<Worker> workers = new ArrayList<>(n);
        for (int j=0; j<matrix.length; j+=size) {
        workers.add(new Worker(matrix,j,size)) ; 
        
        }
        for(final Thread worker : workers) {
            worker.start();
        }
        double sum = 0;
        for(final  Worker wrkr: workers) {
            wrkr.join();
            sum+=wrkr.getRisultato();
        }
        return sum;
    
    
    }
    }