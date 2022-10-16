package br.com.emmerich.klab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.emmerich.klab.model.Deck;
import br.com.emmerich.klab.model.Player;
import br.com.emmerich.klab.response.PlayerResponse;
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
	public ResponseEntity<PlayerResponse> getPlayerDeck(@PathVariable("deck_id") String deckId,
			@RequestBody Player player) {
		try {
			Deck fiveCardsDeck = deckService.drawFiveCards(deckId);

			if (!fiveCardsDeck.isSuccess() || (fiveCardsDeck.getCards().size() < 5)) {
				return ResponseEntity.accepted()
						.body(new PlayerResponse("There's no cards left on this deck: ".concat(deckId), player));
			}

			player.setDeck(fiveCardsDeck);
			return ResponseEntity.ok(new PlayerResponse("", player));
		} catch (Exception e) {
			LOG.error("Error while getting the cards: " + e.toString());
			return ResponseEntity.internalServerError().body(
					new PlayerResponse("Error while requesting the cards from this deck: ".concat(deckId), player));
		}
	}
}
