package main;
public class SingleVowelState extends State {

	@Override
	int handleChar(WordCounter wordCounter, char c) {
		if(isVowel(c)) 
			wordCounter.setState(wordCounter.multiVowelState);
		else if (isLetter(c)){
			wordCounter.setState(wordCounter.consonantState);
			return 1;
		}else if(isHyphen(c)){
			wordCounter.setState(wordCounter.hyphenState);
			return 1;
		}else if (isSeparator(c)) {
			wordCounter.setState(wordCounter.startState);
			return 1;
		}
		return 0;
	}

}
