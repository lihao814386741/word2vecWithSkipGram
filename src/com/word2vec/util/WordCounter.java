package com.word2vec.util;

import java.util.HashMap;
import java.util.Set;

public class WordCounter<T> {
	private HashMap<T, Integer> hashMap = null; 

	public WordCounter(){
		this.hashMap = new HashMap<T, Integer>();
	}

	public void add(T t, int n){
		if (hashMap.containsKey(t) == false) {
			hashMap.put(t, n);
		} else {
			hashMap.put(t, hashMap.get(t) + n);
		}
	}

	public void add(T t){
		this.add(t, 1);
	}

	public int get(T t){
		if (hashMap.containsKey(t) == true){
			return hashMap.get(t);
		} else {
			return 0; 
		}
	}

	public Set<T> keySet(){
		return hashMap.keySet();
	}

	public int size(){
		return hashMap.size();
	}

	public static void main(String[] args) {

		String[] strKeys = {"1", "2", "3", "1", "2", "1", "3", "3", "3", "1", "2"};
		WordCounter<String> counter = new WordCounter<String>();
		for (String strKey : strKeys){
			counter.add(strKey);
		}

		for (String strKey : counter.keySet()){
			System.out.println(strKey + " : " + counter.get(strKey));
		}
		System.out.println(counter.get("9"));
	}
}
