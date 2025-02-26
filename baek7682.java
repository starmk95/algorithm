// 백준 7682 - 틱택토

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        while(!s.equals("end")) {
            char[][] board = new char[3][3];
            int os = 0;
            int xs = 0;
            int blank = 0;
            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    board[i][j] = s.charAt(3*i+j);
                    if(board[i][j]=='X') xs++;
                    else if(board[i][j]=='O') os++;
                    else blank++;
                }
            }
            // o개수가 x개수보다 많거나 x개수가 o개수보다 2개 이상 많으면 invalid
            if(xs<os || xs-os>1) {
                bw.write("invalid\n");
                s = br.readLine();
                continue;
            }
            // 빙고 판별
            int[] bingo = new int[8];
            for(int i=0;i<3;i++) {
                if(board[i][0]==board[i][1] && board[i][0]==board[i][2] && board[i][0]!='.') {
                    if(board[i][0]=='X') bingo[i] = 1;
                    else bingo[i] = 2;
                }
            }
            for(int i=0;i<3;i++) {
                if(board[0][i]==board[1][i] && board[0][i]==board[2][i] && board[0][i]!='.') {
                    if(board[0][i]=='X') bingo[i+3] = 1;
                    else bingo[i+3] = 2;
                }
            }
            if(board[0][0]==board[1][1] && board[0][0]==board[2][2] && board[0][0]!='.') {
                if(board[0][0]=='X') bingo[6] = 1;
                else bingo[6] = 2;
            }
            if(board[0][2]==board[1][1] && board[0][2]==board[2][0] && board[0][2]!='.') {
                if(board[0][2]=='X') bingo[7] = 1;
                else bingo[7] = 2;
            }

            boolean xflag = false;
            boolean oflag = false;
            for(int i=0;i<8;i++) {
                if(bingo[i]==1) {
                    xflag=true;
                }
                if(bingo[i]==2) {
                    oflag=true;
                }
            }
            // x와 o가 동시에 빙고면 invalid
            if(xflag && oflag) {
                bw.write("invalid\n");
                s = br.readLine();
                continue;
            }
            // 빙고 없고 칸 다 안차있으면 invalid
            if(!xflag && !oflag && blank>0) {
                bw.write("invalid\n");
                s = br.readLine();
                continue;
            }
            // 칸 공유하지 않고 같은 문양 2빙고면 invalid
            // -> bingo 배열 기준 (0,2), (3,5)가 같은 값이면 안됨
            if(bingo[0]==bingo[2] && bingo[0]>0) {
                bw.write("invalid\n");
                s = br.readLine();
                continue;
            }
            if(bingo[3]==bingo[5] && bingo[3]>0) {
                bw.write("invalid\n");
                s = br.readLine();
                continue;
            }
            // x빙고인데 o개수랑 같으면 invalid
            if(xflag && xs==os) {
                bw.write("invalid\n");
                s = br.readLine();
                continue;
            }
            // o빙고인데 x개수가 더 많으면 invalid
            if(oflag && xs>os) {
                bw.write("invalid\n");
                s = br.readLine();
                continue;
            }

            // 다 통과하면 valid
            bw.write("valid\n");
            s = br.readLine();
        }
        bw.flush();
        bw.close();
    }
}
