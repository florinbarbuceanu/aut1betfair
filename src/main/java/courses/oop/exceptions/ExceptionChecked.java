package courses.oop.exceptions;

public class ExceptionChecked {

    public static void main(String[] args) {

        try {
            int radius = Integer.parseInt(args[0]);
            System.out.println(circleArea(radius));
//        } catch (NumberFormatException e) {
//            System.out.println("There is a problem with provided argument:" + e.getMessage());
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("There is no element at provieded index");
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException exception) {
            System.out.println("Provided parameter need to be an integer number, exception found:" + exception.getMessage());
        } catch (IllegalArgumentException | MyCustomException e) {
            System.out.println(e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Runtime exception");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Close browser at end");
        }
    }


    public static double circleArea(double radius) throws MyCustomException {
        if (radius < 0)
            throw new MyCustomException("Radius should be positive");
        return Math.PI * radius * radius;
    }

// try {
//        op1();
//
//        try {
//            op2();
//            op3();
//        } catch (Exception e) { ... }
//
//        op4();
//        op5();
//    } catch (Exception e) { ... }
//
//    op1 exception? ->
//    op2 exception?
//    op4 exception?
}
