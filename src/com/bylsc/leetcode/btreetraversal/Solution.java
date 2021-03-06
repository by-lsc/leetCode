package com.bylsc.leetcode.btreetraversal;

import java.util.ArrayList;
import java.util.List;

import com.bylsc.leetcode.btreedepth.TreeNode;

/**
 * 
 * @author lsc
 * @time 2015年12月4日17:15:56
 * @link https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 */

public class Solution {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);
		int psize = 1;
		int csize = 0;// 计算下一层节点的数量，用于输出换行
		List<Integer> row = new ArrayList<Integer>();
		while (list.size() >= 1) {
			row.add(list.get(0).val);
			if (list.get(0).left != null) {
				list.add(list.get(0).left);
				csize++;
			}
			if (list.get(0).right != null) {
				list.add(list.get(0).right);
				csize++;
			}

			list.remove(0);
			psize--;
			if (psize == 0) {// 这一层移除完时，父节点数等于上一层子节点数
				psize = csize;
				csize = 0;
				result.add(row);
				// for (Integer i : row) {
				// System.out.print(i + " ");
				// }
				// System.out.println();
				// row.clear();//不要用clear方法
				row = new ArrayList<Integer>();
			}
		}
		return result;
	}

	/**
	 * Binary Tree Preorder Traversal 前序遍历
	 * @link https://leetcode.com/problems/binary-tree-preorder-traversal/
	 * @time2015年12月12日
	 * @param root
	 */

	private static List<Integer> result = new ArrayList<Integer>();

	public static List<Integer> preorderTraversal(TreeNode root) {
		if (root != null) {
			result.add(root.val);
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
		return result;
	}
	
	
	/**
	 * Binary tree postorder traversal 后序遍历
	 * @link https://leetcode.com/problems/binary-tree-postorder-traversal/
	 * @time2015年12月12日
	 * @param root
	 */

	private static List<Integer> result1 = new ArrayList<Integer>();

	public static List<Integer> postorderTraversal(TreeNode root) {
		if (root != null) {
			postorderTraversal(root.left);
			postorderTraversal(root.right);
			result1.add(root.val);
		}
		return result1;
	}
	
	
	/**
	 * Binary Tree Inorder Traversal 中序遍历
	 * @link https://leetcode.com/problems/binary-tree-inorder-traversal/
	 * @time2015年12月12日
	 * @param root
	 */


	private static  List<Integer> result3 = new ArrayList<Integer>();
	public static List<Integer> inorderTraversal(TreeNode root) {
		if (root != null) {
			inorderTraversal(root.left);
			result3.add(root.val);
			inorderTraversal(root.right);
		}
		return result3;
	}
	

	public static void main(String[] args) {

		// List<TreeNode> list = new ArrayList<TreeNode>();
		// System.out.println(list.get(0));
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);

		node1.left = node2;
		node1.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node6.left = node9;
		node4.left = node7;
		node4.right = node8;
		System.out.println("前序遍历---------------------------------");
		List<Integer> r1 = preorderTraversal(node1);
		for (Integer e : r1) {
			System.out.print(e + "  ");
		}
		System.out.println("\n后序遍历---------------------------------");
		List<Integer> r2 = postorderTraversal(node1);
		for (Integer e : r2) {
			System.out.print(e + "  ");
		}
		System.out.println("\n中序遍历---------------------------------");
		List<Integer> r3 = inorderTraversal(node1);
		for (Integer e : r3) {
			System.out.print(e + "  ");
		}
		System.out.println("\n层次遍历（广度优先）---------------------------------");

		List<List<Integer>> result = levelOrder(node1);
		// List<List<Integer>> result = new ArrayList<List<Integer>>();
		// List<Integer> e = new ArrayList<Integer>();
		// e.add(1);
		// result.add(e);

		for (List<Integer> list : result) {
			for (Integer i : list) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}

	}
}