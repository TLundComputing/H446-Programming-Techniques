class Person:

    def __init__(self, name, job):
        self.name = name
        self.job = job

    def describe(self):
        print("Hello, my name is", self.name)
        print("I work as", self.job)

