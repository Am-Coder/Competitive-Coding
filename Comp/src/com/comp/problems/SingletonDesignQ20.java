package com.comp.problems;

public class SingletonDesignQ20 {
    public String str;
    private static SingletonDesignQ20 insta=new SingletonDesignQ20();//making it static means only a single insta is shared between
																	//the different instances

    public static SingletonDesignQ20 getSingleInstance(){
        return insta;
    }
}
