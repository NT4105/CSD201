package lab3;

public class Main {
    // Greatest Common Divisor using recursion
    public static int GCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

    // Power function using recursion, power = base^exponent
    public static double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1 / power(base, -exponent);
        }
        return base * power(base, exponent - 1);
    }

    // Factorial function using recursion
    public static long fact(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    // Fibonacci sequence using recursion
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    // Sum of reciprocals using recursion
    public static double addReciprocals(int n) {
        if (n == 1) {
            return 1.0;
        }
        return (1.0 / n) + addReciprocals(n - 1);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("GCD(48, 18) = " + GCD(48, 18));
        System.out.println("power(2, 3) = " + power(2, 3));
        System.out.println("fact(5) = " + fact(5));
        System.out.println("fib(6) = " + fib(6));
        System.out.println("addReciprocals(4) = " + addReciprocals(4));
    }
}
