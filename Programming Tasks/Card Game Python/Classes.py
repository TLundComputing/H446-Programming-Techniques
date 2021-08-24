class Player:
    def __init__(self, name):
        self.name = name
        self.score = 0
        self.winning_cards = []
        self.card = None

    def get_name(self):
        return self.name

    def get_score(self):
        return self.score

    def add_cards(self, card1, card2):
        self.winning_cards.append(card1)
        self.winning_cards.append(card2)
        self.score = len(self.winning_cards)

    def get_winning_cards(self):
        return self.winning_cards

    def set_current_card(self, card):
        self.card = card

    def get_current_card(self):
        return self.card


class Card:
    def __init__(self, colour, value):
        self.colour = colour
        self.value = value

    def get_colour(self):
        return self.colour

    def get_value(self):
        return self.value
