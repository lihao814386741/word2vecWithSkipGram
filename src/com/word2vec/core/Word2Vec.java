package com.word2vec.core;

public class Word2Vec {
	private int windowSize; 
	private int vectorSize; 
	private double alpha; 
	private double initialAlpha; 
	private double alphaThreshold; 
	private double sample;
	private int freqThreshold = 5;
	private double[] expTable; 
	private static final int EXP_TABLE_SIZE = 1000; 
	private static final int MAX_EXP = 6;

	public static class Factory {
		private int vectorSize = 300; 
		private int windowSize = 10;
        private int freqThreshold = 5;
		private double sample = 1e-3;
		private double alpha = 0.025;
		private double alphaThreshold = 1e-4;

		public Factory setVectorSize(int size){
			vectorSize = size;
			return this; 
		}

		public Factory setWindow(int size){
			windowSize = size;
			return this; 
		}

		public Factory setFreqThresold(int t) {
			freqThreshold = t;
			return this; 
		}

		public Factory setSample(double rate) {
			sample = rate; 
			return this; 
		}

		public Factory setAlpha(double a){
			alpha = a; 
			return this; 
		}

		public Word2Vec build(){
			return new Word2Vec(this);
		}
	}

	private Word2Vec(Factory factory){
		vectorSize = factory.vectorSize;
		windowSize = factory.windowSize;
		freqThreshold = factory.freqThreshold;
		sample = factory.sample; 
		alpha = factory.alpha;
		initialAlpha = alpha;
		alphaThreshold = factory.alphaThreshold; 

		expTable = new double[EXP_TABLE_SIZE + 1];
		computeExpTable();
	}

	private void computeExpTable(){
		for (int i = 0; i <= EXP_TABLE_SIZE; i ++) {
			expTable[i] = Math.exp((i / (double) EXP_TABLE_SIZE * 2 - 1) * MAX_EXP);
			expTable[i] = expTable[i] / (expTable[i] + 1);
		}
	}

}
