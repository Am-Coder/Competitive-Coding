package com.comp.hearth;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.*;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
 
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        */
 
        //Scanner
        Print p = new Print();
        Scan s = new Scan();
        int N = s.nextInt();
        int X = s.nextInt();
        Queue<PositionValue> q = new ArrayDeque<PositionValue>();
        Queue<PositionValue> q2 = new ArrayDeque<PositionValue>();
 
        for (int i = 0; i < N; i++) {
            int value = s.nextInt();
            PositionValue x = new PositionValue(i, value);
            q.add(x);
        }
 
        for (int i = 0; i < X; i++) {
            PositionValue maxValue = null;
            for (int j = 0; j < X; j++) {
                if (q.isEmpty()) {
                    break;
                }
                PositionValue currentValue = q.remove();
                if (maxValue == null || currentValue.value > maxValue.value) {
                    maxValue = currentValue;
                }
                q2.add(currentValue);
            }
            while (!q2.isEmpty()) {
                PositionValue currentValue = q2.remove();
                if (currentValue != maxValue) {
                    if (currentValue.value != 0) {
                        currentValue.value--;
                    }
                    q.add(currentValue);
                }
            }
            if (maxValue == null) {
                break;
            }
            if (i != 0) {
                p.print(" ");
            }
            p.print("" + (maxValue.position + 1));
        }
 
        p.close();
    }
}
 
class PositionValue {
    int position;
    int value;
    PositionValue(int position, int value) {
        this.position = position;
        this.value = value;
    }
}
 
class Scan {
    private byte[] buf=new byte[1024];
    private int index;
    private InputStream in;
    private int total;
    public Scan() {
        in=System.in;
    }
 
    public int next()throws IOException {
        if(total<0) {
            throw new InputMismatchException();
        }
        if(index>=total) {
            index=0;
            total=in.read(buf);
            if(total<=0) {
                return -1;
            }
        }
        return buf[index++];
    }
 
    public int nextInt()throws IOException {
        int integer=0;
        int n=next();
        while(isWhiteSpace(n)) {
            n=next();
        }
        int neg=1;
        if(n=='-') {
            neg=-1;
            n=next();
        }
        while(!isWhiteSpace(n)) {
            if(n>='0'&&n<='9') {
                integer*=10;
                integer+=n-'0';
                n=next();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
 
    public long nextLong()throws IOException {
        long integer=0;
        int n=next();
        while(isWhiteSpace(n)) {
            n=next();
        }
        int neg=1;
        if(n=='-') {
            neg=-1;
            n=next();
        }
        while(!isWhiteSpace(n)) {
            if(n>='0'&&n<='9') {
                integer*=10;
                integer+=n-'0';
                n=next();
            }
            else throw new InputMismatchException();
        }
        return neg*integer;
    }
 
    public double nextDouble()throws IOException {
        double doub=0;
        int n=next();
        while(isWhiteSpace(n))
            n=next();
        int neg=1;
        if(n=='-') {
            neg=-1;
            n=next();
        }
        while(!isWhiteSpace(n)&&n!='.') {
            if(n>='0'&&n<='9') {
                doub*=10;
                doub+=n-'0';
                n=next();
            }
            else throw new InputMismatchException();
        }
        if(n=='.') {
            n=next();
            double temp=1;
            while(!isWhiteSpace(n)) {
                if(n>='0'&&n<='9') {
                    temp/=10;
                    doub+=(n-'0')*temp;
                    n=next();
                }
                else throw new InputMismatchException();
            }
        }
        return doub*neg;
    }
 
    public String nextString()throws IOException {
        StringBuilder sb=new StringBuilder();
        int n=next();
        while(isWhiteSpace(n)) {
            n=next();
        }
        while(!isWhiteSpace(n)) {
            sb.append((char)n);
            n=next();
        }
        return sb.toString();
    }
 
    public byte[] nextBytes(int N)throws IOException {
        byte[] bytes = new byte[N];
        int diff = total-index;
        int i=index;
        for (;i<total && i-index < N; i++) {
            bytes[i-index] = buf[i];
        }
        index = i;
        if (diff >= N) {
            return bytes;
        }
        in.read(bytes, diff, N-diff);
        return bytes;
    }
 
    public boolean nextBoolean() throws IOException {
        int integer=0;
        int n=next();
        while(isWhiteSpace(n)) {
            n=next();
        }
        return n == '1';
    }
 
    public int nextByteAsIntWithoutWhitespace() throws IOException {
        int n=next();
        while(isWhiteSpace(n)) {
            n=next();
        }
        return n;
    }
 
    private boolean isWhiteSpace(int n) {
        if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1) {
            return true;
        }
        return false;
    }
}
 
class Print {
    private final BufferedWriter bw;
    public Print() {
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
    }
    public void print(String str)throws IOException {
        bw.append(str);
    }
    public void printLine(String str)throws IOException {
        print(str);
        bw.append("\n");
    }
    public void close()throws IOException {
        bw.close();
    }
}