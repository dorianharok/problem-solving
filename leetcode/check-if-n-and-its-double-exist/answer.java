class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int zero = 0;
        for(int n : arr) {
            if(n == 0) {
                zero++;
            }
            set.add(n);
        }
        if(zero > 1) {
            return true;
        }

        for(int n : arr) {
            if(n == 0) continue;
            if(set.contains(n * 2)) {
                return true;
            }
        }

        return false;
    }
}