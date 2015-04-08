import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by Давидчук_ИВ on 06/04/15.
 */
public class HomeWork01 {
    public static void main(String[] params) {
        Input();
    }
    public static void Input () {
        double area;
        double perimetr;
        String StrSquare = "Input Area: ";
        String StrPerimetr = "Input Perimetr: ";
        Scanner input = new Scanner(System.in);
        System.out.println(StrSquare);
        area = input.nextDouble();

        System.out.println(StrPerimetr);
        perimetr = input.nextDouble();
        calculation(area,perimetr);
    }
    public static void calculation(Double area,Double perimetr){
        double length;
        double width;
        double discriminant = Math.pow((perimetr / 2), 2) - 4 * area;
        if (discriminant < 0 ){
            System.out.println("No solution");}
        else if (discriminant == 0){
            length = width = perimetr / 4;
            System.out.println("This is square length and width = "+ length );}
        else {
            width = ((perimetr / 2) + Math.sqrt(discriminant)) / 2;
            length = ((perimetr / 2) - Math.sqrt(discriminant)) / 2;
            System.out.println("This is rectangle \nlength = "+ length+"\nwidth = "+ width);
        }
    }
}


