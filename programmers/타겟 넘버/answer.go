var answer int

func solution(numbers []int, target int) int {
    answer = 0
    dfs(numbers, 0, 0, target)

    return answer
}

func dfs(numbers []int, idx int, sum int, target int) {
    if idx == len(numbers) {
        if sum == target {
            answer++
        }

        return
    }

    dfs(numbers, idx + 1, sum + numbers[idx], target)
    dfs(numbers, idx + 1, sum - numbers[idx], target)
}