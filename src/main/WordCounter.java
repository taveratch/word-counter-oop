package main;

public class WordCounter {
	private State state;
	public State startState;
	public State eState;
	public State consonantState;
	public State singleVowelState;
	public State multiVowelState;
	public State nonWordState;
	public State hyphenState;
	
	public WordCounter() {
		startState = new StartState();
		eState = new EState();
		consonantState = new ConsonantState();
		singleVowelState = new SingleVowelState();
		multiVowelState = new MultiVowelState();
		nonWordState = new NonWordState();
		hyphenState = new HyphenState();
		state = startState;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getState() {
		return state;
	}
	
	public void resetState() {
		this.state = startState;
	}
}
