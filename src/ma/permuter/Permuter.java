package ma.permuter;

/**
 * Non-instantiable class currently containing one public method that 
 * permutes a generic array once (in lexicographic order).
 * 
 * @see #permute
 * @author Magnus Andersen
 */

public final class Permuter {
    
    private Permuter() {
    }
 
    /**
     * Permutes an array once (in lexicographic order).
     * @param <T> a generic type
     * @param array array to be permuted
     * @return true if there was a change, false otherwise
     */
    public static<T extends Comparable> boolean permute(T[] array) {
        int pivot = -1;
        for (int i = 1; i < array.length; i++)
            pivot = array[i].compareTo(array[i-1]) > 0 ? i - 1 : pivot;
        
        if (pivot == -1) return false; // all permutations exhausted
        
        int pivotSuccessor = pivot+1;
        for (int i = pivotSuccessor+1; i < array.length; i++)
            pivotSuccessor = array[i].compareTo(array[pivot]) > 0 ? i : pivotSuccessor;
        
        swap(array, pivot, pivotSuccessor);
        reverse(array, pivot+1);
        
        return true;
    }
    
    private static<T> boolean reverse(T[] array, int fromIndex) {
        if (fromIndex < 0 || fromIndex >= array.length)
            return false; 
        
        int toIndex = array.length-1;
        while (fromIndex < toIndex) {
            swap(array, fromIndex, toIndex);
            fromIndex++;
            toIndex--;
        }
        return true;
        
    }
    
    private static<T> boolean swap(T[] array, int i, int j) {
        if (i < 0 || i >= array.length || j < 0 || j >= array.length)
            return false;
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
        return true;
    }    
}

