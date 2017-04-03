package main;
public class MultiVowelState extends State {

	@Override
	int handleChar(WordCounter wordCounter, char c) {
		if(isVowel(c))
			return 0;
		else if(isLetter(c))
			wordCounter.setState(wordCounter.consonantState);
		else if(isHyphen(c)){
			wordCounter.setState(wordCounter.hyphenState);
			return 1;
		}else if (isSeparator(c))
			wordCounter.setState(wordCounter.startState);
		return 1;
	}

}
