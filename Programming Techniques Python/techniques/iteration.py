# Iteration is a technique that allows code to repeat within a given block of code
# All of these examples are going to count from 1 to 10

# For loop - Count controlled, used to loop through arrays and ranges of numbers
print("For loop, counting from 1 to 10")
for number in range(1, 11):
    print(number)

# For loops can also be used to loop through arrays
print("\nFor loop, looping through an array")
shopping_list = ["Eggs", "Milk", "Bread", "Cereal", "Ice Cream"]
print("This is the original list", shopping_list, sep="\n")
print("Shopping list loop:")
for item in shopping_list:
    print(item)

# While loop - Condition controlled, used to loop code until a condition is met
counter = 1
print("\nWhile loop, counting from 1 to 10")
while counter <= 10:
    print(counter)
    counter += 1
