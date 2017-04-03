package main;

public abstract class State {
	abstract int handleChar(WordCounter wordCounter, char c);
	
	public void enteredState() {
		
	}
	
	public boolean isVowel(char c) {
		final String VOWELS = "aeiuo";
		return VOWELS.contains(c+"");
	}
	
	public boolean isLastCharacter(int index, String word) {
		if(index == word.length()-1) return true;
		return word.charAt(index+1) == ' ';
	}
	
	public boolean isE(char c) {
		return c == 'e';
	}
	
	public boolean isSeparator(char c) {
		return c == ' ';
	}
	
	public boolean isVowelOrY(char c) {
		return isVowel(c) || c == 'y';
	}
	
	public boolean isLetter(char c) {
		return Character.isLetter(c);
	}
	
	public boolean isHyphen(char c) {
		return c == '-';
	}
}
