class Polinomio(list):

    def sum(self, other):
        '''Return the sum of itself and other polynomial'''
        if len(self) > len(other):
            sol = self[:]
            for x in range(len(other)): sol[x] += other[x]
        else:
            sol = other[:]
            for x in range(len(self)): sol[x] += self[x]
        return sol

    def product(self, other):
        '''Return the product of itself and other polynomial'''
        sol = [0]*(len(self)+len(other)-1)
        for pos1, val1 in enumerate(self):
            for pos2, val2 in enumerate(other):
                sol[pos1+pos2] += val1*val2
        return sol

    def divide_by(self, other):
        '''Return a tuple with the quotient and remainder'''
        if len(other) > 2:
            raise PolynomialTooLongError(0)
        sol = self[:]
        carry = 0
        divisor = -other[0]
        for x in reversed(range(len(sol))):
            sol[x] = carry + sol[x]
            carry = sol[x]*divisor
        return sol[0], sol[1:]

class PolynomialTooLongError(Exception):

    def __init__(self, value):
        self.value = value

    def __str__(self):
        return repr(self.value)
