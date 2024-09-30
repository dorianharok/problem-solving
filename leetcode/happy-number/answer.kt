class Solution {
    fun isHappy(n: Int): Boolean {
        var slow = getNext(n)
        var fast = getNext(getNext(n))

        while(slow != 1 || fast != 1) {
            if (slow == fast) {
                return false
            }

            slow = getNext(slow)
            fast = getNext(getNext(fast))
        }

        return true
    }

    fun getNext(n: Int): Int {
        var sum = 0
        var num = n

        while(num != 0) {
            sum += (num % 10) * (num % 10)
            num /= 10
        }

        return sum
    }
}