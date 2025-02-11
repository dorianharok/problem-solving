class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        combi(0, candidates, 0, target, temp, list);

        return list;
    }

    public void combi(int start, int[] candidates, int sum, int target, List<Integer> temp, List<List<Integer>> list) {
        if (sum >= target) {
            if(sum == target) {
                list.add(new ArrayList<>(temp));
            }

            return;
        }

        for(int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            combi(i, candidates, sum + candidates[i], target, temp, list);
            temp.remove(temp.size() - 1);
        }
    }
}