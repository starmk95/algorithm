// 백준 7490번 - 0 만들기

import java.util.*;
import java.io.*;

class Main {
    static int n;
    static List<String> list;
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            dfs(1, "");
            for(String s : list) {
                bw.write(s);
                bw.write("\n");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    static public void dfs(int idx, String cur) {
        if(idx==n) {
            Deque<String> dq = new LinkedList<>();
            dq.offerFirst("1");
            for(int i=0;i<cur.length();i++) {
                if(cur.charAt(i)=='+') {
                    dq.offerLast("+");
                    dq.offerLast(String.valueOf(i+2));
                } else if(cur.charAt(i)=='-') {
                    dq.offerLast("-");
                    dq.offerLast(String.valueOf(i+2));
                }
                else {
                    String tmp = dq.pollLast();
                    tmp += String.valueOf(i+2);
                    dq.offerLast(tmp);
                }
            }
            int result = Integer.parseInt(dq.pollFirst());
            while(!dq.isEmpty()) {
                String tmp = dq.pollFirst();
                if(tmp.equals("+")) {
                    result+=Integer.parseInt(dq.pollFirst());
                }
                else if(tmp.equals("-")) {
                    result-=Integer.parseInt(dq.pollFirst());
                }
            }
            if(result==0) {
                StringBuilder sb = new StringBuilder();
                sb.append("1");
                for(int i=0;i<cur.length();i++) {
                    sb.append(cur.charAt(i));
                    sb.append(String.valueOf(i+2));
                }
                list.add(sb.toString());
            }
            return;
        }
        dfs(idx+1, cur+" ");
        dfs(idx+1, cur+"+");
        dfs(idx+1, cur+"-");
    }
}
