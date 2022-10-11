package br.com.emmerich.klab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Player {
	private String name;
	private List<Card> playerDeck;

	public Player() {
		this.playerDeck = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getPlayerDeck() {
		return playerDeck;
	}

	public void setPlayerDeck(List<Card> playerDeck) {
		this.playerDeck = playerDeck;
	}

	public void addCardToDeck(Card card) {
		if (this.playerDeck == null) {

		}
		this.playerDeck.add(card);
	}

	@JsonIgnore
	public Integer deckSum() {
		AtomicInteger sum = new AtomicInteger(0);

		playerDeck.stream().forEach(card -> {
			sum.getAndAdd(card.getValueInteger());
		});

		return sum.get();
	}
}
