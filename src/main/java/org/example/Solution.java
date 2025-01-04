package org.example;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    int[] firstIndexes=new int[26];
    int[] lastIndexes=new int[26];
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        for(int i=0;i<n;i++){
            if(firstIndexes[s.charAt(i)-'a']==0){
                firstIndexes[s.charAt(i)-'a']=i+1;
            }
            lastIndexes[s.charAt(i)-'a']=i+1;
        }
        ArrayList<HashSet<Character>> al=new ArrayList<>(26);
        for(int i=0;i<26;i++){
            al.add(new HashSet<>());
        }
        // for(int i=0;i<26;i++){
        //     System.out.println("firstIndex: "+firstIndexes[i]+" lastIndex: "+lastIndexes[i]);
        // }
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            int value=i+1;
            for(int j=0;j<26;j++){
                if(firstIndexes[j]<value&&lastIndexes[j]>value){
                    al.get(j).add(c);
                }
            }
        }
        int sum=0;
        int i=0;
        for(HashSet<Character> hs:al){
            // System.out.println(i+" "+hs.size());
            sum+=hs.size();
        }
        return sum;
    }
}