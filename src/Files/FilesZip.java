package Files;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author jiaotd@asiainfo.com
 * @since 2016年1月7日 下午4:57:15
 */
public class FilesZip {
	public static void main(String[] args) throws Exception {
		FileSystem fileSystem = FileSystems.newFileSystem(Paths.get("/config.zip"), null);
		Files.walkFileTree(fileSystem.getPath("/"), new SimpleFileVisitor<Path>(){
			// 啦啦啦啦
			//     ddddddddddddddddddddddddddddddddd
			@Override
			public FileVisitResult preVisitDirectory(Path paramT,BasicFileAttributes paramBasicFileAttributes) throws IOException {
				System.out.println(paramT);
				return FileVisitResult.CONTINUE;
			}
		});
	}
}	
