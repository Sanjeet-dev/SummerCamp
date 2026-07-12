package operating_System;
class T3H4_25lmcs1008{
    public class DeadlockSimulation {

    // Shared resources (locks)
    static final Object printerLock = new Object();
    static final Object scannerLock = new Object();

    public static void main(String[] args) {

        System.out.println("=== Deadlock Simulation Engine ===");
        System.out.println("[SYSTEM] Initializing shared non-shareable resources...");
        System.out.println("[SYSTEM] Launching competing execution threads...\n");

        Thread thread1 = new Thread(() -> {

            synchronized (printerLock) {

                System.out.println("=> Thread 1: Successfully locked Printer Lock (Resource A)");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("=> Thread 1: Waiting to acquire Scanner Lock (Resource B)...");

                synchronized (scannerLock) {
                    System.out.println("=> Thread 1 acquired Scanner Lock");
                }
            }

        });

        Thread thread2 = new Thread(() -> {

            synchronized (scannerLock) {

                System.out.println("=> Thread 2: Successfully locked Scanner Lock (Resource B)");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("=> Thread 2: Waiting to acquire Printer Lock (Resource A)...");

                synchronized (printerLock) {
                    System.out.println("=> Thread 2 acquired Printer Lock");
                }
            }

        });

        thread1.start();
        thread2.start();
    }
}
}