package h06.problems;

import org.tudalgo.algoutils.student.annotation.StudentImplementationRequired;

import static org.tudalgo.algoutils.student.Student.crash;

public class LinearSearch {

    /**
     * Recursively searches for a target in an array using linear search.
     *
     * @param arr    the array to search in
     * @param target the target to search for
     * @return the index of the target in the array, or -1 if the target is not found
     */
    @StudentImplementationRequired
    public static int linearSearchRecursive(int[] arr, int target) {
        // TODO: H2.1
        return linearSearchRecursiveHelper(arr, target, 0);

    }

    /**
     * Recursively searches for a target in an array using linear search.
     *
     * @param arr    the array to search in
     * @param target the target to search for
     * @param index  the index to start searching from
     * @return the index of the target in the array, or -1 if the target is not found
     */
    @StudentImplementationRequired
    public static int linearSearchRecursiveHelper(int[] arr, int target, int index) {
         // TODO: H2.1

        if(arr.length  == 0 || index >= arr.length){ //empty in racket
            return -1;
        }
        if(arr[index] == target) {
            return index;
        }

        else {
            return linearSearchRecursiveHelper(arr, target, index + 1);
        }

    }

    /**
     * Iteratively searches for a target in an array using linear search.
     *
     * @param arr    the array to search in
     * @param target the target to search for
     * @return the index of the target in the array, or -1 if the target is not found
     */
    @StudentImplementationRequired
    public static int linearSearchIterative(int[] arr, int target) {
     // TODO: H2.2
        if(arr.length == 0){
            return -1;
        }
        int index = 0;
        for(int i : arr){
            if(i == target){
                return index;
            }
            index++;
        }

       return -1;
    }
}
