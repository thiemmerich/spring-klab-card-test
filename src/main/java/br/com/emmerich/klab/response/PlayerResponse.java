package br.com.emmerich.klab.response;

import br.com.emmerich.klab.model.Player;

public class PlayerResponse {
	private String errorMessage;
	private Player player;

	public PlayerResponse() {
	}

	public PlayerResponse(String errorMessage, Player player) {
		this.errorMessage = errorMessage;
		this.player = player;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

}
