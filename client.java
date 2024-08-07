 
package practice1;

 import java.rmi.*;
import java.rmi.registry.*;
import java.util.*;

public class client {
    
    public static void main(String[] args)throws Exception {
        //connecting with server with specific code
        
        try{
            Registry creg = LocateRegistry.getRegistry(7779);
            
            ServiceProvider s = (ServiceProvider)creg.lookup("primeserver");
            
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter 2 numbers");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            
           
            int ans  =  s.findSum(num1, num2);
            System.out.println("The sum is "+ ans);
            
            
                        // Reverse string operation
            sc.nextLine(); // Consume the newline character
            System.out.println("Enter a string to reverse:");
            String str = sc.nextLine();
            String reversed = s.reverseData(str);
            System.out.println("The reversed string is " + reversed);
            
            //---------------Prime or not Check-----------------
            //sc.nextLine();
            System.out.println("---Third Service---");
            System.out.println("Enter any number to check prime or not");
            int num3 = sc.nextInt();
           
            String ans2 = s.findPrime(num3);
            System.out.println(ans2);
            
            
        }catch(RemoteException r){
            System.out.println(r);
            
        }catch(NotBoundException c){
            System.out.println(c);
            
        }
        
    }
    
}
