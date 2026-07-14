package week_2;

import java.util.Arrays;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length;
        int c1 = arr1[0].length;
        int c2 = arr2[0].length;

        int[][] answer = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}

public class Week_2_2 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.solution(
            new int[][]{{1,4}, {3,2}, {4,1}}, new int[][]{{3, 3}, {3, 3}}
        )));
    }
}