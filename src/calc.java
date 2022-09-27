import java.util.Scanner;

public class calc
{
    public static void main(String[] args)
    {
        String stringnum1;
        String stringnum2;
        int num1=0;
        int num2=0;
        int num3;
        char znak;
        int romam1=0;
        int romam2=0;
        Scanner in = new Scanner(System.in);
        ///////////////////////////////////////////////////////////////////////////////////
        do
        {
            System.out.println("Первое число");
            stringnum1 = in.next();
            stringnum1=stringnum1.toUpperCase();
            int indexI =stringnum1.indexOf('I');
            int indexV =stringnum1.indexOf('V');
            int indexX =stringnum1.indexOf('X');
            if(indexI!=-1||indexV!=-1||indexX!=-1)
            {
                romam1=1;
                int i=0;
                int current=0;
                int previous=0;
                int arabic=0;
                while (i<stringnum1.length())
                {
                    char letter= stringnum1.charAt(i);
                    switch (letter)
                    {
                        case ('I'):
                            current = 1;
                            break;
                        case ('V'):
                            current = 5;
                            break;
                        case ('X'):
                            current = 10;
                            break;
                    }
                    if (current > previous)
                    {
                        arabic += current - (previous * 2);
                    }
                    else
                    {
                        arabic += current;
                    }
                    previous = current;
                    i += 1;
                }
                num1=arabic;
            }
            else if (isNumeric(stringnum1))
            {
                romam1=0;
                num1=Integer.parseInt(stringnum1);
            }
        } while (!(num1>-11 && num1<11));
        ///////////////////////////////////////////////////////////////////////////////////

        do {
            System.out.println("Знак");
            znak= in.next().charAt(0);
        } while (!(znak=='+'||znak=='-'||znak=='*'||znak=='/'));

        ///////////////////////////////////////////////////////////////////////////////////
        do
        {
            System.out.println("Второе число");
            stringnum2 = in.next();
            stringnum2 = stringnum2.toUpperCase();
            int indexI =stringnum2.indexOf('I');
            int indexV =stringnum2.indexOf('V');
            int indexX =stringnum2.indexOf('X');
            if((indexI!=-1||indexV!=-1||indexX!=-1))
            {
                romam2=1;
                int i=0;
                int current=0;
                int previous=0;
                int arabic=0;
                while (i<stringnum2.length())
                {
                    char letter= stringnum2.charAt(i);
                    switch (letter)
                    {
                        case ('I'):
                            current = 1;
                            break;
                        case ('V'):
                            current = 5;
                            break;
                        case ('X'):
                            current = 10;
                            break;
                    }
                    if (current > previous)
                    {
                        arabic += current - (previous * 2);
                    }
                    else
                    {
                        arabic += current;
                    }
                    previous = current;
                    i += 1;
                }
                num2=arabic;
            }
            else if ((isNumeric(stringnum2)))
            {
                romam2=0;
                num2=Integer.parseInt(stringnum2);
            }
        } while (!(num2>-11 && num2<11 && romam1==romam2));
        ///////////////////////////////////////////////////////////////////////////////////
        if(znak!='/' && num2!=0)
        {
            num3 = switch (znak) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num1 / num2;
                default -> 0;
            };
            if(isNumeric(stringnum1))
            {
                System.out.println("Ответ "+num1+znak+num2+"="+num3);
            }
            else
            {
                System.out.println("Ответ "+stringnum1+znak+stringnum2+"="+convert(num3));
            }
        }
        else {System.out.println("pizdec");}

    }
    public static boolean isNumeric(final String stringnum1)
    {
        if (stringnum1 == null || stringnum1.length() == 0) {
            return false;
        }

        try {

            Integer.parseInt(stringnum1);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static String romanDigit(int n, String one, String five, String ten){

        if(n >= 1)
        {
            if(n == 1)
            {
                return one;
            }
            else if (n == 2)
            {
                return one + one;
            }
            else if (n == 3)
            {
                return one + one + one;
            }
            else if (n==4)
            {
                return one + five;
            }
            else if (n == 5)
            {
                return five;
            }
            else if (n == 6)
            {
                return five + one;
            }
            else if (n == 7)
            {
                return five + one + one;
            }
            else if (n == 8)
            {
                return five + one + one + one;
            }
            else if (n == 9)
            {
                return one + ten;
            }

        }
        return "";
    }
    public static String convert(int number){

        String romanOnes = romanDigit( number%10, "I", "V", "X");
        number /=10;
        String romanTens = romanDigit( number%10, "X", "L", "C");
        number /=10;
        String romanHundreds = romanDigit(number%10, "C","","");

        String result = romanHundreds + romanTens + romanOnes;
        return result;

    }
}
