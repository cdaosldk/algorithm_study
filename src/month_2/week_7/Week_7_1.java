package month_2.week_7;

// 양의 정수 n이 매개변수로 주어집니다.
// n × n 배열에 1부터 n2 까지 정수를 인덱스 [0][0]부터
// 시계방향 나선형으로 배치한 이차원 배열을 return 하는
// solution 함수를 작성해 주세요.

// 1 ≤ n ≤ 30

class Solution_7_1 {
    public int[][] solution(int n) {
        int[][] matrix = new int[n][n];

        // 현재 위치 (시작점: 0, 0)
        int r = 0, c = 0;

        // 시계방향 이동 규칙 (오른쪽 -> 아래 -> 왼쪽 -> 위)
        int[] dr = {0, 1, 0, -1}; // 행(세로) 변화량
        int[] dc = {1, 0, -1, 0}; // 열(가로) 변화량
        int dirIdx = 0;           // 현재 방향 인덱스 (0:우, 1:하, 2:좌, 3:상)

        // 1부터 n^2까지 숫자를 차례대로 채우기
        for (int num = 1; num <= n * n; num++) {
            matrix[r][c] = num; // 현재 칸에 숫자 기록

            // 다음에 이동할 칸 미리 계산해보기
            int nextR = r + dr[dirIdx];
            int nextC = c + dc[dirIdx];

            // 방향을 바꾸어야 하는 조건 검사:
            // 1. 격자판 벽 밖으로 벗어나거나
            // 2. 이미 숫자가 채워져 있는 칸(0이 아닌 칸)을 만났을 때
            if (nextR < 0 || nextR >= n || nextC < 0 || nextC >= n || matrix[nextR][nextC] != 0) {
                dirIdx = (dirIdx + 1) % 4; // 시계방향으로 90도 회전
            }

            // 실제로 위치 이동하기
            r += dr[dirIdx];
            c += dc[dirIdx];
        }

        return matrix;
    }
}

public class Week_7_1 {
    public static void main(String[] args) {
        Solution_7_1 solution = new Solution_7_1();

        int[][] result = solution.solution(4);

        for (int[] row : result) {
            for (int val : row) {
                System.out.printf("%3d ", val);
            }
            System.out.println();
        }
    }
}