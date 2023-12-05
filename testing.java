public class Example {
    public static void main(String[] args) {
        int x = 1;
        switch (x) {
            case 1:
                System.out.println("x is equal to 1");
                break;
            case 2:
                System.out.println("x is equal to 2");
                break;
            default:
                System.out.println("x is not equal to 1 or 2");
        }
    }
}
/* UnusedVariable: The variable args is declared but never used.
EmptyBlock: The default block is empty. It’s generally considered a bad practice to have empty blocks because they can lead to bugs and make the code harder to read.
MissingSwitchDefault: The switch statement doesn’t have a default case. It’s generally considered a good practice to include a default case in switch statements to handle unexpected values.*/
