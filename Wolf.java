
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
                    
                    catch (IOException ex) {
                        Logger.getLogger(Wolf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
        }
    }
    
    
    static class AcceptThread implements Runnable{

        ServerSocket sers;
        public AcceptThread(ServerSocket s){
            sers=s;
        }
        
        @Override
        public void run() {
            
                try{
                    while(szerverfut){
                        
                        
                        
                        Socket s=sers.accept();
                        
                        
                        sockets.add(s);
                        
                        Thread t=new Thread(new SocketListener(s));
                        
                        listenerthreads.add(t);
                        
                        t.start();
                        
                    }
                }catch(IOException e){
            
                }finally{
                    if(sers!=null) try {
                        sers.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Wolf.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
        }
    
    }
    
    public static void main(String[] args) {
        szerverfut=true;
        ServerSocket sers=null;
        Thread accepter=null;
        sockets=new ArrayList();
        listenerthreads=new ArrayList();
        
        try{
            sers=new ServerSocket(5555);
            
            accepter=new Thread(new AcceptThread(sers));
            accepter.start();
        }catch(IOException e){
            System.out.println(e.toString());
        }
        String str="";
        
        Scanner s=new Scanner(System.in);
        while(!str.equals("/end")){    
            str=s.nextLine();
            
            System.out.println(str);
            
        }
        
        szerverfut=false;
        
    }
    
}


