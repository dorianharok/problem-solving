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

    fun preorderTraversal(root: TreeNode?): List<Int> {
        preorder(root)

        return list
    }

    fun preorder(root: TreeNode?) {
        root ?: return

        list.add(root.`val`)
        preorder(root.left)
        preorder(root.right)
    }
}