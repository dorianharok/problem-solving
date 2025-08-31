class Solution {
    fun sumOfTheDigitsOfHarshadNumber(x: Int): Int {
        var sum = 0
        var z = x

        while(z != 0) {
            sum += z % 10
            z /= 10
        }

        return if(x % sum == 0) sum else -1
    }
}