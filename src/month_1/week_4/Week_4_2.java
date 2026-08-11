package month_1.week_4;

// 프로그래머스 : 괄호 회전하기
// 다음 규칙을 지키는 문자열을 올바른 괄호 문자열이라고 정의합니다.
//
// (), [], {} 는 모두 올바른 괄호 문자열입니다.
// 만약 A가 올바른 괄호 문자열이라면, (A), [A], {A} 도 올바른 괄호 문자열입니다.
// 예를 들어, [] 가 올바른 괄호 문자열이므로, ([]) 도 올바른 괄호 문자열입니다.
// 만약 A, B가 올바른 괄호 문자열이라면, AB 도 올바른 괄호 문자열입니다.
// 예를 들어, {} 와 ([]) 가 올바른 괄호 문자열이므로, {}([]) 도 올바른 괄호 문자열입니다.
// 대괄호, 중괄호, 그리고 소괄호로 이루어진 문자열 s가 매개변수로 주어집니다.
// 이 s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
// s가 올바른 괄호 문자열이 되게 하는 x의 개수를 return 하도록 solution 함수를 완성해주세요.

import java.util.ArrayDeque;
import java.util.HashMap;

class Solution_4_2 {
    public int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();

        // 여는 괄호 -> 닫는 괄호 매핑
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        int length = s.length();
        int answer = 0;
        String doubled = s + s;

        A : for (int i = 0; i < length; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();

            for (int j = i; j < i + length; j++) {
                char c = doubled.charAt(j);

                if (map.containsKey(c)) {
                    // 여는 괄호인 경우 스택에 담기
                    stack.push(c);
                } else {
                    // 닫는 괄호인데 스택이 비어있거나, 짝이 안 맞는 경우 실패 처리
                    if (stack.isEmpty() || map.get(stack.pop()) != c) {
                        continue A;
                    }
                }
            }

            // 모든 글자를 확인한 뒤 스택에 남은 괄호가 없어야 올바른 문자열
            if (stack.isEmpty()) {
                answer++;
            }
        }

        return answer;
    }
}

public class Week_4_2 {
    public static void main(String[] args) {
        Solution_4_2 solution = new Solution_4_2();

        String dirs = "[](){}";
        System.out.println(solution.solution(dirs));

        String dirs_2 = "}]()[{";
        System.out.println(solution.solution(dirs_2));

        String dirs_3 = "[)(]";
        System.out.println(solution.solution(dirs_3));

        String dirs_4 = "}}}";
        System.out.println(solution.solution(dirs_4));
    }
}