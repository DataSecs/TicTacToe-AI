/*
 * Created with <3 by marcluque, March 2021
 */
public class PerformanceTest {

    public static void main(String[] args) {
        // Warm-up
        for (int i = 0; i < 100; i++) {
            MiniMaxSearch.search();
        }

        // Minimax
        long best = Integer.MAX_VALUE;
        for (int i = 0; i < 10000; i++) {
            Map.visitedStates = 0;
            long start = System.nanoTime();
            MiniMaxSearch.search();
            long end = System.nanoTime();
            if ((end - start) < best) {
                best = (end - start);
            }
        }

        Map.printStats("MiniMax", best);
        System.out.println();

        // Alpha-Beta
        best = Integer.MAX_VALUE;
        for (int i = 0; i < 10000; i++) {
            Map.visitedStates = 0;
            long start = System.nanoTime();
            AlphaBetaSearch.search();
            long end = System.nanoTime();
            if ((end - start) < best) {
                best = (end - start);
            }
        }

        Map.printStats("Alpha-Beta", best);
        System.out.println();
    }
}
