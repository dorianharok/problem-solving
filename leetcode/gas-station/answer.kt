class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        if(gas.sum() - cost.sum() < 0) {
            return -1
        }

        var start = 0
        var fuel = 0

        for(i in gas.indices) {
            if (fuel + gas[i] - cost[i] < 0) {
                start = i + 1
                fuel = 0
            } else {
                fuel += gas[i] - cost[i]
            }
        }

        return start
    }
}