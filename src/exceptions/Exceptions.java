package exceptions;

public class Exceptions extends RuntimeException {

    public static class NotEqualsOldWeight extends RuntimeException{
        public NotEqualsOldWeight() {}
    }

    public static class NegativeNumbers extends RuntimeException{
        public NegativeNumbers() {
            System.out.println("Don't use negative numbers");
        }
    }

    public static class NegativeWeight extends RuntimeException{
        public NegativeWeight() {
            System.out.println("The final weight can't negative");
        }
    }

    public static class NotExistIngredient extends RuntimeException{
        public NotExistIngredient(){}
    }
}
