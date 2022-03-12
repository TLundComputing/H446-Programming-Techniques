# you need to know how to generate random numbers
# Step 1 - import the random library
# Step 2 - use the functions in the random function
import random

print("Random number between 1 and 10")
print(random.randint(1, 11))

# If you want a selection of random elements from an array then you do the following
lotto_numbers = []
for x in range(1, 53):
    lotto_numbers.append(x)

lucky_numbers = random.sample(lotto_numbers, 6)
print(lucky_numbers)
