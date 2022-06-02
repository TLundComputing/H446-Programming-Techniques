from tkinter import *


def button_cmd(button):
    btn_break = button.split("_")
    if btn_break[0] == "t1":
        if btn_break[1] == "50":
            print("50 question")
        elif btn_break[1] == "100":
            print("100 question")
        elif btn_break[1] == "150":
            print("150 question")
        else:
            print("200 question")
    elif btn_break[0] == "t2":
        if btn_break[1] == "50":
            print("50 question")
        elif btn_break[1] == "100":
            print("100 question")
        elif btn_break[1] == "150":
            print("150 question")
        else:
            print("200 question")
    else:
        if btn_break[1] == "50":
            print("50 question")
        elif btn_break[1] == "100":
            print("100 question")
        elif btn_break[1] == "150":
            print("150 question")
        else:
            print("200 question")


def main():
    window = Tk()
    window.geometry("270x240")
    window.title("Quiz Game")
    window.resizable(False, False)
    frame_heading = Frame(window)
    frame_heading.grid(row=0, column=0, columnspan=3, padx=30, pady=5)
    frame_game = Frame(window)
    frame_game.grid(row=1, column=0, columnspan=3, padx=25, pady=10)

    # Creating widgets
    Label(frame_heading, text="Quiz Time", font=('Arial', 16)).grid(row=0, column=0, padx=0, pady=5)
    Label(frame_game, text="Topic 1").grid(row=1, column=0, padx=10, pady=5)
    Label(frame_game, text="Topic 2").grid(row=1, column=1, padx=10, pady=10)
    Label(frame_game, text="Topic 3").grid(row=1, column=2, padx=10, pady=10)
    t1_btn_50 = Button(frame_game, text="50", command=lambda: button_cmd("t1_50"))
    t1_btn_100 = Button(frame_game, text="100", command=lambda: button_cmd("t1_100"))
    t1_btn_150 = Button(frame_game, text="150", command=lambda: button_cmd("t1_150"))
    t1_btn_200 = Button(frame_game, text="200", command=lambda: button_cmd("t1_200"))
    t2_btn_50 = Button(frame_game, text="50", command=lambda: button_cmd("t2_50"))
    t2_btn_100 = Button(frame_game, text="100", command=lambda: button_cmd("t2_100"))
    t2_btn_150 = Button(frame_game, text="150", command=lambda: button_cmd("t2_150"))
    t2_btn_200 = Button(frame_game, text="200", command=lambda: button_cmd("t2_200"))
    t3_btn_50 = Button(frame_game, text="50", command=lambda: button_cmd("t3_50"))
    t3_btn_100 = Button(frame_game, text="100", command=lambda: button_cmd("t3_100"))
    t3_btn_150 = Button(frame_game, text="150", command=lambda: button_cmd("t3_150"))
    t3_btn_200 = Button(frame_game, text="200", command=lambda: button_cmd("t3_200"))

    t1_btn_50.grid(row=2, column=0)
    t1_btn_100.grid(row=3, column=0)
    t1_btn_150.grid(row=4, column=0)
    t1_btn_200.grid(row=5, column=0)

    t2_btn_50.grid(row=2, column=1)
    t2_btn_100.grid(row=3, column=1)
    t2_btn_150.grid(row=4, column=1)
    t2_btn_200.grid(row=5, column=1)

    t3_btn_50.grid(row=2, column=2)
    t3_btn_100.grid(row=3, column=2)
    t3_btn_150.grid(row=4, column=2)
    t3_btn_200.grid(row=5, column=2)

    window.mainloop()


if __name__ == '__main__':
    main()
