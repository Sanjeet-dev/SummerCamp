package operating_System;
class T3H1_25lmcs1008{
static class Process {
    int pid;
    String state;

    Process(int pid) {
        this.pid = pid;
        this.state = "NEW";
    }

    void setState(String state) {
        this.state = state;
        System.out.println("Process P" + pid + " -> " + state);
    }
}



    public static void main(String[] args) {

        Process p1 = new Process(1);
        Process p2 = new Process(2);
        Process p3 = new Process(3);

        System.out.println("=== Process State Simulation ===");

        System.out.println("\nInitial State");
        System.out.println("P1 : " + p1.state);
        System.out.println("P2 : " + p2.state);
        System.out.println("P3 : " + p3.state);

        System.out.println("\nMoving all processes to READY Queue");

        p1.setState("READY");
        p2.setState("READY");
        p3.setState("READY");

        System.out.println("\nCPU selects Process P1");

        p1.setState("RUNNING");

        System.out.println("\nP1 requests I/O");

        p1.setState("WAITING");

        System.out.println("\nI/O completed");

        p1.setState("READY");

        System.out.println("\nCPU schedules P1 again");

        p1.setState("RUNNING");

        System.out.println("\nExecution Finished");

        p1.setState("TERMINATED");
    }
}
