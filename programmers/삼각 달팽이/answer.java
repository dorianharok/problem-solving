class Solution {
    public int[] solution(int n) {
        int[][] triangle = new int[n][n];

        int[] dx = {1, 0, -1};
        int[] dy = {0, 1, -1};

        int direction = 0;

        int num = 1;
        int max = n * (n + 1) / 2;

        int x = 0;
        int y = 0;
        while(num <= max) {
            triangle[x][y] = num++;

            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if(nx < 0 || ny < 0 || nx >= n || ny >= n || triangle[nx][ny] != 0) {
                direction = (direction + 1) % 3;
                nx = x + dx[direction];
                ny = y + dy[direction];
            }

            x = nx;
            y = ny;
        }

        int[] answer = new int[max];
        int k = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<=i; j++) {
                answer[k++] = triangle[i][j];
            }
        }

        return answer;
    }
}