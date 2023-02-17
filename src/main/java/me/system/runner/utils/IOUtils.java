
package me.system.runner.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.URL;

public class IOUtils {
    public static byte[] readRemoteData(String location) throws IOException {
        byte[] bytes;
        URL url = new URL(location);
        try (InputStream is2 = url.openStream();){
            bytes = IOUtils.toByteArray(is2);
        }
        return bytes;
    }

    public static byte[] toByteArray(InputStream is2) throws IOException {
        byte[] bytes;
        try (ByteArrayOutputStream buffer = new ByteArrayOutputStream();){
            int nRead;
            byte[] data = new byte[16384];
            while ((nRead = is2.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }
            buffer.flush();
            bytes = buffer.toByteArray();
        }
        return bytes;
    }

    public static int getPortUsage(int port) {
        Throwable throwable;
        boolean tcp = false;
        boolean udp = false;
        try {
            throwable = null;
            try (ServerSocket ss2 = new ServerSocket(port);){
                ss2.setReuseAddress(true);
                tcp = true;
            }
            catch (Throwable throwable2) {
                throwable = throwable2;
                throw throwable2;
            }
        }
        catch (Exception ss2) {
            
        }
        try {
            throwable = null;
            try (DatagramSocket ds2 = new DatagramSocket(port);){
                ds2.setReuseAddress(true);
                udp = true;
            }
            catch (Throwable throwable3) {
                throwable = throwable3;
                throw throwable3;
            }
        }
        catch (Exception exception) {
            
        }
        if (tcp && udp) {
            return 3;
        }
        if (udp) {
            return 2;
        }
        if (tcp) {
            return 1;
        }
        return 0;
    }

    public static void copyStream(InputStream input, OutputStream output) throws IOException {
        int bytesRead;
        byte[] buffer = new byte[1024];
        while ((bytesRead = input.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
    }

    public static String getText(InputStream stream, String charset) throws IOException {
        return new String(IOUtils.toByteArray(stream), charset);
    }
}

