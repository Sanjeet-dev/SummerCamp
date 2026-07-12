package operating_System;
import java.util.*;

class Process {
    String pid;
    int at, bt;
    int ct, wt, tat;

    Process(String pid, int at, int bt) {
        this.pid = pid;
        this.at = at;
        this.bt = bt;
    }
}

class T3H2_25lmcs1008 {

    static void fcfs(Process[] p) {

        Arrays.sort(p, Comparator.comparingInt(a -> a.at));

        int time = 0;
        double totalWT = 0, totalTAT = 0;

        System.out.println("\n--- First-Come First-Served (FCFS) ---");

        System.out.printf("%-5s %-8s %-8s %-12s %-10s %-12s\n",
                "PID", "Arrival", "Burst", "Completion", "Waiting", "Turnaround");

        for (Process pr : p) {

            if (time < pr.at)
                time = pr.at;

            time += pr.bt;

            pr.ct = time;
            pr.tat = pr.ct - pr.at;
            pr.wt = pr.tat - pr.bt;

            totalWT += pr.wt;
            totalTAT += pr.tat;

            System.out.printf("%-5s %-8d %-8d %-12d %-10d %-12d\n",
                    pr.pid, pr.at, pr.bt, pr.ct, pr.wt, pr.tat);
        }

        System.out.printf("\nAverage Waiting Time = %.2f ms\n",
                totalWT / p.length);

        System.out.printf("Average Turnaround Time = %.2f ms\n",
                totalTAT / p.length);
    }

    static void sjf(Process[] original) {

        Process[] p = new Process[original.length];

        for (int i = 0; i < original.length; i++)
            p[i] = new Process(original[i].pid, original[i].at, original[i].bt);

        boolean completed[] = new boolean[p.length];

        int completedCount = 0;
        int time = 0;

        double totalWT = 0;
        double totalTAT = 0;

        System.out.println("\n--- Non-Preemptive SJF ---");

        System.out.printf("%-5s %-8s %-8s %-12s %-10s %-12s\n",
                "PID", "Arrival", "Burst", "Completion", "Waiting", "Turnaround");

        while (completedCount < p.length) {

            int idx = -1;
            int minBT = Integer.MAX_VALUE;

            for (int i = 0; i < p.length; i++) {

                if (!completed[i] && p[i].at <= time) {

                    if (p[i].bt < minBT) {
                        minBT = p[i].bt;
                        idx = i;
                    }
                }
            }

            if (idx == -1) {
                time++;
                continue;
            }

            time += p[idx].bt;

            p[idx].ct = time;
            p[idx].tat = p[idx].ct - p[idx].at;
            p[idx].wt = p[idx].tat - p[idx].bt;

            completed[idx] = true;
            completedCount++;

            totalWT += p[idx].wt;
            totalTAT += p[idx].tat;

            System.out.printf("%-5s %-8d %-8d %-12d %-10d %-12d\n",
                    p[idx].pid,
                    p[idx].at,
                    p[idx].bt,
                    p[idx].ct,
                    p[idx].wt,
                    p[idx].tat);
        }

        System.out.printf("\nAverage Waiting Time = %.2f ms\n",
                totalWT / p.length);

        System.out.printf("Average Turnaround Time = %.2f ms\n",
                totalTAT / p.length);
    }

    public static void main(String[] args) {

        Process[] processes = {
                new Process("P1", 0, 10),
                new Process("P2", 2, 3),
                new Process("P3", 4, 2)
        };

        System.out.println("=== CPU Scheduling Simulation ===");

        Process[] fcfsData = {
                new Process("P1", 0, 10),
                new Process("P2", 2, 3),
                new Process("P3", 4, 2)
        };

        fcfs(fcfsData);

        sjf(processes);
    }
}

