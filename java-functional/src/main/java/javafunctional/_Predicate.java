package javafunctional;

import java.util.function.Predicate;

public class _Predicate {
    public static void main(String[] args) {
        String phoneNumber = "4084838448";
        imperative(phoneNumber);
        declarative(phoneNumber);
    }

    static void imperative(String phoneNumber) {
        System.out.println(phoneNumber + " : " + isPhoneNumberValid(phoneNumber));
    }

    static boolean isPhoneNumberValid(String phoneNumber) {
        return phoneNumber.startsWith("408") && phoneNumber.length() == 10;
    }

    static void declarative(String number) {
        Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
                phoneNumber.startsWith("408") && phoneNumber.length() == 10;

        System.out.println(isPhoneNumberValidPredicate.test(number));
    }
}