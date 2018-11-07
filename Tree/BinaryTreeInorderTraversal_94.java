/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Earl_iu
 *    1
 *      \
 *      2
 *      /
 *     3
 * inorder的顺序是左中右
 */
public class BinaryTreeInorderTraversal_94 {
    List li = new ArrayList();
    public List<Integer> inorderTraversal(TreeNode root) {
        help(root);
        
        return li;
    }
    
    public void help(TreeNode root){
        if(root !=null){
            if(root.left != null){
            inorderTraversal(root.left);
            }
            li.add(root.val);
            if(root.right !=null){
                inorderTraversal(root.right);
            }
        }     
    }
}
