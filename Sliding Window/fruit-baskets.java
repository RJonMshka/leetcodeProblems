// LC 904. Fruit Into Baskets

import java.util.HashMap;
import java.util.Map;

public class FruitBaskets {
    public static void main(String[] args) {
        int[] fruits = new int[] {1,2,3,2,2};

        System.out.println(
                new FruitBaskets().totalFruit(fruits)
        );
    }
    public int totalFruit(int[] fruits) {
        int maxLimit = 2;
        int result = 0;

        Map<Integer, Integer> fruitType = new HashMap<>();

        int left = 0;
        int right = 0;

        while(left <= right && right < fruits.length) {
            fruitType.put(fruits[right], fruitType.getOrDefault(fruits[right], 0) + 1);

            if(fruitType.size() <= maxLimit) {
                result = Math.max(result, right - left + 1);
            } else {
                while(fruitType.size() > maxLimit) {
                    fruitType.put(fruits[left], fruitType.get(fruits[left]) - 1);
                    if(fruitType.get(fruits[left]).intValue() == 0) {
                        fruitType.remove(fruits[left]);
                    }
                    left++;
                }
            }

            right++;



        }

        return result;
    }
}
