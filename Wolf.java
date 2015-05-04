
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;






/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author shadowwolf
 */
public class Wolf{

    static boolean szerverfut;
    static ArrayList<Socket> sockets;
    static ArrayList<Thread> listenerthreads;
    
    
    static class SocketListener implements Runnable{
    
        Socket sock;
        BufferedReader in;
        String buffer;
        
        public SocketListener(Socket s) throws IOException{
            sock=s;
            
            in=new BufferedReader(new InputStreamReader(sock.getInputStream()));
            
        }
        
        @Override
        public void run() {
            //System.out.println("vanilyen");
            
                //System.out.println("ciklus3");
                try {
                    while(szerverfut){
                        buffer=in.readLine();
                        if(buffer==null) break;
                        System.out.println(buffer);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Wolf.class.getName()).log(Level.SEVERE, null, ex);
                }finally{
                    try {
                        sock.close();
                        in.close();
                    }
                    //System.out.println("ciklus4");
                    catch (IOException ex) {
                        Logger.getLogger(Wolf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            System.out.println("Socketlistener lefutott");    
        }
    }
    
    
    static class AcceptThread implements Runnable{

        ServerSocket sers;
        public AcceptThread(ServerSocket s){
            sers=s;
        }
        
        @Override
        public void run() {
            //System.out.println("vanilyenis");
                try{
                    while(szerverfut){
                        //System.out.println("ciklus1");
                        
                        
                        Socket s=sers.accept();
                        
                        //System.out.println("acceptálva");
                        sockets.add(s);
                        //System.out.println("addolva");
                        Thread t=new Thread(new SocketListener(s));
                        //System.out.println("Listener létrehozva");
                        listenerthreads.add(t);
                        //System.out.println("Listener hozzáadva");
                        t.start();
                        //System.out.println("ciklus2");
                    }
                }catch(IOException e){
            
                }finally{
                    if(sers!=null) try {
                        sers.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Wolf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            System.out.println("Accepter lefutott");
        }
    
    }
    
    public static void main(String[] args) {
        szerverfut=true;
        ServerSocket sers=null;
        Thread accepter=null;
        sockets=new ArrayList();
        listenerthreads=new ArrayList();
        //System.out.println("Listeners:"+listenerthreads.size());
        try{
            sers=new ServerSocket(5555);
            
            accepter=new Thread(new AcceptThread(sers));
            accepter.start();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        String str="";
        //System.out.println("Listeners:"+listenerthreads.size());
        Scanner s=new Scanner(System.in);
        while(!str.equals("/end")){    
            str=s.nextLine();
            //if(str.equals("//end")) break;
            System.out.println(str);
            System.out.println("Pedig ez jó baszod!!!!!!");
        }
        System.out.println("lefutott");
        szerverfut=false;
        
    }
    
}


