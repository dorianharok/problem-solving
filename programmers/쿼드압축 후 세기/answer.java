class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        partition(0, 0, arr.length, arr);

        return answer;
    }

    public void partition(int x, int y, int size, int[][] arr) {
        if(isSame(x, y, size, arr)) {
            answer[arr[x][y]]++;
            return;
        }

        int next = size / 2;

        partition(x, y, next, arr);
        partition(x, y + next, next, arr);
        partition(x + next, y, next, arr);
        partition(x + next, y + next, next, arr);
    }

    public boolean isSame(int x, int y, int size, int[][] arr) {
        int number = arr[x][y];

        for(int i=x; i<x + size; i++) {
            for(int j=y; j<y + size; j++) {
                if(arr[i][j] != number) {
                    return false;
                }
            }
        }

        return true;
    }
}