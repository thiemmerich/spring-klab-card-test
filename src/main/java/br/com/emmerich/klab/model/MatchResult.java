package br.com.emmerich.klab.model;

import java.util.List;

public class MatchResult {

	private String result;
	private List<Player> players;

	public MatchResult() {
	}

	public MatchResult(String result, List<Player> players) {
		this.result = result;
		this.players = players;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

}
