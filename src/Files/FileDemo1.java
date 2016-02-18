package Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


/**
 * @author jiaotd@asiainfo.com
 * @since 2016年1月6日 上午9:17:08
 */
public class FileDemo1 {
	
	/**
	 * 读取文件
	 * @author jiaotd@asiainfo.com
	 * @throws Exception 
	 * @since 2016年1月8日 上午9:25:46
	 */
	public static void readFile() throws Exception{
		// 管道
		FileChannel channel = FileChannel.open(Paths.get("/errorDate.txt"), StandardOpenOption.READ);
		// 建立字节缓冲区
		ByteBuffer bbf = ByteBuffer.allocate(1024);
		while(channel.read(bbf)!=-1){
			// 读写模式互换
			bbf.flip();
			System.out.print(new String(bbf.array(),0,bbf.limit()));
			bbf.clear();
		}
		channel.close();
	}
	
	public static void writeFile() throws Exception{
		Path absolute = Paths.get("/errorDate.txt");
		Files.write(absolute,"哈哈\r\n".getBytes(),StandardOpenOption.APPEND);
	}
	
	public static void selector() throws IOException{
		Selector selector = Selector.open();
		// 为了将Channel和Selector配合使用，必须将channel注册到selector上。通过SelectableChannel.register()方法来实现
	}
	
	public static void readAndWrite() throws Exception{
		FileInputStream in = new FileInputStream(new File("F:/errorDate.txt"));
		FileChannel fcin = in.getChannel();
		
		FileOutputStream out = new FileOutputStream(new File("F:/errorDate2.txt"));
		FileChannel fcout = out.getChannel();
		
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while(fcin.read(buffer) != -1){
			buffer.flip();
			fcout.write(buffer);
			buffer.clear();
		}
		
		out.close();
		in.close();
	}
	
	public static void main(String[] args) throws Exception {
//		readFile();
//		writeFile();
//		readFile();
//		demo();
		readAndWrite();
	}
	
	public static void demo() throws Exception{
		Path absolute = Paths.get("/errorDate.txt");
		Path relative = Paths.get("F:/config");
		System.out.println(absolute.toAbsolutePath()); 
		System.out.println(relative.toAbsolutePath()); 
		Files.write(absolute, "你好吗?\r\n".getBytes(),StandardOpenOption.APPEND);
		System.out.println("-------------------------------");
//		byte[] file = Files.readAllBytes(absolute);
//		String content = new String(file,"UTF8");
//		System.out.println(content);
//		System.out.println("-------------------------------------");
//		Files.copy(absolute, Paths.get("/aa.txt"),StandardCopyOption.REPLACE_EXISTING,StandardCopyOption.COPY_ATTRIBUTES);
//		System.out.println("------------------------------------");
//		Files.createDirectories(relative);
//		System.out.println("--------------------------------------");
//		Path temp = Files.createTempDirectory(relative,"");
//		System.out.println(Files.getOwner(absolute));
//		try(DirectoryStream<Path> entries = Files.newDirectoryStream(relative,"*.java")){
//			for(Path entry : entries){
//				System.out.println(entry.toAbsolutePath());
//			}
//		}
		System.out.println("---------------------------------------");
	
	}
}
