package com.word2vec.test;

import com.word2vec.core.Word2Vec;

public class Test {
	public static void main (String [] args)
	{
		Word2Vec wv = new Word2Vec.Factory().setWindow(300).build();
	}


}
