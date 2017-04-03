package main;
public class EState extends State{

	@Override
	int handleChar(WordCounter wordCounter, char c) {
		if(isVowel(c))
			wordCounter.setState(wordCounter.multiVowelState);
		else if(isLetter(c)){
			wordCounter.setState(wordCounter.consonantState);
			return 1;
		}
		return 0;
	}
	
}
