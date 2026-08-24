package week_7;

// 문자열 my_str과 n이 매개변수로 주어질 때,
// my_str을 길이 n씩 잘라서 저장한 배열을
// return하도록 solution 함수를 완성해주세요.

// 1 ≤ my_str의 길이 ≤ 100
// 1 ≤ n ≤ my_str의 길이
// my_str은 알파벳 소문자, 대문자, 숫자로 이루어져 있습니다.

import java.util.ArrayList;
import java.util.Arrays;

class Solution_7_2 {
    public String[] solution(String my_str, int n) {
        ArrayList<String> words = new ArrayList<>();

        for (int i = 0; i < my_str.length(); i += n) {

            words.add(my_str.substring(i, Math.min(my_str.length(), i + n)));
        }

        return words.toArray(new String[0]);
    }
}

public class Week_7_2 {
    public static void main(String[] args) {
        Solution_7_2 solution = new Solution_7_2();

        System.out.println(Arrays.toString(solution.solution("abc1Addfggg4556b", 6)));
    }
}