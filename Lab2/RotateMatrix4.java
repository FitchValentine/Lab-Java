public class RotateMatrix4 {
    public static int[][] rotateClockwise(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Transpose the matrix
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }

        // Reverse each row to achieve clockwise rotation
        int[][] rotatedMatrix = new int[cols][rows];
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                rotatedMatrix[i][j] = transposedMatrix[i][rows - j - 1];
            }
        }

        return rotatedMatrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] originalMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        System.out.println("Original matrix:");
        printMatrix(originalMatrix);

        int[][] rotatedMatrix = rotateClockwise(originalMatrix);

        System.out.println("\nMatrix rotated 90 degrees clockwise:");
        printMatrix(rotatedMatrix);
    }
}