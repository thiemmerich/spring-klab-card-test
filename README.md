# Card Match API

Just a simple API to create a card deck, players with 5 cards each and a endpoint to know who is the winner of the match or if its a draw.

### Create a shuffled deck:

HTTP GET 

URL: `/api/deck`

### 2 - Create a player deck:

HTTP POST 

URL: `/api/deck/<deck id generated on 1 step>`

Body: 

```javascript 
{
    "name": "Player 1",
    "deck": {}
}
```

### 3 - Send the players list to know who is the winner:

HTTP POST

URL: `/api/player/winner`

Body: 
```javascript 
[
    {
    "name": "Player 1",
    "deck": {
        "success": true,
        "shuffled": null,
        "cards": [
            {
                "code": "QC",
                "image": "https://deckofcardsapi.com/static/img/QC.png",
                "value": "QUEEN",
                "suit": "CLUBS"
            },
            {
                "code": "QS",
                "image": "https://deckofcardsapi.com/static/img/QS.png",
                "value": "QUEEN",
                "suit": "SPADES"
            },
            {
                "code": "6S",
                "image": "https://deckofcardsapi.com/static/img/6S.png",
                "value": "6",
                "suit": "SPADES"
            },
            {
                "code": "3S",
                "image": "https://deckofcardsapi.com/static/img/3S.png",
                "value": "3",
                "suit": "SPADES"
            },
            {
                "code": "2S",
                "image": "https://deckofcardsapi.com/static/img/2S.png",
                "value": "2",
                "suit": "SPADES"
            }
        ],
        "remaining": 11,
        "deck_id": "ajamxgcxyv7r"
    }
},
{
    "name": "Player 2",
    "deck": {
        "success": true,
        "shuffled": null,
        "cards": [
            {
                "code": "4H",
                "image": "https://deckofcardsapi.com/static/img/4H.png",
                "value": "4",
                "suit": "HEARTS"
            },
            {
                "code": "5S",
                "image": "https://deckofcardsapi.com/static/img/5S.png",
                "value": "5",
                "suit": "SPADES"
            },
            {
                "code": "9D",
                "image": "https://deckofcardsapi.com/static/img/9D.png",
                "value": "9",
                "suit": "DIAMONDS"
            },
            {
                "code": "6H",
                "image": "https://deckofcardsapi.com/static/img/6H.png",
                "value": "6",
                "suit": "HEARTS"
            },
            {
                "code": "9S",
                "image": "https://deckofcardsapi.com/static/img/9S.png",
                "value": "9",
                "suit": "SPADES"
            }
        ],
        "remaining": 6,
        "deck_id": "ajamxgcxyv7r"
    }
},
{
    "name": "Player 3",
    "deck": {
        "success": true,
        "shuffled": null,
        "cards": [
            {
                "code": "9H",
                "image": "https://deckofcardsapi.com/static/img/9H.png",
                "value": "9",
                "suit": "HEARTS"
            },
            {
                "code": "0C",
                "image": "https://deckofcardsapi.com/static/img/0C.png",
                "value": "10",
                "suit": "CLUBS"
            },
            {
                "code": "8S",
                "image": "https://deckofcardsapi.com/static/img/8S.png",
                "value": "8",
                "suit": "SPADES"
            },
            {
                "code": "7C",
                "image": "https://deckofcardsapi.com/static/img/7C.png",
                "value": "7",
                "suit": "CLUBS"
            },
            {
                "code": "JD",
                "image": "https://deckofcardsapi.com/static/img/JD.png",
                "value": "JACK",
                "suit": "DIAMONDS"
            }
        ],
        "remaining": 1,
        "deck_id": "ajamxgcxyv7r"
    }
},
{
    "name": "Player 4",
    "deck": {
        "success": false,
        "shuffled": null,
        "cards": [
            {
                "code": "4D",
                "image": "https://deckofcardsapi.com/static/img/4D.png",
                "value": "4",
                "suit": "DIAMONDS"
            }
        ],
        "remaining": 0,
        "deck_id": "ajamxgcxyv7r"
    }
}
]
```
