/**
 * 打印五种星号组成的形状
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Please input the max star num of one line:");
        Scanner scanner=new Scanner(System.in);
   //     int starNum=scanner.nextInt();
        int starNum=scanner.nextInt();
        //*
        //**
        //***
       for (int i=0;i<starNum;i++)
        {
            for (int j=0;j<=i;j++)
            {
                System.out.print('*');
            }
            System.out.println();
        }
        //***
        //**
        //**

        for (int i=0;i<starNum;i++)
        {
            for (int j=starNum;j>i;j--)
            {
                System.out.print('*');
            }
            System.out.println();
        }
        //  *
        // **
        //***
        for (int i=0;i<starNum;i++)
        {
            for (int j=i;j<starNum-1;j++)
            {
                System.out.print(' ');
            }
            for (int j=0;j<=i;j++)
            {
                System.out.print('*');
            }
            System.out.print('\n');
        }
        //***
        // **
        //  *
        for (int i=0;i<starNum;i++)
        {
            for (int j=0;j<i;j++)
            {
                System.out.print(' ');
            }
            for (int j=i+1;j<=starNum;j++)
            {
                System.out.print('*');
            }
            System.out.print('\n');
        }
        // *
        //***
        //starNum为偶数时，最大行的*数量是starNum+1
        for (int i = 0; i < starNum/2+1; i++) {
            for (int j = starNum/2; j>i; j--){
                System.out.print(' ');
            }
            for (int j = 0; j<=2*i;j++){
                System.out.print('*');
            }
            for (int j = starNum/2; j>i; j--){
                System.out.print(' ');
            }
            System.out.println();
        }


    }
}
