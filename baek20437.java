// 백준 20437번 - 문자열 게임 2

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int[] cnt = new int[26];
            ArrayList<Integer>[] index = new ArrayList[26];
            for(int i=0;i<26;i++) index[i] = new ArrayList<>();
            for(int i=0;i<w.length();i++) {
                char c = w.charAt(i);
                cnt[c-'a']++;
                index[c-'a'].add(i);
            }
            int answer1 = -1;
            int answer2 = -1;
            for(int i=0;i<26;i++) {
                int stmp = -1;
                int ltmp = -1;
                if(cnt[i]>=k) {
                    for(int j=k-1;j<index[i].size();j++) {
                        if(stmp==-1) {
                            stmp = index[i].get(j)-index[i].get(0)+1;
                        }
                        else {
                            stmp = Math.min(stmp, index[i].get(j)-index[i].get(j-(k-1))+1);
                        }
                        ltmp = Math.max(ltmp, index[i].get(j)-index[i].get(j-(k-1))+1);
                    }
                    if(answer1==-1) answer1 = stmp;
                    else answer1 = Math.min(answer1, stmp);
                    if(answer2==-1) answer2 = ltmp;
                    else answer2 = Math.max(answer2, ltmp);
                }
            }
            if(answer1==-1||answer2==-1) {
                bw.write("-1\n");
            }
            else {
                bw.write(answer1 + " " + answer2 + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
