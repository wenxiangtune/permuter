package ma.permuter;

/**
 * The MIT License (MIT)
 * 
 * Copyright (c) 2015 Magnus Andersen
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in al
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * 
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

