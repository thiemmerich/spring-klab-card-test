package br.com.emmerich.klab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emmerich.klab.model.Card;
import br.com.emmerich.klab.model.Deck;
import br.com.emmerich.klab.service.DeckService;

@RestController
@RequestMapping("/api/card")
public class CardController {

	private final DeckService deckService;

	public CardController(DeckService deckService) {
		this.deckService = deckService;
	}

	@GetMapping("/{deck_id}")
	public Card getOneCard(@PathVariable("deck_id") String deckId) {
		Deck deck = deckService.drawOneCard(deckId);
		Card card = deck.getCards().stream().findFirst().get();
		return card;
	}
}
