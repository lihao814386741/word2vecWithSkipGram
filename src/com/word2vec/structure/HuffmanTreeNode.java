package com.word2vec.structure;

public interface HuffmanTreeNode extends Comparable<HuffmanTreeNode>{
	/*
	 * set the code, where the code means the current node is the 
	 * right child of its parent node. 
	 * */
	public void setCode(int c);
	/*
	 * set and get the frequency of the current word. 
	 * */
	public void setFrequency(int freq);
	public int getFrequency();
	/*
	 * set and get the parent node of the current node. 
	 * */
	public void setParent();
	public HuffmanTreeNode getParent();
	public HuffmanTreeNode merge(HuffmanTreeNode sibling);
}
