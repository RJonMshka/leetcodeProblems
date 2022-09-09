public class KokoBanana {
    public static void main(String[] args) {
        int[] piles = new int[]{3,6,7,11};
        int h = 8;
        int result = new KokoBanana().minEatingSpeed(piles, h);
        System.out.println(result);
    }

    public int minEatingSpeed(int[] piles, int h) {
        int maxPiles = piles[0];

        for (int i = 1; i < piles.length; i++) {
            maxPiles = Math.max(maxPiles, piles[i]);
        }

        int low = 0;
        int high = maxPiles;
        int result = 0;

        while(low <= high) {
            int mid = ( low + high ) / 2;

            int hours = 0;

            for (int i = 0; i < piles.length; i++) {
                hours += Math.ceil((double) piles[i] / mid );
            }

            if(hours <= h) {
                // finished early - so k can be even smaller
                high = mid - 1;
            } else if (hours > h) {
                // k can be bigger
                low = mid + 1;
            }

            result = low;

        }

        return result;
    }
}
