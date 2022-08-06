package javafunctional;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {
        imperative();
        declarative();
    }

    public static void declarative() {
        Function<Integer, Integer> incrementFunction = i -> i + 1;
        Function<Integer, Integer> multiplyBy10 = i -> i * 10;
        int out = incrementFunction.andThen(multiplyBy10).apply(1);
        System.out.println(out);

        BiFunction<Integer, Integer, Integer> incrAndThenMultBy =
                (i, numToMultiBy) -> ((i + 1) * numToMultiBy);
        int out2 = incrAndThenMultBy.apply(1, 10);
        System.out.println(out2);
    }

    public static void imperative() {
        System.out.println(increment(1));
        System.out.println(incrAndThenMultBy(1, 10));
    }

    static int increment (int i) {
        return i + 1;
    }

    static int incrAndThenMultBy(int i, int numToMultiplyBy) {
        return (i + 1) * numToMultiplyBy;
    }
}
