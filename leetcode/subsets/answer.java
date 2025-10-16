class Solution {
    public List<List<Integer>> answer = new ArrayList<>();
    public int[] num;

    public List<List<Integer>> subsets(int[] nums) {
        num = nums;
        bt(0, new ArrayList<>());
        return answer;
    }

    public void bt(int start, ArrayList<Integer> list) {
        answer.add(new ArrayList(list));

        for(int i=start; i<num.length; i++) {
            list.add(num[i]);
            bt(i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}