// 백준 1253번 - 좋다

import java.util.*;
import java.io.*;

class Main {
	static public void main(String []args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long[] nums = new long[n];
        int cnt = 0;
        for(int i=0;i<n;i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(nums);
        // 정렬 한 후, 투 포인터 방식 사용
        for(int i=0;i<n;i++) {
            int left = 0;
            int right = n-1;
            while(left<right) {
                if(left==i) {
                    left++;
                    continue;
                }
                if(right==i) {
                    right--;
                    continue;
                }
                long sum = nums[left]+nums[right];
                if(sum==nums[i]) {
                    cnt++;
                    break;
                }
                else if(sum<nums[i]) left++;
                else right--;
            }
        }
        System.out.print(cnt);
    }
}
