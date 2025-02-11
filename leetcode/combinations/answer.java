class Solution {
    public static Integer[] arr;

    public List<List<Integer>> combine(int n, int k) {
        arr = new Integer[k];
        List<List<Integer>> list = new ArrayList<>();

        combi(1, 0, n, k, list);

        return list;
    }

    public void combi(int start, int c, int n, int k, List<List<Integer>> list) {
        if(c == k) {
            Integer[] copy = Arrays.copyOf(arr, k);
            list.add(Arrays.asList(copy));
            return;
        }

        for(int i=start; i<=n; i++) {
            arr[c] = i;
            combi(i + 1, c + 1, n, k, list);
            arr[c] = 0;
        }
    }
}