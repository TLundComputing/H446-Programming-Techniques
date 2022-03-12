# Writing to a file is very similar to reading from a file but instead of using "r" you use "w"
# The argument of "a" can also be used to append. .close() should always be called to close the resource and save
# changes

file = open("../resources/writtenFile.txt", "w")
file.write("This is the first line\n")
file.write("This is the 2nd line\n")
file.close()

file = open("../resources/writtenFile.txt", "a")
file.write("Author - TLundComputing\n")
file.close()
