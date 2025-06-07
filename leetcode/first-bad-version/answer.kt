/* The isBadVersion API is defined in the parent class VersionControl.
      fun isBadVersion(version: Int) : Boolean {} */

class Solution: VersionControl() {
    override fun firstBadVersion(n: Int) : Int {
        var l = 0
        var r = n

        while(l < r) {
            var mid = l + (r - l) / 2

            if(isBadVersion(mid)) {
                r = mid
            } else {
                l = mid + 1
            }
        }

        return l
    }
}