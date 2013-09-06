package com.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class TestNio {
	private static Charset charset = Charset.forName("gbk");// 创建GBK字符集  
	
	private static long startTime = 0L;
	private static long consumeTime = 0L;

	
	public static void copyFile(){
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\yunpeng_xu\\Documents\\My Received Files\\许云鹏.zip");
			FileOutputStream fos = new FileOutputStream("C:\\Users\\yunpeng_xu\\Documents\\My Received Files\\许云鹏copy.zip");
			FileChannel fcin = fis.getChannel();
			FileChannel fcout = fos.getChannel();
			
			//1.ByteBuffer 300ms
			TestNio.startTime();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(fcin.read(buffer) != -1){
				buffer.flip();
				fcout.write(buffer);
				buffer.clear();
			}
			TestNio.consumeTime();
			
			//2.transferTo 20ms
//			TestNio.startTime();
//			fcin.transferTo(0, fcin.size(), fcout);
//			TestNio.consumeTime();
			
			//3.transferFrom 20ms
//			TestNio.startTime();
//			fcout.transferFrom(fcin, 0, fcin.size());
//			TestNio.consumeTime();
			
			//4.MappedByteBuffer 16ms
//			TestNio.startTime();
//			MappedByteBuffer mappedByteBuffer = fcin.map(FileChannel.MapMode.READ_ONLY, 0, fcin.size());
//			fcout.write(mappedByteBuffer);
//			TestNio.consumeTime();
			
			//5.byte[]	150ms
//			TestNio.startTime();
//			byte[] buffer = new byte[1024];
//			int flag = 0;
//			while((flag = fis.read(buffer)) != -1){
//				fos.write(buffer, 0, flag);
//			}
//			TestNio.consumeTime();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void startTime(){
		startTime = System.currentTimeMillis();
	}
	
	
	private static void consumeTime(){
		consumeTime = System.currentTimeMillis() - startTime;
		System.out.println(consumeTime + "ms");
	}
	
	private static void readHTMLContent() {
		SocketChannel channel = null;
        try {  
            InetSocketAddress socketAddress = new InetSocketAddress("220.181.111.147", 80);  
            //step1:打开连接  
            channel = SocketChannel.open(socketAddress);  
            //step2:发送请求，使用GBK编码  
            channel.write(charset.encode("GET " + "/ HTTP/1.1" + "\r\n\r\n"));  
            //step3:读取数据  
            ByteBuffer buffer = ByteBuffer.allocate(1024);// 创建1024字节的缓冲  
            while (channel.read(buffer) != -1) {  
                buffer.flip();// flip方法在读缓冲区字节操作之前调用。  
                System.out.println(charset.decode(buffer));  
                // 使用Charset.decode方法将字节转换为字符串  
                buffer.clear();// 清空缓冲  
            }  
        } catch (IOException e) {  
        } finally {  
            if (channel != null) {  
                try {  
                    channel.close();  
                } catch (IOException e) {  
                }  
            }  
        }  
    }  
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		TestNio.copyFile();100000
//		TestNio.readHTMLContent();
	}
}
