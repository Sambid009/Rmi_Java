//package practice1;
////RMI stands for remote method invocation
////in which one object can invoke
////method of other object running in another JVM.
////it includes three part: remote object,
////stub (client); skeleton(server)
////stub is gateway for cliebt from which services are request with server
////stub sends needed parameter to server
//
////skeleton is refer as server which invoke remote object and 
////provide services to client object. it sends need parameter to stub known as marshalling
//
//
//import java.rmi.*;
//import java.rmi.registry.*;
//import java.util.*;
//import java.rmi.server.*;
//
//
//
//
//
//public class server extends UnicastRemoteObject implements  ServiceProvider {
//    //this constructor is created as we have inherit unicast remote object and it throws remote exception 
//    //if remote object is not found
//    //service provider is interface that consist list of method to provide different services from server
//    
//    public   server() throws RemoteException{
//        
//        
//    }
//    //service provided by server: method
//    
//    @Override
//    public int findSum(int x,int y){
//        return (x+y);
//    }
//    
//    // Service provided by server: method to reverse string
//    @Override
//    public String reverseData(String res) {
//        return new StringBuilder(res).reverse().toString();
//    }
//    
//    
//    
//    
//    public static void main(String[] args) {
//        //configuring server
//        //reggistering serverwith specific code
//        
//        try{
//            
//             Registry reg = LocateRegistry.createRegistry(7779);
//             
//             //binding server with port
//             reg.rebind("primeserver", new server() );
//             System.out.println("server ready for serving");            
//            
//        }catch(RemoteException e){
//            System.out.println(e);
//            
//        }
//       
//        
//        
//        
//        
//        
//        
//    }
//
//}

package practice1;

import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;

public class server extends UnicastRemoteObject implements ServiceProvider {
    // Constructor
    public server() throws RemoteException {
        super();
    }

    // Service provided by server: method to find sum
    @Override
    public int findSum(int x, int y) {
        return (x + y);
    }

    // Service provided by server: method to reverse string
    @Override
    public String reverseData(String res) {
        return new StringBuilder(res).reverse().toString();
    }
    
    //------------------------
    @Override
    public String findPrime(int x ){
        int temp =0;
        for(int i=1 ; i<=x; i++){
            if (x%i==0){
                temp ++;
            }
            
        }
        if(temp == 2){
            return "The number you send is Prime";
        }else{
            return "Not Prime";
        }
    }

    public static void main(String[] args) {
        // Configuring server
        try {
            Registry reg = LocateRegistry.createRegistry(7779);

            // Binding server with port
            reg.rebind("primeserver", new server());
            System.out.println("server ready for serving");
        } catch (RemoteException e) {
            System.out.println(e);
        }
    }
}
