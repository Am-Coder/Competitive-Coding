import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class hi {
	
	static class cl{
		
		
		int a;
		int b;
		public cl(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}
		
		
	}
    public static void main(String[] args) throws IOException 
    { 
    	PrintWriter p = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in)); 
  
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        System.out.println(st.countTokens());

        int n = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 
        br.readLine();
        System.out.println(st.countTokens());
        int count = 0; 
        while (n-- > 0) 
        { 
            int x = Integer.parseInt(br.readLine()); 
            if (x%k == 0) 
               count++; 
        } 
        System.out.println(count); 
    } 
}
