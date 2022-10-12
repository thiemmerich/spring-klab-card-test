package br.com.emmerich.klab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emmerich.klab.model.Deck;
import br.com.emmerich.klab.model.Player;
import br.com.emmerich.klab.service.DeckService;

@RestController
@RequestMapping("/api/deck")
public class DeckController {

	private static final Logger LOG = LoggerFactory.getLogger(DeckController.class);
	private final DeckService deckService;

	public DeckController(DeckService deckService) {
		this.deckService = deckService;
	}

	@GetMapping
	public Deck getAShuffledDeck() {
		Deck deck = deckService.getShuffledDeck();

		return deck;
	}

	@PostMapping("/{deck_id}")
	public Player getPlayerDeck(@PathVariable("deck_id") String deckId, Player player) {
		Deck fiveCardsDeck = deckService.drawFiveCards(deckId);

		LOG.info("Player: " + player.toString());
		LOG.info("Five Cards Deck: " + fiveCardsDeck.toString());
		
		player.setDeck(fiveCardsDeck);

		return player;
	}
}
