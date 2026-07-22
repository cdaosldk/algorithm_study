package week_1;

// 정수 배열 numbers가 주어집니다.
// numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는
// 모든 수를 배열에 오름차순으로 담아 return 하도록
// solution 함수를 완성해주세요.

// numbers의 길이는 2 이상 100 이하입니다.
// numbers의 모든 수는 0 이상 100 이하입니다.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_1_2 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}

public class Week_1_2 {
    public static void main(String[] args) {
        Solution_1_2 solution = new Solution_1_2();

        // case 1
        System.out.println(Arrays.toString(solution.solution(new int[]{2, 1, 3, 4, 1})));

        // case 2
        System.out.println(Arrays.toString(solution.solution(new int[]{5,0,2,7})));
    }
}