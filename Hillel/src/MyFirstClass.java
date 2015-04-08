/**
 * Created by IDavydhuk on 03.04.2015.
 */
public class MyFirstClass {
    public static void main(String[] params) {
        // comments
        greeting();
        age();
        double height = 172;
        double weight = 89;

        double ratio = weight/height;
        System.out.println(ratio);

    }
    public static void age() {
        String a = "Hello World";
        String greeting = "My name is";
        String name = "Igor";
        String result = greeting + " 45 " +name;

        int age = 38;
        long age2 = 155;
        System.out.println(a + greeting);
    }

    public static void greeting(){
        String a = "Hello World";
        String greeting = "My name is";
        String name = "Igor";
        String result = greeting + " 45 " +name;

        int age = 38;
        long age2 = 155;
        System.out.println(result + " "+ age+ " or "+age2);

    }
}
