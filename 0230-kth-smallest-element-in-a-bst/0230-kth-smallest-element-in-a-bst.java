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
    public void inorder(TreeNode root, List<Integer> list){
        // inorder traversal logic
        if (root == null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public int kthSmallest(TreeNode root, int k) {
        // in a bst elements we know less than node there in left and greater are in right 
        // we do an inorder traversal that is Left → Node → Right
        List<Integer> list = new ArrayList<>(); // make a new arraylist
        inorder(root, list);
        return list.get(k-1); // array is 1 indexed too  ( that means index starts from 1,2,3 like this)
    }
}