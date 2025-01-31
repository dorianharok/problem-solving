class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] arr) {
        partition(arr, 0, 0, arr.length);
        return answer;
    }

    public void partition(int[][] arr, int x, int y, int size) {
        if(isSame(arr, x, y, size)) {
            answer[arr[x][y]]++;
            return;
        }

        size /= 2;

        partition(arr, x, y, size);
        partition(arr, x + size, y, size);
        partition(arr, x, y + size, size);
        partition(arr, x + size, y + size, size);
    }

    public boolean isSame(int[][] arr, int x, int y, int size) {
        int p = arr[x][y];

        for(int i=x; i < x + size; i++) {
            for(int j=y; j < y + size; j++) {
                if(arr[i][j] != p) return false;
            }
        }

        return true;
    }
}