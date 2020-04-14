/**
 * 1. Написать программу по возведению числа в степень с помощью рекурсии.
 */
public class Degree {
    public static void main(String[] args) {
        System.out.println("2^4 = " + degree(2,4));
        System.out.println("4^3 = " + degree(4,3));
        System.out.println("12^0 = " + degree(12,0));
        System.out.println("2^-2 = " + degree(2,-2));

    }

    public static double degree(int base, int exp){
        if(exp == 0){
            return 1;
        }else if(exp < 0){
            return (double)1/(base*degree(base,(-1) * exp - 1));
        }
        return base * degree(base,exp - 1);
    }
}
