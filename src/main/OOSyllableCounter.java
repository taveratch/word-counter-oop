package main;

public class OOSyllableCounter {
	private WordCounter wordCounter;
	
	public OOSyllableCounter() {
		wordCounter = new WordCounter();
	}
	public int countSyllables(String word) {
		int syllable = 0;
		word += " ";
		word = word.toLowerCase();
		for(int i=0; i<word.length(); i++){
			char c = word.charAt(i);
			if (c == '\'') continue;
			syllable += wordCounter.getState().handleChar(wordCounter, c);
			if (c == ' ')
				if(wordCounter.getState().getClass() == EState.class && syllable == 0)
					syllable++;
		}
		//Handle last e
		if(wordCounter.getState().getClass() == EState.class && syllable == 0)
			syllable++;
		wordCounter.resetState();
		return syllable;
	}
}
