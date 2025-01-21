package org.example;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        Solution sl=new Solution();
        // [[3,3,1],[8,5,2]]
        int[][] grid={{20,3,20,17,2,12,15,17,4,15},{20,10,13,14,15,5,2,3,14,3}};
        long res=sl.gridGame(grid);
        System.out.println(res);
    }

    public long gridGame(int[][] grid) {
        long firstRowSum=0l;
        for(int i:grid[0]){
            firstRowSum+=grid[0][i];
        }
        long sum1=0l;
        long sum2=0l;
        long res=Long.MAX_VALUE;
        for(int i=0;i<grid[0].length;i++){
            long min=0;
            sum1+=grid[0][i];
            if(i==0){
                min=firstRowSum-(sum1);
            }
            else if(i==grid[0].length-1){
                min=sum2;
            }
            else{
                min=Math.max(firstRowSum-sum1,sum2);
            }
            res=Math.min(min,res);
            sum2+=grid[1][i];
        }
        return res;
    }
}