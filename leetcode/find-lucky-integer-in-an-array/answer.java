class Solution {
    public int findLucky(int[] arr) {
        int luckyNumber = -1;
        int[] cnt = new int[501];
        for(int a : arr) {
            cnt[a]++;
        }

        for(int i=1; i<=500; i++) {
            if(cnt[i] == i) {
                luckyNumber = i;
            }
        }

        return luckyNumber;
    }
}