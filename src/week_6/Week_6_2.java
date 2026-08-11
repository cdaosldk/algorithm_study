package week_6;

// 프로그래머스 : 주사위 게임 3
// 1부터 6까지 숫자가 적힌 주사위가 네 개 있습니다.
// 네 주사위를 굴렸을 때 나온 숫자에 따라 다음과 같은 점수를 얻습니다.
// 네 주사위에서 나온 숫자가 모두 p로 같다면 1111 × p점을 얻습니다.
// 세 주사위에서 나온 숫자가 p로 같고 나머지 다른 주사위에서
// 나온 숫자가 q(p ≠ q)라면 (10 × p + q)2 점을 얻습니다.
// 주사위가 두 개씩 같은 값이 나오고,
// 나온 숫자를 각각 p, q(p ≠ q)라고 한다면 (p + q) × |p - q|점을 얻습니다.
// 어느 두 주사위에서 나온 숫자가 p로 같고
// 나머지 두 주사위에서 나온 숫자가 각각 p와 다른 q, r(q ≠ r)이라면 q × r점을 얻습니다.
// 네 주사위에 적힌 숫자가 모두 다르다면 나온 숫자 중
// 가장 작은 숫자 만큼의 점수를 얻습니다.
// 네 주사위를 굴렸을 때 나온 숫자가 정수 매개변수 a, b, c, d로 주어질 때,
// 얻는 점수를 return 하는 solution 함수를 작성해 주세요.
// a, b, c, d는 1 이상 6 이하의 정수입니다.

import java.util.Arrays;

class Solution_6_2 {
    public int solution(int a, int b, int c, int d) {
        int[] dices = {a, b, c, d};
        Arrays.sort(dices);

        if (dices[0] == dices[3]) {
            return 1111 * dices[0];
        }

        if (dices[0] == dices[2]) {
            return (int) Math.pow((10 * dices[0] + dices[3]), 2);
        }
        if (dices[1] == dices[3]) {
            return (int) Math.pow(10 * dices[1] + dices[0], 2);
        }

        if (dices[0] == dices[1] && dices[2] == dices[3]) {
            return (dices[0] + dices[2]) * Math.abs(dices[0] - dices[2]);
        }

        if (dices[0] == dices[1]) {
            return dices[2] * dices[3];
        }
        if (dices[1] == dices[2]) {
            return dices[0] * dices[3];
        }
        if (dices[2] == dices[3]) {
            return dices[0] * dices[1];
        }

        return dices[0];
    }
}

public class Week_6_2 {
    public static void main(String[] args) {
        Solution_6_2 solution = new Solution_6_2();

        System.out.println(solution.solution(2, 2, 2, 2)); // 2222
        System.out.println(solution.solution(4, 1, 4, 4)); // 1681
        System.out.println(solution.solution(6, 3, 3, 6)); // 27
        System.out.println(solution.solution(2, 5, 2, 6)); // 30
        System.out.println(solution.solution(6, 4, 2, 5)); // 2
    }
}