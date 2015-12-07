package com.word2vec.structure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

public class HuffmanTree {
	public static void make(Collection<? extends HuffmanTreeNode> nodes) {
		/*
		 *By using a tree to sort the nodes by their frequence.
		 * */
		TreeSet<HuffmanTreeNode> tree = new TreeSet<HuffmanTreeNode>(nodes);

		while (tree.size() > 1){
			/*
			 *get the smallest two elements. 
			 * */
			HuffmanTreeNode left = tree.pollFirst();
			HuffmanTreeNode right = tree.pollFirst();
			HuffmanTreeNode parent = left.merge(right);
			tree.add(parent);
		}
		/*
		 *Finally there would be one node in the tree. 
		 * */
	}

	public static List<HuffmanTreeNode> getPath(HuffmanTreeNode node){
		/*
		 * Find a path from the root to the given node. 
		 * */

		List<HuffmanTreeNode> nodes = new ArrayList<HuffmanTreeNode>();

		for (HuffmanTreeNode p = node; p!= null; p = p.getParent()) {
			nodes.add(p);
		}

		/*
		 * Reverse the path to make sure the order is from the root to the leaf. 
		 * */
		Collections.reverse(nodes);

		return nodes;
	}
}
