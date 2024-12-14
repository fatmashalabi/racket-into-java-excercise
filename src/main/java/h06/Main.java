package h06;

import h06.problems.Fractals;
import h06.ui.DrawInstruction;
import h06.ui.FractalVisualizer;

import static h06.problems.Fractals.dragonCurve;
import static h06.problems.Fractals.kochSnowflake;
import static h06.problems.LinearSearch.linearSearchIterative;
import static h06.problems.LinearSearch.linearSearchRecursive;

/**
 * Main entry point in executing the program.
 */
public class Main {
    /**
     * Main entry point in executing the program.
     *
     * @param args program arguments, currently ignored
     */
    public static void main(String[] args) {
    FractalVisualizer f1 = new FractalVisualizer(Fractals.dragonCurve(5), 90);
    FractalVisualizer f2 = new FractalVisualizer(Fractals.kochSnowflake(5), 60);
    f2.setVisible(true);

}
}
