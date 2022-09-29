import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,1,2,-1,-4};
        ThreeSum threeSumInst = new ThreeSum();


        threeSumInst.threeSum(arr).forEach(i -> i.forEach(j -> System.out.print(j + " ")));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();

        this.mergeSort(nums, 0, nums.length - 1);

        for(int a: nums) {
            System.out.print(a + " ");
        }

        System.out.println(" ");

        for(int i = 0; i < nums.length; i++) {
            if( !(i > 0 && nums[i] == nums[i-1]) ) {
                // if NOT same as previous, then only need to check
                // nums[i] will be target
                int left = i + 1;
                int right = nums.length - 1;

                while(left < right) {
                    int threeSum = nums[i] + nums[left] + nums[right];
                    if(threeSum > 0) {
                        right--;
                    } else if(threeSum < 0) {
                        left++;
                    } else {
                        result.add( Arrays.stream(new Integer[]{nums[i], nums[left], nums[right]}).collect(Collectors.toList()) );
                        left++;
                        while(left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    }
                }
            }
        }

        return result;
    }

    public int[] twoSum(int[] numbers, int i, int j, int target) {

        while(i<j) {
            if(numbers[i] + numbers[j] < target) {
                i++;
            } else if(numbers[i] + numbers[j] > target) {
                j--;
            } else {
                break;
            }
        }

        return new int[] {i, j};
    }

    public void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;

            this.mergeSort(arr, left, middle);
            this.mergeSort(arr, middle + 1, right);
            this.merge(arr, left, middle, right);
        }
    }

    public void merge(int[] arr, int left, int middle, int right) {
        int leftSize = middle - left + 1;
        int rightSize = right - middle;

        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[right];

        for(int i = 0; i<leftSize; i++) {
            leftArray[i] = arr[left + i];
        }
        for(int i = 0; i<rightSize; i++) {
            rightArray[i] = arr[middle + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while(i < leftSize && j < rightSize) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
