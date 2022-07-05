# Subprograms come in the form of functions and procedures. to create these you use the def keyword

# Functions, These are programs that are used to return a value.
def addition(number_1, number_2):
    total = number_1 + number_2
    return total


# Procedures are blocks of code that don't return a value.
def welcome_message():
    print("#########################")
    print("##     Calculator      ##")
    print("#########################")


# We can use these subprograms by calling them like built in functions and procedures
welcome_message()
addition_total = addition(5, 7)
print("5 + 7 =", addition_total)
