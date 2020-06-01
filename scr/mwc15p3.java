import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

import java.util.*;

class mwc15p3 {
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static String next() throws IOException{
		while(st==null||!st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}
	static int readInt() throws IOException{
		return Integer.parseInt(next());
	}
	
	public static void main(String[] args) throws IOException {
		Map freq = new HashMap();
		int dolls = readInt();
		for (int i = 0; i < dolls; i++) {
			int temp = readInt();
			freq.put(temp, (int)freq.get(temp) + 1);
		}
	}
	
}
