package socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by fdh on 2017/9/7.
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost",10086);
        OutputStream os = socket.getOutputStream();
        PrintWriter pw = new PrintWriter(os);
        pw.write("I'm client");
        pw.flush();
        socket.shutdownOutput();

        InputStream is = socket.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println(info);
        }

        br.close();
        os.close();
        pw.close();
        is.close();
        isr.close();
        br.close();
        socket.close();
    }
}
