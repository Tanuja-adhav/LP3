import java.util.*;
class Recursion{
    //recursive
    public static int fib(int n){
        if(n==1 ){
            return n;
        }
        if (n==0){
            return n;
        }
        int  fnm1=fib(n-1);
        int fnm2 =fib(n-2);
        int fn=fnm1+fnm2;
        return fn;
    }
    //non-recursive
    public static int fibonacci(int n){
        int fn0=0;
        int fn1=1;
        int fn=0;
        for(int i=1;i<n;i++){
            fn = fn0+fn1;
            fn0=fn1;
            fn1=fn;
        }
        return fn;
    }
    public static void main(String[] args) {
        System.out.println("Enter no: ");
        Scanner sc=new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println("nth no of fibonacci is:"+fib(n));
        System.out.println("nth no of fibonacci is:"+fibonacci(n));

    }
}