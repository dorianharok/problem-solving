class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));
        for(int key : map.keySet()) {
            pq.add(key);
        }

        int[] answer = new int[k];
        for(int i=0; i<k; i++) {
            answer[i] = pq.poll();
        }

        return answer;
    }
}