package io4change;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class DataOutEx {
   // bad code
   public static void main(String[] args) throws Exception {

      Socket socket = new Socket("192.168.0.77", 5555);

//      DataInputStream din = new DataInputStream(socket.getInputStream());

      DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
      DataInputStream dis = new DataInputStream(socket.getInputStream());
      InputStream in = socket.getInputStream();
      OutputStream out = null;
//      InputStream in = socket.getInputStream();
      
      String msg = "¸®½ºÆ®";
      
      dos.writeUTF(msg);
      
      dos.flush();
      
      String songList = dis.readUTF();
      
      String[] arr = songList.split("\\|");
      int i = 0;
      for (String string : arr) {

         System.out.println(++i + string);
      }
      
      String num = "1";
      int a = Integer.parseInt(num);
      
      dos.writeUTF(num);
      
      byte[] buffer = new byte[1024 * 8];
      out = new FileOutputStream("C:\\zzz\\mp3\\copy_" + arr[a-1]);
      
      while(true){
         int count = in.read(buffer);
         if(count == -1){ break; }
         out.write(buffer,0,count);
      }
      
      out.flush();
      out.close();
      in.close();
      dos.close();
      dis.close();
      socket.close();
      
      
      
      
      
      
      
      
      
      
      /*
      
      String title = din.readUTF();
      System.out.println(title);

      FileOutputStream fos = new FileOutputStream("C:\\zzz\\copy_" + title);
      
      byte[] buffer = new byte[1024*8];
      
      while(true){
         int count = din.read(buffer);
         if(count==-1){break;}
         fos.write(buffer, 0, count);
      }*/
      
   }
}