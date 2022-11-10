class Scratch1 {
    public static void main(String[] args) {
        long a = powerMinusOne(2, 32);
        long b = 77;
        print(a, b);

        long combined = convertIntoOneVariable(a, b);
        Pair convertedBack = convertBack(combined);
        print(convertedBack.a(), convertedBack.b());
    }

    private static void print(long a, long b) {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    private static long convertIntoOneVariable(long a, long b) {
        long combined = 0;
        combined |= (a & (powerMinusOne(2, 64)-powerMinusOne(2, 32))) << 32;
        combined |= (b & (powerMinusOne(2, 32)));
        return combined;
    }

    private static Pair convertBack(long combined) {
        long a = combined >>> 32;
        long b = combined & powerMinusOne(2, 32);
        return new Pair(a, b);
    }

    static long powerMinusOne(int a, int b) {
        return (long)Math.pow(a, b)-1;
    }

    record Pair (long a, long b){}
}