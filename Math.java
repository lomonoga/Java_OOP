package firstTask;

public class Math {
    /**
     * The method returns the factorial of the input number
     * Takes a number type int
     * Works with numbers in the range [0, 13)
     */
    public long fact(int n) throws Exception {
        if (n < 0)
            throw new MyException("Такого факториала не существует");
        if (n > 13)
            throw new MyException("Введите число меньше 13!");
        var factorial = 1;
        for (var i = 1; i <= n; i++)
            factorial *= i;
        return factorial;
    }

    /**
     * Returns the value of the sign of a numbers
     * Takes a number type int
     * If number is negative returns -1
     * If positive 1
     * If the number is comparable to 0, then it returns 0
     */
    public int sign(int n){
        if (n == 0) return 0;
        return n > 0 ? 1 : -1;
    }
}

