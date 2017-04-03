package main;

public class HyphenState extends State {

	@Override
	int handleChar(WordCounter wordCounter, char c) {
		if(isE(c))
			wordCounter.setState(wordCounter.eState);
		else if(isVowelOrY(c))
			wordCounter.setState(wordCounter.singleVowelState);
		else if (c == '-')
			wordCounter.setState(wordCounter.nonWordState);
		else if (isLetter(c))
			wordCounter.setState(wordCounter.consonantState);
		else
			wordCounter.setState(wordCounter.nonWordState);
		return 0;
	}

}
