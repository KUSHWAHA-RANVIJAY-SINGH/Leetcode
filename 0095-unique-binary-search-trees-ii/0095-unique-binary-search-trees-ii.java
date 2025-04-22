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
    public List<TreeNode> generateTrees(int n) {
         if (n == 0) return new ArrayList<>();  
        return generateTreesHelper(1, n);  
    }  
    
    private List<TreeNode> generateTreesHelper(int start, int end) {  
        List<TreeNode> allTrees = new ArrayList<>();  
        
        if (start > end) {  
            allTrees.add(null);  
            return allTrees;  
        }  
        
        // pick each number as root  
        for (int i = start; i <= end; i++) {  
            // all possible left subtrees if i is chosen to be a root  
            List<TreeNode> leftTrees = generateTreesHelper(start, i - 1);  
            // all possible right subtrees if i is chosen to be a root  
            List<TreeNode> rightTrees = generateTreesHelper(i + 1, end);  
            
            // combine left and right trees with root i  
            for (TreeNode left : leftTrees) {  
                for (TreeNode right : rightTrees) {  
                    TreeNode currentRoot = new TreeNode(i);  
                    currentRoot.left = left;  
                    currentRoot.right = right;  
                    allTrees.add(currentRoot);  
                }  
            }  
        }  
        return allTrees;  
    }
    
}

class TreeNode {  
    int val;  
    TreeNode left;  
    TreeNode right;  
    TreeNode(int x) { val = x; }  
}  
