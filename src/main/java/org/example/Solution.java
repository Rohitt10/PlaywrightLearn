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

    public String shiftingLetters(String s, int[][] shifts) {
        int[] a=new int[s.length()];
        for(int[] query:shifts){
            int valueAdded=query[2]==0?-1:1;
            a[query[0]]+=valueAdded;
            if(query[1]<a.length-1){
                a[query[1]+1]-=valueAdded;
            }
        }
        for(int i=1;i<a.length;i++){
            a[i]+=a[i-1];
        }
        char[] resArray=new char[a.length];
        for(int i=0;i<s.length();i++){
            int value=a[i]%26;
            if(value<0){
                value=26+value;
            }
            resArray[i]=(char)('a'+(s.charAt(i)-'a'+value)%26);
        }
        return new String(resArray);
    }
}