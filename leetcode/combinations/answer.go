func combine(n int, k int) [][]int {
    result := make([][]int, 0)
    arr := make([]int, k)

    var combi func(start, c int)
    combi = func(start, c int) {
        if c == k {
            temp := append([]int{}, arr...)
            result = append(result, temp)
            return
        }

        for i := start; i<=n; i++ {
            arr[c] = i
            combi(i + 1, c + 1)
            arr[c] = 0
        }
    }

    combi(1, 0)
    return result
}