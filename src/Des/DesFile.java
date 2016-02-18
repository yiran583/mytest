package Des;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author jiaotd@asiainfo.com
 * @since 2015年11月19日 下午4:35:50
 */
public class DesFile {
	public static void main(String[] args) throws Exception {
		RealNameMsDesPlus desPlus = new RealNameMsDesPlus("RNQDK");
		File inFile = new File("F:\\data03\\offline\\gztin\\BOSS998_BATCHVERIF201510251036597_10085_C321in");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "UTF-8"));
		File outFile = new File("F:\\data03\\offline\\gztin\\BOSS998_BATCHVERIF201510251036597_10085_C321");
		BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
//		PrintWriter write = new PrintWriter(outFile);

		String line = "";
		while ((line = reader.readLine()) != null) {
			write.write(desPlus.encrypt(line));
			write.newLine();
		}

		write.close();
		reader.close();
	}
}
