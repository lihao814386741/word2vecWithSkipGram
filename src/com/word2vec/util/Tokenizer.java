package com.word2vec.util;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Tokenizer {
	private List<String> tokens;
	private ListIterator<String> tokenIter; 

	public Tokenizer(){
		tokens = new LinkedList<String>();
		tokenIter = tokens.listIterator();
	}

	public Tokenizer(String text, String delim){
		tokens = Arrays.asList(text.split(delim));
		tokenIter = tokens.listIterator();
	}

	public int size(){
		return tokens.size();
	}

	public boolean hasMoreTokens(){
		return tokenIter.hasNext();
	}

	public String nextToken(){
		return tokenIter.next();
	}

	public void add(String token){
		if (token == null){
			return ; 
		}
		
		tokens.add(token);
	}

	public String toString(String delim){
		StringBuilder sb = new StringBuilder();
		if (tokens.size() < 1){
			return sb.toString();
		}
		ListIterator<String> tempTokenIter = tokens.listIterator();

		sb.append(tempTokenIter.next());

		while (tempTokenIter.hasNext() == true){
			sb.append(delim).append(tempTokenIter.next());
		}

		return sb.toString();
	}

	public static void main (String [] args)
	{
		String test = "sdfoaj aifjoasd faiweo faiosj foiasd iofjasdifj ijsdofj sdoj fiosdj fojsdoj f"; 
		Tokenizer t = new Tokenizer(test, " ");

		while (t.hasMoreTokens() == true){
			System.out.println(t.nextToken());
		}
	}

}
