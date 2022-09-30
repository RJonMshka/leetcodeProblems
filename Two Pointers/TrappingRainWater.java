public class TrappingRainWater {
    public static void main(String[] args) {
        int[] heightArray = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(
                new TrappingRainWater().trap(heightArray)
        );
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int result = 0;

        while(left < right) {
            if(height[left] <= height[right]) {
                if(maxLeft - height[left] > 0) {
                    result += maxLeft - height[left];
                }
                maxLeft = Math.max(maxLeft, height[left]);
                left++;
            } else {
                if(maxRight - height[right] > 0) {
                    result += maxRight - height[right];
                }
                maxRight = Math.max(maxRight, height[right]);
                right--;
            }
        }

        return result;
    }
}
