package com.word2vec.structure;

public class HuffmanNeuron implements HuffmanTreeNode {
	protected int freq; 
	protected HuffmanTreeNode parent; 
	protected int code = 0; 

	public HuffmanNeuron(int freq){
		this.freq = freq;
		parent = null; 
	}

	@Override
	public int compareTo(HuffmanTreeNode h) {
		return freq - h.getFrequency();
	}

	@Override
	public void setCode(int c) {
		this.code = c;
	}

	@Override
	public void setFrequency(int freq) {
		this.freq = freq;
	}

	@Override
	public int getFrequency() {
		return this.freq;
	}

	@Override
	public void setParent(HuffmanTreeNode parent) {
		this.parent = parent;
	}

	@Override
	public HuffmanTreeNode getParent() {
		return this.parent;
	}

	@Override
	public HuffmanTreeNode merge(HuffmanTreeNode sibling) {
		/*
		 *Merge two nodes together and update the parent and code 
		 *information. 
		 * */
		HuffmanTreeNode parent = new HuffmanNeuron(freq + sibling.getFrequency());
		this.parent = parent;
		this.code = 0; 
		sibling.setParent(parent); 
		sibling.setCode(1);

		return parent;
	}
}
