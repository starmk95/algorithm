// 프로그래머스 - 주차 요금 계산

import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] sttime = new int[10000];
        int[] times = new int[10000];
        
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(String s : records) {
            String[] tmp = s.split(" ");
            String[] tmp2 = tmp[0].split(":");
            int cn = Integer.parseInt(tmp[1]);
            int hour = Integer.parseInt(tmp2[0])*60;
            int minute = Integer.parseInt(tmp2[1]);
            if(tmp[2].equals("IN")) {
                sttime[cn] = hour+minute;
                set.add(cn);
                list.add(cn);
            }
            else {
                int st = sttime[cn];
                int end = hour+minute;
                sttime[cn] = 0;
                times[cn] += end-st;
                list.remove(Integer.valueOf(cn));
            }
        }
        for(int cn : list) {
            int st = sttime[cn];
            int end = 24*60-1;
            times[cn] += end-st;
        }
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int cn : set) {
            int time = times[cn];
            int cost = fees[1];
            time -= fees[0];
            if(time>0) {
                if(time%fees[2]==0) {
                    cost += (time/fees[2])*fees[3];
                } else {
                    cost += ((time/fees[2])+1)*fees[3];
                }
            }
            answer[idx] = cost;
            idx++;
        }
        return answer;
    }
}
