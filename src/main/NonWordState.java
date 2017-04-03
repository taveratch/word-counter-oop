package main;


public class NonWordState extends State{

	@Override
	int handleChar(WordCounter wordCounter, char c) {
		if(isSeparator(c))
			wordCounter.setState(wordCounter.startState);
		return 0;
	}
	
	public void enteredState() {
		
	}
}
