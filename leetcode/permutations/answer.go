func permute(nums []int) [][]int {
    result := make([][]int, 0)
    arr := make([]int, len(nums))
    visited := make([]bool, len(nums))

    var permutation func(k int)
    permutation = func(k int) {
        if k == len(nums) {
            temp := append([]int{}, arr...)
            result = append(result, temp)
            return
        }

        for i := 0; i < len(nums); i++ {
            if visited[i] {
                continue
            }

            arr[k] = nums[i]
            visited[i] = true
            permutation(k + 1)
            visited[i] = false
            arr[k] = 0
        }
    }

    permutation(0)

    return result
}