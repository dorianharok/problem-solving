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
    val list = ArrayList<Int>()

    fun postorderTraversal(root: TreeNode?): List<Int> {
        postorder(root)

        return list
    }

    fun postorder(root: TreeNode?) {
        root ?: return

        postorder(root.left)
        postorder(root.right)
        list.add(root.`val`)
    }
}