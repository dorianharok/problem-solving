func combinationSum(candidates []int, target int) [][]int {
    result := make([][]int, 0)
    temp := make([]int, 0)

    var combi func(start, sum int)
    combi = func(start, sum int) {
        if sum >= target {
            if sum == target {
                newTemp := append([]int{}, temp...)
                result = append(result, newTemp)
            }
            return
        }

        for i := start; i < len(candidates); i++ {
            temp = append(temp, candidates[i])
            combi(i, sum + candidates[i])
            temp = temp[:len(temp)-1]
        }
    }

    combi(0, 0)

    return result
}