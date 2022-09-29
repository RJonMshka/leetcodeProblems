public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heightArray = new int[]{1,8,6,2,5,4,8,3,7};
        ContainerWithMostWater inst = new ContainerWithMostWater();
        System.out.println(
                inst.maxArea(heightArray)
        );
    }

    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while(i < j) {

            maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
            if(height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
