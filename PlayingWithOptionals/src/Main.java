import java.util.Optional;

/*
 * Optionals - interesting! Useful?
 * Use Optionals when “there is a clear need to represent ‘no result’ or where null is likely to cause errors.”.
 */

public class Main {
    public static void main(String[] args) {
        Integer multiplier = 5;
        Integer value = null;

        /*
         * Use Optional.of(Something) to assign never null value
         * Use Optional.ofNullable(Something) to assign value that can be null
         *
         * Optional<Integer> alwaysSafeValue = Optional.of(multiplier); // -> Works
         * Optional<Integer> nullValue = Optional.of(value); // -> NullPointerException
         *
         * alwaysSafeValue = Optional.ofNullable(multiplier); // -> Works
         * nullValue = Optional.ofNullable(value); // -> Works
         */
        Optional<Integer> opValue = Optional.ofNullable(value);

        /*
         * To check if Optional have some value use Optional.isPreset()
         */
        if (opValue.isPresent()) {
            System.out.println(opValue.get() * multiplier);
        } else {
            System.out.println("You have to supply the value!");
        }


        /*
         * To avoid the use of if statement Optional.ifPresent() will do the work
         */
        opValue.ifPresent(System.out::println);

        /*
         * But what happens with else statement? Use Optional.orElse(someReturn) to return some default value
         * Use map to apply function to all elements of the Optional. It'll return an optional describing the result
         * In this example .map returns empty Optional which is NULL internally, and .orElse returns 0 because of it.
         */
        System.out.println(opValue.map(s -> s * multiplier).orElse(0));
    }
}
