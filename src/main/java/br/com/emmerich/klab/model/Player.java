package br.com.emmerich.klab.model;

import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Player {
	private String name;
	private Deck deck;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	@JsonIgnore
	public void addCardToDeck(Card card) {
		this.deck.getCards().add(card);
	}

	@JsonIgnore
	public Integer deckSum() {
		AtomicInteger sum = new AtomicInteger(0);

		deck.getCards().stream().forEach(card -> {
			sum.getAndAdd(card.getValueInteger());
		});

		return sum.get();
	}

	@Override
	public String toString() {
		return "Player Name: " + this.getName() + " Cards Sum: " + this.deckSum();
	}
}
