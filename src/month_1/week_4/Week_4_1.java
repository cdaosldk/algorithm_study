package month_1.week_4;

// 괄호가 바르게 짝지어졌다는 것은 '(' 문자로 열렸으면 반드시 짝지어서 ')' 문자로 닫혀야 한다는 뜻입니다. 예를 들어
//
// "()()" 또는 "(())()" 는 올바른 괄호입니다.
// ")()(" 또는 "(()(" 는 올바르지 않은 괄호입니다.
// '(' 또는 ')' 로만 이루어진 문자열 s가 주어졌을 때, 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return 하는 solution 함수를 완성해 주세요.
//
// 문자열 s의 길이 : 100,000 이하의 자연수
// 문자열 s는 '(' 또는 ')' 로만 이루어져 있습니다.

import java.util.ArrayDeque;

class Solution_4_1 {
    boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] a = s.toCharArray();

        // 스택에 대한 이해
        // 자바의 Stack은 크기를 동적으로 관리한다, 또한 스택에 가장 최근에 추가된 데이터를 조회만 하는 peek() 메서드를 제공함
        // push()는 내부 isFull()로 가득 차있는지 확인 후, top을 1 증가시키고 해당 위치에 데이터 추가
        // pop()는 내부 isEmpty()로 비어있는지 확인 후, top를 1 감소시키고 해당 데이터를 반환한다 ~ top는 최근 삽입한 데이터의 위치 : top가 -1이 나오는 경우 데이터가 남아있어도 스택은 비어있다고 할 수 있다
        for (char c : a) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c) { // isEmpty()로 확인 후, pop()으로 스택을 비운다(그냥 pop()은 EmptyStackException 발생 가능
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}

public class Week_4_1 {
    public static void main(String[] args) {
        Solution_4_1 solution = new Solution_4_1();

        String case_1 = "()()";
        System.out.println(solution.solution(case_1));

        String case_2 = "(())()";
        System.out.println(solution.solution(case_2));

        String case_3 = ")()(";
        System.out.println(solution.solution(case_3));

        String case_4 = "(()(";
        System.out.println(solution.solution(case_4));
    }
}