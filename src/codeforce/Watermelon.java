//package codeforce;

import java.util.*;
import java.lang.*;
import java.io.*;
class Watermelon
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner s=new Scanner (System.in);
        int w=s.nextInt();
        if(w>2 && w%2==0)
            System.out.println("YES");
        else
            System.out.println("NO");
	}
}