package io4change;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class DataInEx {

   public static void main(String[] args) throws Exception {

      ServerSocket server = new ServerSocket(5555);
      System.out.println("ready server.....");

      Socket socket = server.accept();

      System.out.println("client connected...." + socket);
      
      OutputStream out = null;
      InputStream in = null;
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      
      
      String msg = dis.readUTF();
      
      System.out.println(msg);
      
      String dirName = "C:\\zzz\\MP3";

      File mp3Dir = new File(dirName);

      String[] songList = mp3Dir.list();


      
      // System.out.println(Arrays.toString(songList));

      StringBuilder builder = new StringBuilder();

      for (String title : songList) {
         builder.append(title + "|");
      }

      System.out.println(builder);

      String result = builder.toString();
      System.out.println(result);

      dos.writeUTF(result);
      dos.flush();
      
      String[] arr = result.split("\\|");
      
      for (String string : arr) {
         System.out.println(string);
      }

      String num = dis.readUTF();
      System.out.println(num);
      int a = Integer.parseInt(num);
      
      in = new FileInputStream("C:\\zzz\\mp3\\" + arr[a-1]);
      out = socket.getOutputStream();
      
      byte[] buffer = new byte[1024 * 8];
      
      while(true){
         int count = in.read(buffer);
         if(count == -1) { break; }
         out.write(buffer);
      }

      
      out.close();
      in.close();
      dos.close();
      dis.close();
      socket.close();
      server.close();

      /*
       * ServerSocket server = new ServerSocket(5555);
       * System.out.println("Ready server.......");
       * 
       * Socket socket = server.accept();
       * 
       * System.out.println("ClientConnected...." + socket);
       * 
       * DataOutputStream clientDos = new
       * DataOutputStream(socket.getOutputStream());
       * 
       * String title = "005 Çö¾Æ - »¡°³¿ä.mp3";
       * 
       * clientDos.writeUTF(title);
       * 
       * InputStream in = new FileInputStream("C:\\zzz\\005 Çö¾Æ - »¡°³¿ä.mp3");
       * 
       * byte[] buffer = new byte[1024 * 8];
       * 
       * while(true){ int count = in.read(buffer); if(count == -1){ break; }
       * clientDos.write(buffer,0,count); }
       * 
       * 
       * clientDos.close(); in.close();
       */

   }
}