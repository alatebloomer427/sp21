package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    /** returns the times of constructing ALists of different sizes using the given resize method. */
    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
//        // create three ALists to store the data to be tested
//        AList<Integer> Ns = new AList<>();
//        AList<Double> times = new AList<>();
//        AList<Integer> opCounts = new AList<>();
//
//        // double the size of the AList until it reaches 128000 and store each result into Ns
//        int tempSize = 1000;
//        while (tempSize <= 128000) {
//            Ns.addLast(tempSize);
//            opCounts.addLast(tempSize);
//            tempSize *= 2;
//        }
//
//        // for each size N, construct an AList by adding one item each time to the end of the list, until it reaches the target size N
//        // start timer before construction begins
//        // end timer
//        for (int i = 0; i < Ns.size(); i++) {
//            int N = Ns.get(i);
//            AList<Integer> list = new AList<>();
//            Stopwatch sw = new Stopwatch();
//            for (int j = 0; j < N; j++) {
//                list.addLast(j);
//            }
//            times.addLast(sw.elapsedTime());
//        }
//        printTimingTable(Ns, times, opCounts);

        Integer[] sizes = new Integer[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        for (Integer size : sizes) {
            Ns.addLast(size);
            opCounts.addLast(size);
            AList<Integer> L = new AList<>();
            Stopwatch sw = new Stopwatch();
            for (int i = 0; i < size; i++) {
                L.addLast(i);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }
        printTimingTable(Ns, times, opCounts);
    }
}
