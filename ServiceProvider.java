
package practice1;
import java.rmi.*;

//here service provider is interface that consist
//list of method,these method will be used by server 
//to provide different services

public interface ServiceProvider extends Remote  {
    
    int findSum(int x, int y)throws Exception;
   String reverseData(String res) throws RemoteException;
   
   //third services: take one data as input from user
   //and return wheher that no is prime or not
   String findPrime(int x) throws Exception;
}