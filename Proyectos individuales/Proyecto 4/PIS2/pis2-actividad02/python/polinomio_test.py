import unittest
from polinomio import Polinomio, PolynomialTooLongError


class PolinomioTest(unittest.TestCase):

    def setUp(self):
        self.p1 = Polinomio([2, 0, 2, -3])
        self.p2 = Polinomio([1, 1, -2])
        self.p3 = Polinomio([1, 0, 2])
        self.p4 = Polinomio([3, 1])
        self.p5 = Polinomio([4, 13, 0, 8, 5])

    def tearDown(self):
        pass

    def test_sum(self):
        self.assertTrue(self.p1.sum(self.p2), [3, 1, 0, -3])

    def test_product(self):
        self.assertEqual(self.p3.product(self.p2), [1, 1, 0, 2, -4])

    def test_division(self):
        self.assertEqual(self.p5.divide_by(self.p4), (154, [-50, 21, -7, 5]))

    def test_division_invalid(self):
        with self.assertRaises(PolynomialTooLongError):
            self.p5.divide_by(self.p3)


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(PolinomioTest)
    unittest.TextTestRunner(verbosity=2).run(suite)
