package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by fdh on 2017/9/7.
 */
public class Server {
    static class ClientThread implements Runnable {
        private Socket socket;

        public ClientThread(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            InputStream is = null;
            try {
                is = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);

                String info = null;
                if ((info = br.readLine()) != null) {
                    System.out.println("客户端信息为：" + info);
                }

                socket.shutdownInput();
                OutputStream os = socket.getOutputStream();
                PrintWriter pw = new PrintWriter(os);
                pw.write("welcome!");
                pw.flush();
                is.close();
                isr.close();
                br.close();
                os.close();
                pw.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        ExecutorService pool = Executors.newCachedThreadPool();
        while (true) {
            Socket socket = serverSocket.accept();
            pool.submit(new ClientThread(socket));
        }

    }
}
