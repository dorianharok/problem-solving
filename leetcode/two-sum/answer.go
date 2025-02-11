func twoSum(nums []int, target int) []int {
    m := make(map[int]int)

    for i, val := range nums {
        index, ok := m[target - val]

        if ok {
            return []int{index, i}
        }

        m[val] = i
    }

    return nil
}