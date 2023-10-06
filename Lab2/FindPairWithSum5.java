import java.util.HashMap;
import java.util.Map;

public class FindPairWithSum5 {
    public static int[] findPair(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }

        Map<Integer, Integer> numToIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numToIndexMap.containsKey(complement)) {
                return new int[] { numToIndexMap.get(complement), i };
            }
            numToIndexMap.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = findPair(nums, target);

        if (result != null) {
            System.out.println("Pair with sum " + target + " found: [" + nums[result[0]] + ", " + nums[result[1]] + "]");
        } else {
            System.out.println("No pair found with sum " + target);
        }
    }
}