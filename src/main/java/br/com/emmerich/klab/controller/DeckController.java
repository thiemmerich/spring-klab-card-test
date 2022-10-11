package br.com.emmerich.klab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emmerich.klab.model.Deck;
import br.com.emmerich.klab.service.DeckService;

@RestController
@RequestMapping("/api/deck")
public class DeckController {

	private final DeckService deckService;

	public DeckController(DeckService deckService) {
		this.deckService = deckService;
	}

	@GetMapping
	public Deck getAShuffledDeck() {
		Deck deck = deckService.getShuffledDeck();

		return deck;
	}

}
