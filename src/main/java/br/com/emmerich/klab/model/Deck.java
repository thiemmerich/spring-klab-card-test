package br.com.emmerich.klab.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Deck {
	private boolean success;

	@JsonProperty("deck_id")
	private String deckId;

	private String shuffled;

	private List<Card> cards;

	private Integer remaining;

	public Deck() {
	}

	public Deck(boolean success, String deckId, String shuffled, List<Card> cards, Integer remaining) {
		this.success = success;
		this.deckId = deckId;
		this.shuffled = shuffled;
		this.cards = cards;
		this.remaining = remaining;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getDeckId() {
		return deckId;
	}

	public void setDeckId(String deckId) {
		this.deckId = deckId;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public Integer getRemaining() {
		return remaining;
	}

	public void setRemaining(Integer remaining) {
		this.remaining = remaining;
	}

	public String getShuffled() {
		return shuffled;
	}

	public void setShuffled(String shuffled) {
		this.shuffled = shuffled;
	}

	@Override
	public String toString() {
		return "Deck ID: " + this.getDeckId() + " Cards Remaining: " + this.getRemaining() + " Cards: "
				+ this.getCards().size();
	}
}
