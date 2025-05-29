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
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if(root == null) return false
        if(isSame(root, subRoot)) return true

        return isSubtree(root?.left, subRoot) || isSubtree(root?.right, subRoot)
    }

    fun isSame(s: TreeNode?, t: TreeNode?): Boolean {
        if(s == null && t == null) return true
        if(s == null || t == null) return false
        if(s.`val` != t.`val`) return false

        return isSame(s.left, t.left) && isSame(s.right, t.right)
    }
}