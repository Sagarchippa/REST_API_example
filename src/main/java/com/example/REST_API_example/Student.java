package com.example.REST_API_example;

import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id;
    private String name;
    private String pwd;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public boolean[] primeSeive(int n){
        boolean[] arr=new boolean[n+1];
        arr[0]=true;//for o
        arr[1]=true;//for 1
        for(int i=2;i<=n;i++){
            if(arr[i]==false) {
                for (int j = i+1; j < arr.length; j++) {
                    if(j%i==0){
                        arr[j]=true;
                    }
                }
            }
        }
        return arr;
    }

    public void printPrimes(boolean[] arr){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==false){
                System.out.println(i);
            }
        }
    }
}