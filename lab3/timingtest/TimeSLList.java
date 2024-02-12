package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        int opCount = 1000;
        AList<Integer> opCounts = new AList<>();
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();

        int tempSize = 1000;
        while (tempSize <= 128000) {
            Ns.addLast(tempSize);
            tempSize *= 2;
        }

        // create an SLList for each size of N
        for (int i = 0; i < Ns.size(); i++) {
            int N = Ns.get(i);
            opCounts.addLast(opCount);
            SLList<Integer> list = new SLList<>();

            // add N items to the SLList
            for (int j = 0; j < N; j++) {
                list.addLast(j);
            }

            // start the timer
            Stopwatch sw = new Stopwatch();

            // perform opCounts getLast operations on the SLList
            for (int k = 0; k < opCount; k++) {
                list.getLast();
            }

            // stop and check timer
            times.addLast(sw.elapsedTime());
        }
        printTimingTable(Ns, times, opCounts);
    }
}
