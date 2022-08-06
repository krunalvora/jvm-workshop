package javafunctional;

import java.util.function.Supplier;

public class _Supplier {
    public static void main(String[] args) {
        imperative();
        declarative();
    }

    static void imperative() {
        System.out.println(getDBConnectionURL());
    }

    static String getDBConnectionURL() {
        return "jdbc://localhost:5432/users";
    }

    static void declarative() {
        Supplier<String> dBConnectionURLSupplier = () -> "jdbc://localhost:5432/users";
        System.out.println(dBConnectionURLSupplier.get());
    }
}
