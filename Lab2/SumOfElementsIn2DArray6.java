public class SumOfElementsIn2DArray6 {
    public static int sumOfElements(int[][] arr) {
        int sum = 0;

        for (int[] row : arr) {
            for (int num : row) {
                sum += num;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int totalSum = sumOfElements(arr);
        System.out.println("Sum of all elements in the 2D array: " + totalSum);
    }
}
