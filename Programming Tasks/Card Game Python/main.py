def resource_path(relative_path):
    absolute_path = os.path.abspath(__file__)
    root_path = os.path.dirname(absolute_path)
    base_path = getattr(sys, 'MEIPASS', root_path)
    return os.path.join(base_path, relative_path)


from tkinter import *
from tkinter import simpledialog
from tkinter import messagebox as box
import random
from DataStructures import Stack
from Classes import *

# Widgets and Initial Values
root = Tk()
frame_heading = Frame(root)
frame_game = Frame(root)
title = Label(frame_heading, text="Card Game!", font=('Arial', 16))
p1_name = Label(frame_game, text="Player 1 Name")
p1_score = Label(frame_game, text="Player 1 Score")
vs = Label(frame_game, text="Vs.", font=('Arial', 16))
p2_name = Label(frame_game, text="Player 1 Name")
p2_score = Label(frame_game, text="Player 1 Score")
setup_btn = Button(root, text="Setup")
next_round_btn = Button(root, text="Play", state=DISABLED)
p1_card = Canvas(frame_game, width=75, height=100, bg="dodgerblue")
p2_card = Canvas(frame_game, width=75, height=100, bg="dodgerblue")
p1_card_text = p1_card.create_text((50, 50), text="Back\nof\nCard", fill="purple", font="Arial 14 bold")
p2_card_text = p2_card.create_text((50, 50), text="Back\nof\nCard", fill="purple", font="Arial 14 bold")
player_1 = Player("Player 1")
player_2 = Player("Player 2")
deck = Stack(30)

# Geometry
frame_heading.grid(row=0, column=0, columnspan=3, padx=30, pady=5)
frame_game.grid(row=1, column=0, columnspan=3, padx=25, pady=10)
title.grid(row=0, column=0, padx=0, pady=5)
p1_name.grid(row=0, column=0, padx=5, pady=5)
p1_score.grid(row=2, column=0, padx=5, pady=5)
vs.grid(row=1, column=1, rowspan=3, padx=5, pady=5)
p2_name.grid(row=0, column=2, padx=5, pady=5)
p2_score.grid(row=2, column=2, padx=5, pady=5)
setup_btn.grid(row=2, column=0, padx=0, pady=5)
next_round_btn.grid(row=2, column=2, padx=0, pady=5)
p1_card.grid(row=1, column=0, padx=5, pady=5)
p2_card.grid(row=1, column=2, padx=5, pady=5)

# Static Properties
root.title("Card Game")
root.resizable(0, 0)


# Dynamic Properties
def setup():
    global player_1
    global player_2
    global deck
    player_1 = Player(ask_name("What is the name of Player 1?"))
    player_2 = Player(ask_name("What is the name if player 2?"))
    p1 = player_1.get_name()
    p2 = player_2.get_name()
    p1_name.configure(text=p1)
    p2_name.configure(text=p2)
    p1_score.configure(text="0")
    p2_score.configure(text="0")
    deck = Stack(30)
    raw_data = []
    for x in range(1, 4):
        for y in range(1, 11):
            if x == 1:
                colour = "red"
            elif x == 2:
                colour = "yellow"
            else:
                colour = "black"
            raw_data.append(Card(colour, y))
    random.shuffle(raw_data)
    for card in raw_data:
        deck.push(card)
    setup_btn.configure(state=DISABLED)
    next_round_btn.configure(state=NORMAL)


def ask_name(message):
    answer = simpledialog.askstring("User Input", message, parent=root)
    if answer is not None:
        return answer
    else:
        return ask_name(message)


def play():
    next_round_btn.configure(state=DISABLED)
    setup_btn.configure(state=NORMAL)
    score1 = 0
    score2 = 0
    while not deck.is_empty():
        player_1.set_current_card(deck.pop())
        player_2.set_current_card(deck.pop())
        col1 = player_1.get_current_card().get_colour()
        col2 = player_2.get_current_card().get_colour()
        val1 = player_1.get_current_card().get_value()
        val2 = player_2.get_current_card().get_value()
        p1_card.configure(bg=col1)
        p2_card.configure(bg=col2)
        p1_card.itemconfig(p1_card_text, text=str(val1))
        p2_card.itemconfig(p2_card_text, text=str(val2))
        if col1 != col2:
            if (col1 == "red" and col2 == "black") or (col1 == "yellow" and col2 == "red") or\
                    (col1 == "black" and col2 == "yellow"):
                player_1.add_cards(player_1.get_current_card(), player_2.get_current_card())
                box.showinfo("Winner", "{} wins that round!".format(player_1.get_name()))
            else:
                player_2.add_cards(player_1.get_current_card(), player_2.get_current_card())
                box.showinfo("Winner", "{} wins that round!".format(player_2.get_name()))
        else:
            if val1 > val2:
                player_1.add_cards(player_1.get_current_card(), player_2.get_current_card())
                box.showinfo("Winner", "{} wins that round!".format(player_1.get_name()))
            else:
                player_2.add_cards(player_1.get_current_card(), player_2.get_current_card())
                box.showinfo("Winner", "{} wins that round!".format(player_2.get_name()))
        score1 = player_1.get_score()
        score2 = player_2.get_score()
        p1_score.configure(text=str(score1))
        p2_score.configure(text=str(score2))
    pop = Toplevel(root)
    pop.title("Winner Details")
    Label(pop, text="Winner", font=("Arial", 16)).pack()
    area = Text(pop)
    btn = Button(pop, text="Finish", command=pop.destroy)
    win_string = ""
    winner = ""
    if score1 > score2:
        win_string += player_1.get_name() + " wins!\n"
        winner += player_1.get_name() + ":" + str(player_1.get_score()) + "\n"
        for card in player_1.get_winning_cards():
            win_string += card.get_colour() + ":" + str(card.get_value()) + "\n"
    else:
        win_string += player_2.get_name() + " wins!\n"
        winner = player_2.get_name() + ":" + str(player_2.get_score()) + "\n"
        for card in player_2.get_winning_cards():
            win_string += card.get_colour() + ":" + str(card.get_value()) + "\n"
    file = open("winners.txt", 'a')
    file.write(winner)
    file.close()
    area.insert(END, win_string.strip())
    area.pack()
    btn.pack()


setup_btn.configure(command=setup)
next_round_btn.configure(command=play)

# Sustain Window
root.mainloop()
