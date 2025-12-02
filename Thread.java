// import java.io.*;
// import java.util.*;

// class MyThread implements Runnable{
    
//   	// Method to start Thread
//     public void run(){
        
//       	String str = "Thread is Running Successfully";
//         System.out.println(str);
//     }

// }

// public class Geeks{
    
//     public static void main(String[] args){
        
//         MyThread g1 = new MyThread();
      
//         // initializing Thread Object
//         Thread t1 = new Thread(g1);
        
//       	// Running Thread
//       	t1.start();
//     }
// }

import java.io.*;
import java.util.*;

class MyThread extends Thread{
    
    // initiated run method for Thread
    public void run(){
        
      	String str = "Thread Started Running...";
        System.out.println(str);
    }
}

public class Geeks{
    
  	public static void main(String args[]){
  	    
      	MyThread t1 = new MyThread();
      	t1.start();
    }
}