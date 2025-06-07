/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var answer = 0

    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)

        return answer
    }

    fun dfs(root: TreeNode?): Int {
        root ?: return 0

        val l = dfs(root?.left)
        val r = dfs(root?.right)

        answer = maxOf(l + r, answer)

        return 1 + maxOf(l, r)
    }
}