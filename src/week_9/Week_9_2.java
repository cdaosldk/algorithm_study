package week_9;

import java.util.ArrayList;
import java.util.List;

class Solution_9_2 {
    public int[] solution(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                if (!factors.contains(i)) {
                    factors.add(i);
                }
                n /= i;
            }
        }

        if (n > 1) {
            factors.add(n);
        }

        int[] result = new int[factors.size()];
        for (int i = 0; i < factors.size(); i++) {
            result[i] = factors.get(i);
        }
        return result;
    }
}

public class Week_9_2 {
    public static void main(String[] args) {
        Solution_9_2 solution = new Solution_9_2();

        System.out.println(java.util.Arrays.toString(solution.solution(12)));  // [2, 3]
        System.out.println(java.util.Arrays.toString(solution.solution(17)));  // [17]
        System.out.println(java.util.Arrays.toString(solution.solution(420))); // [2, 3, 5, 7]
    }
}