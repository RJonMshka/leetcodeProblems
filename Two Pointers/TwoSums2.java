public class TwoSums2 {
    public static void main(String[] args) {
        int[] numbers = new int[]{2,7,11,15};
        int[] result = new TwoSums2().twoSum(numbers, 9);
        for(int a: result) {
            System.out.print(a + " ");
        }
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while(i<j) {
            if(numbers[i] + numbers[j] < target) {
                i++;
            } else if(numbers[i] + numbers[j] > target) {
                j--;
            } else {
                break;
            }
        }

        return new int[] {i+1, j+1};
    }
}
