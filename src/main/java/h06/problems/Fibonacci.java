package h06.problems;

import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * A class containing different implementations for computing the nth number in the Fibonacci sequence.
 *
 * @author Manuel Peters
 */
public class Fibonacci {

    /**
     * Default Constructor for this class.
     */
    @DoNotTouch
    public Fibonacci() {}

    /**
     * Computes the nth number from the Fibonacci sequence recursively.
     *
     * @param n The index of the Fibonacci sequence to compute.
     * @return The nth number from the Fibonacci sequence.
     */
    @DoNotTouch
    public static int fibonacciRecursiveClassic(int n) {
        if ( n <= 1) {
            return n;
        } else {
            return fibonacciRecursiveClassic(n - 1) + fibonacciRecursiveClassic(n - 2);
        }
    }

    /**
     * Computes the nth number from the Fibonacci sequence using a different recursive approach.
     *
     * @param n The index of the Fibonacci sequence to compute.
     * @return The nth number from the Fibonacci sequence.
     */
    @StudentImplementationRequired
    public static int fibonacciRecursiveDifferent(int n) {
        // TODO: H1.1
        return doTheRecursion(0, 1, n);

    }
      //sowas wie Hilfsmethode
    @StudentImplementationRequired
    private static int doTheRecursion(int a, int b, int n) {
        // TODO: H1.1
        if(n <= 0){
            return a;
        }
        else {
            return doTheRecursion(b, a+b, n-1);
        }

    }

    /**
     * Computes the nth number from the Fibonacci sequence iteratively.
     *
     * @param n The index of the Fibonacci sequence to compute.
     * @return The nth number from the Fibonacci sequence.
     */
    @StudentImplementationRequired
    public static int fibonacciIterative(int n) {
        // TODO: H1.2
        if(n==0) {
            return 0;
        }
        if(n==1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        while(n > 0){
            int temp = a;
            a = b;
            b = temp + b; //rechnet die nächste fibonacci number ; fibonacci(n+1)
            n--;
        }
        return a;



    }
}
