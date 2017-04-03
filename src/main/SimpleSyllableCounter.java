package main;

public class SimpleSyllableCounter {

	public enum State {
		START,CONSONANT, SINGLE_VOWEL, NONWORD, MULTIVOWEL, HYPHEN, E
	}
	
	public int countSyllables(String word) {
		word += " ";
		int count = 0;
		char c = ' ';
		State state = State.START;
		for(int i=0; i<word.length(); i++) {
			c = word.charAt(i);
			if (c == '\'') continue;
			switch(state) {
			case START:
				if(isVowel(c)) state = State.SINGLE_VOWEL;
				else state = State.CONSONANT;
				break;
			case SINGLE_VOWEL:
				if(isVowel(c)) state = State.MULTIVOWEL;
				else if (isLetter(c)){
					state = State.CONSONANT;
					count++;
				}else if (isSeparator(c)) {
					state = State.START;
					count++;
				}
				break;
			case NONWORD:
				if(isSeparator(c)) state = State.START;
				break;
			case MULTIVOWEL:
				if(!isVowel(c)) {
					count ++;
					state = State.CONSONANT;
				}else if (isSeparator(c)) {
					state = State.START;
					count++;
				}
				break;
			case CONSONANT:
				if(isE(c)) {
					state = State.E;
				}else if(isVowelOrY(c)) {
					state = State.SINGLE_VOWEL;
				}else if (c == '-') state = State.HYPHEN;
				else if (isLetter(c)) state = State.CONSONANT;
				else state = State.NONWORD;
				break;
			case E:
				if(isVowel(c)) state = State.MULTIVOWEL;
				else if(isLetter(c)){
					state = State.CONSONANT;
					count++;
				}
				break;
			}
		}
		return count;
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
}
