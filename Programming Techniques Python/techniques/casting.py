# Casting is the art of changing variable data types with others e.g. string to integer
age = "27"

# currently, the age data type is a string, we can test this using
print(age, type(age))

# We can change the variable data type as follows
age = int(age)
print(age, type(age))

age = float(age)
print(age, type(age))
