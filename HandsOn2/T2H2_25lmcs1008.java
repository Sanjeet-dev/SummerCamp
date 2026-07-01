package HandsOn2;

class T2H2_25lmcs1008{
    static class Worker extends Thread{
        String workerName;

        public Worker(String workerName){
            this.workerName  = workerName;
        }
        @Override
        public void run(){
            for(int i=0; i<3; i++){
                System.out.println(workerName+" iteration"+i);
            }
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                System.out.println("Thread interrupted");

            }
        }
    }
    public static void main(String[] args){
        Worker worker1 = new Worker("Worker A");
        Worker worker2 = new Worker("Worker B");
        // start the worker threads so the local variables are used
        worker1.start();
        worker2.start();

        // wait for threads to finish
        try{
            worker1.join();
            worker2.join();
        }catch(InterruptedException e){
            System.out.println("Main thread interrupted");
        }
    }
    
}