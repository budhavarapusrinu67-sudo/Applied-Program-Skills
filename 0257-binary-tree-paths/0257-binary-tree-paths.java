/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if(root == null)    return res;
        TreeNode cur=root;
        backtrack(cur,"");
        return res;
    }
    public void backtrack(TreeNode root, String s){
        if(s.equals(""))
            s+=root.val;
        else
            s+="->"+root.val;
        if(root.left==null && root.right==null)
        {
            res.add(s);
            return;
        }
        if(root.left!=null)
            backtrack(root.left,s);
        if(root.right!=null)
            backtrack(root.right,s);
    }
}