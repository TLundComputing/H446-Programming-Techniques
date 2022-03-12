# Reading a file
# To read a file you need to use the open() function to be able to open your file. an argument of 'r' means read
# the .strip() function means to delete any trailing whitespace including new lines

file = open("../resources/poem.txt", "r")
for line in file:
    print(line.strip())
