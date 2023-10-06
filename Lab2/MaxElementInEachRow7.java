public class MaxElementInEachRow7 {
    public static int[] findMaxInEachRow(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int[] maxElements = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
            maxElements[i] = max;
        }

        return maxElements;
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6, 12},
                {7, 8, 9, 10}
        };

        int[] maxElements = findMaxInEachRow(arr);

        System.out.println("Maximum element in each row:");
        for (int i = 0; i < maxElements.length; i++) {
            System.out.println("Row " + i + ": " + maxElements[i]);
        }
    }
}
