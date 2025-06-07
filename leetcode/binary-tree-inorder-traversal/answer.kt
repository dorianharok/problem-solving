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
    var list = ArrayList<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        inorder(root)

        return list
    }

    fun inorder(root: TreeNode?) {
        root ?: return

        inorder(root.left)
        list.add(root.`val`)
        inorder(root.right)
    }
}