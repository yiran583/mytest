package com.file;

import java.io.Console;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexTestHarness {

	public static void main(String[] args) { 
       String str = "aaa";
       String regx = "aa[a]";
       
        while (true) { 
            Pattern pattern = Pattern.compile(regx); 
            Matcher matcher = pattern.matcher(str); 
            while (matcher.find()) { 
            	System.out.println(String.format("I found the text \"%s\" starting at index %d " + 
                        "and ending at index %d.%n", 
                        matcher.group(), matcher.start(), matcher.end()));
            } 
        } 
    }}