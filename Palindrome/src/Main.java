/**
 *测试一个字符串是否是回文，字符串中间不包含空白字符
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String testString=scanner.nextLine();

        if (IsPalindrome(testString)) {
            System.out.println("It is palindrome");
        }
        else{
            System.out.println("It is not palindrome");
        }

    }
    static boolean IsPalindrome(String str)
    {
        if (str.isEmpty())
        {
            System.out.println("Input is empty");
        }

        int left=0;
        int right=str.length()-1;

        while(left<right && str.charAt(left)==str.charAt(right))
        {
            left++;
            right--;
        }

        if(left==right) {
            return true;
        }else{
            return false;
        }
    }
}
