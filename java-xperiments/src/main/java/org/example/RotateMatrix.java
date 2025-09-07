package org.example;

/**
 *
 * Given an N x N matrix, write a method to rotate the matrix by 90 degrees in place.
 *
 * Idea:
 * Rotate the matrix layer by layer.
 * Outer layer → swap elements from top, right, bottom, left.
 * Then move inward to the next layer.
 *
 * ⏳ Time Complexity
 * O(n²) → We touch each element once
 * 💾 Space Complexity
 * O(1) → Rotation is done in place, no extra space proportional to n
 */
public class RotateMatrix {

    public static boolean rotate(int[][] matrix){
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false; // Must be NxN
        int n = matrix.length;
        System.out.println("Matrix length > "+ n);
        for(int layer=0; layer < n/2; layer++){
            int first = layer;
            int last = n-1-layer;

            for(int i=first; i<last; i++){
                int offset = i - first;
                int top = matrix[first][i];
                System.out.println("i >> "+i+" layer >>"+layer+" first > "+first+" last >>"+last+" offset >>"+offset+" top >>"+top+" last-offset >> "+(last-offset));
                // left -> top
                matrix[first][i] = matrix[last - offset][first];
                // bottom -> left
                matrix[last - offset][first] = matrix[last][last - offset];
                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];
                // top -> right
                matrix[i][last] = top;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3, 4},
                {5,  6,  7, 8},
                {9,  10,  11, 12},
                {13, 14, 15, 16}
        };
        rotate(matrix);
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
