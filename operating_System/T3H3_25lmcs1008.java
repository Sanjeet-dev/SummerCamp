package operating_System;
import java.util.*;
class T3H3_25lmcs1008{
static class Process {
    String pid;
    int bt;
    int priority;
    int remainingBT;
    int ct, wt, tat;

    Process(String pid, int bt, int priority) {
        this.pid = pid;
        this.bt = bt;
        this.priority = priority;
        this.remainingBT = bt;
    }
}

static class SchedulingSimulation {

    static void roundRobin(Process[] processes, int tq) {

        Queue<Process> queue = new LinkedList<>();

        for (Process p : processes)
            queue.add(p);

        int time = 0;

        System.out.println("\n[Gantt Chart - Round Robin Execution]");

        while (!queue.isEmpty()) {

            Process p = queue.poll();

            int start = time;

            if (p.remainingBT > tq) {

                time += tq;
                p.remainingBT -= tq;

                System.out.print("| " + p.pid + " (" + start + "-" + time + ") ");

                queue.add(p);

            } else {

                time += p.remainingBT;

                System.out.print("| " + p.pid + " (" + start + "-" + time + ") ");

                p.remainingBT = 0;
                p.ct = time;
            }
        }

        System.out.println("|");

        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("\n--- Round Robin (TQ = 3 ms) ---");

        System.out.printf("%-5s %-8s %-10s %-12s %-10s %-12s\n",
                "PID", "Burst", "Priority",
                "Completion", "Waiting", "Turnaround");

        for (Process p : processes) {

            p.tat = p.ct;
            p.wt = p.tat - p.bt;

            totalWT += p.wt;
            totalTAT += p.tat;

            System.out.printf("%-5s %-8d %-10d %-12d %-10d %-12d\n",
                    p.pid, p.bt, p.priority,
                    p.ct, p.wt, p.tat);
        }

        System.out.printf("\nAverage Waiting Time : %.2f ms\n",
                totalWT / processes.length);

        System.out.printf("Average Turnaround Time : %.2f ms\n",
                totalTAT / processes.length);
    }

    static void priorityScheduling(Process[] processes) {

        Arrays.sort(processes,
                Comparator.comparingInt(a -> a.priority));

        int time = 0;

        System.out.println("\n[Gantt Chart - Priority Scheduling Execution]");

        for (Process p : processes) {

            int start = time;
            time += p.bt;

            p.ct = time;

            System.out.print("| " + p.pid +
                    " (" + start + "-" + time + ") ");
        }

        System.out.println("|");

        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("\n--- Non-Preemptive Priority Scheduling ---");

        System.out.printf("%-5s %-8s %-10s %-12s %-10s %-12s\n",
                "PID", "Burst", "Priority",
                "Completion", "Waiting", "Turnaround");

        for (Process p : processes) {

            p.tat = p.ct;
            p.wt = p.tat - p.bt;

            totalWT += p.wt;
            totalTAT += p.tat;

            System.out.printf("%-5s %-8d %-10d %-12d %-10d %-12d\n",
                    p.pid, p.bt, p.priority,
                    p.ct, p.wt, p.tat);
        }

        System.out.printf("\nAverage Waiting Time : %.2f ms\n",
                totalWT / processes.length);

        System.out.printf("Average Turnaround Time : %.2f ms\n",
                totalTAT / processes.length);
    }

    public static void main(String[] args) {

        Process[] rr = {
                new Process("P1", 5, 3),
                new Process("P2", 3, 1),
                new Process("P3", 2, 2)
        };

        Process[] priority = {
                new Process("P1", 5, 3),
                new Process("P2", 3, 1),
                new Process("P3", 2, 2)
        };

        System.out.println("=== CPU Scheduling Simulation ===");

        roundRobin(rr, 3);

        priorityScheduling(priority);
    }
}
}