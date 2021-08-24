class Stack:
    def __init__(self, size=100):
        self.stack = []
        self.pointer = -1
        self.size = size

    def push(self, item):
        if self.pointer == self.size - 1:
            print("Stack is full")
        else:
            self.pointer += 1
            if len(self.stack) - 1 < self.pointer:
                self.stack.append(item)
            else:
                self.stack[self.pointer] = item

    def pop(self):
        if self.pointer < 0:
            print("Stack is empty")
        else:
            item = self.stack[self.pointer]
            self.pointer -= 1
            return item

    def is_empty(self):
        return self.pointer < 0
