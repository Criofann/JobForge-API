package org.kainos.ea;
/**
 * This is an example class.
 */
public final class Example {
    private Example() {
        // This constructor is intentionally empty.
    }

    /**
     * This is the main method.
     * @param args The command-line arguments.
     */
    public static void main(final String[] args) {
        final int x = 1;
        switch (x) {
            case 1:
                System.out.println("x is equal to 1");
                break;
            case 2:
                System.out.println("x is equal to 2");
                break;
            default:
                System.out.println("x is not equal to 1 or 2");
                break;
        }
    }
}


