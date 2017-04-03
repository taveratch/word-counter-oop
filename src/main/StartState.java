package main;
public class StartState extends State {

	@Override
	int handleChar(WordCounter wordCounter, char c) {
		
		if(isVowel(c))
			wordCounter.setState(wordCounter.singleVowelState);
		else if(isHyphen(c) || !isLetter(c))
			wordCounter.setState(wordCounter.nonWordState);
		else
			wordCounter.setState(wordCounter.consonantState);
		return 0;
	}
	
}
