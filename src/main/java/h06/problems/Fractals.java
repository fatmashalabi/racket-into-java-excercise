package h06.problems;

import h06.ui.DrawInstruction;
import org.tudalgo.algoutils.student.annotation.DoNotTouch;
import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import java.util.ArrayList;
import java.util.List;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * A class to generate draw instructions in order to draw a dragon curve.
 *
 * @author Manuel Peters
 */
public class Fractals {

    /**
     * Default Constructor for this class.
     */
    @DoNotTouch
    public Fractals() {}

    /**
     * This method calculates a raised to the power of b using recursion.
     * a and b are expected to be non-negative integers.
     *
     * @param a the base, must be non-negative
     * @param b the exponent, must be non-negative
     * @return the result of a raised to the power of b
     */
    @StudentImplementationRequired
    public static int pow(int a, int b) {
       // TODO: H3.1

        return (b == 0) ? 1: a * pow(a, b-1);




    }

    /**
     * This method combines two arrays of DrawInstruction objects into a single array.
     * The elements of the first array are followed by the elements of the second array in the new array.
     *
     * @param arr1 the first array of type DrawInstruction
     * @param arr2 the second array of type DrawInstruction
     * @return A new array containing all elements of arr1 followed by all elements of arr2
     */
    @StudentImplementationRequired
    public static DrawInstruction[] concatenate(DrawInstruction[] arr1, DrawInstruction[] arr2) {
         // TODO: H3.2
        if(arr1.length == 0){
            return arr2;
        }
        if(arr2.length == 0){
            return arr1;
        }
        //else
        DrawInstruction [] arr_con = new DrawInstruction[arr1.length + arr2.length];
        for(int i = 0; i< arr1.length; i++){
            arr_con[i] = arr1[i];
        }
        int index = 0;
        for(int j = arr1.length; j < arr1.length + arr2.length; j++){
            arr_con[j] = arr2[index++];
        }

        return arr_con;

    }

    /**
     * This method creates a new array that is a copy of the input array arr, but with the element at the specified
     * index idx replaced by elem.
     *
     * @param arr the original array of type DrawInstruction
     * @param idx the index at which to replace the element
     * @param elem the new DrawInstruction to place at the specified index
     * @return A new array with the element at idx replaced by elem
     */
    @StudentImplementationRequired
    public static DrawInstruction[] replaceAtIndex(DrawInstruction[] arr, int idx, DrawInstruction elem) {
         // TODO: H3.3
        DrawInstruction[] arr_copy = new DrawInstruction[arr.length];
        int index = 0;
        for( DrawInstruction d : arr){
            arr_copy[index] = d;
            if(index == idx) {
                arr_copy[index] = elem;
            }

                index++;
        }
      return arr_copy;

    }

    /**
     * Generates an array of DrawInstruction objects to draw a dragon curve of order n
     *
     * @param n The order of the dragon curve to generate
     * @return an array of DrawInstruction objects to draw a dragon curve of order n
     */
    @StudentImplementationRequired
    public static DrawInstruction[] dragonCurve(int n) {
        // TODO: H3.4
        DrawInstruction[] arr = new DrawInstruction[n];
        if(n <= 0){
            return new DrawInstruction[] {DrawInstruction.DRAW_LINE};
        }
        else if(n == 1){
            return new DrawInstruction[]{
                DrawInstruction.DRAW_LINE,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.DRAW_LINE
            };
        }
       //else
       return concatenate(
            concatenate(dragonCurve(n-1), new DrawInstruction[] {DrawInstruction.TURN_RIGHT}), (replaceAtIndex(dragonCurve(n-1), pow(2, n-1)-1,  DrawInstruction.TURN_LEFT))
        );


    }

    /**
     * Hilfsmethode
     */
    public static DrawInstruction[] replaceWithArray(DrawInstruction[] arr1, DrawInstruction[] arr2, DrawInstruction elem){
        List<DrawInstruction> tempList = new ArrayList<>();

        for(DrawInstruction d : arr1){
            if(elem.equals(d)){
                for(int i = 0; i< arr2.length; i++) {
                    tempList.add(arr2[i]);
                }
            }

            else {
                tempList.add(d);
            }
        }
        DrawInstruction[] arr_copy = new DrawInstruction[tempList.size()];
        int index = 0;
        for( DrawInstruction d : tempList){
            arr_copy[index] = d;
            index++;
        }
        return arr_copy;


    }


    /**
     * Generates an array of DrawInstruction objects to draw a koch snowflake of order n
     *
     * @param n The order of the koch snowflake to generate
     * @return an array of DrawInstruction objects to draw a koch snowflake of order n
     */
    @StudentImplementationRequired
    public static DrawInstruction[] kochSnowflake(int n) {

        // TODO: H3.5
        if(n<= 0){
            return new DrawInstruction[] {
                DrawInstruction.DRAW_LINE,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.DRAW_LINE,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.TURN_RIGHT,
                DrawInstruction.DRAW_LINE };
        }
        //else
        return replaceWithArray(kochSnowflake(n-1), new DrawInstruction[] {
            DrawInstruction.DRAW_LINE,
            DrawInstruction.TURN_LEFT,
            DrawInstruction.DRAW_LINE,
            DrawInstruction.TURN_RIGHT,
            DrawInstruction.TURN_RIGHT,
            DrawInstruction.DRAW_LINE,
            DrawInstruction.TURN_LEFT,
            DrawInstruction.DRAW_LINE
        }, DrawInstruction.DRAW_LINE
        );
    }
}
