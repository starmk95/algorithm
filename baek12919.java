import java.util.*;
import java.io.*;
/*
    백준 12919번 - A와 B 2
    
    T에서 S로 줄여나가는 방법으로 해야 가지치기가 가능
    제거하는 방법으로 하면 마지막자리가 A인 경우와, 첫번째 자리가 B인 경우만 고려하면 됨
    반면, S에서 T로 합쳐나가는 방식으로 하면 모든 경우의 수를 고려해야됨

    String은 불변 개체이기 때문에, String 연산을 하면 새로운 String 객체가 생성됨
    반면, StringBuilder는 가변객체이기 떄문에 하나의 객체에서 연산을 할 수 있음
    때문에 문자열 연산을 할 때에는 StringBuilder를 사용하는 것이 유리

    모든 경우를 고려하는 Brute Force 형식의 문제이되, 가지치기를 잘 하는 것이 중요
*/


class Main {
    static String S;
    static String T;
    static int answer;
	static public void main(String []args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();
        answer = 0;
        dfs(T);
        System.out.print(answer);
    }

    static public void dfs(String t) {
        if(t.length() == S.length()) {
            if(S.equals(t)) {
                answer = 1;
            }
            return;
        }
        if(t.length() < S.length()) {
            return;
        }
        if(t.charAt(t.length()-1) == 'A') {
            dfs(t.substring(0,t.length()-1));
        }
        if(t.charAt(0) == 'B') {
            dfs(new StringBuilder(t.substring(1, t.length())).reverse().toString());
        }
    }
}
