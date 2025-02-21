// 프로그래머스 - 가장 큰 정사각형 찾기

class Solution
{
    public int solution(int [][]board)
    {
        int answer = 0;
        int n = board.length;
        int m = board[0].length;
        int[][] cnt = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(i==0||j==0) cnt[i][j] = board[i][j];
                else {
                    if(board[i][j]==0) continue;
                    int tmp = Math.min(cnt[i-1][j], cnt[i][j-1]);
                    cnt[i][j] = Math.min(tmp, cnt[i-1][j-1])+1;
                }
                answer = Math.max(cnt[i][j], answer);
            }
        }
        return answer*answer;
    }
}
