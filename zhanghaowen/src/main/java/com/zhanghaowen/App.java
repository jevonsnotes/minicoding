package com.zhanghaowen;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main(String[] args) {
		System.out.println(letterCombinations(new String[] {"2","3"}));

		System.out.println(letterCombinations(new String[] {"0","99"}));
	}
    public static List<String> letterCombinations(String[] digits) {
       	List<String> container = new ArrayList<String>();
		if(digits!=null) {
            String[] dir = ",,abc,def,ghi,jkl,mno,pqrs,tuv,wxyz".split(",");
            int maxLength = getMaxLength(digits);
			loop(0,0,maxLength,digits,"",container,dir);
		}
        return container;
	}

    public static int getMaxLength(String[] digits) {
    	int count = 0;
    	int i = 0;
    	for(String s :digits) {
    		String newS = s.replaceAll("[^2-9]", "");
    		digits[i++] = newS;
    		count += newS.length();
    	}
    	return count;
    }
    
    
    
    public static void loop(int pidIndex,int subIndex,int maxLetterSize,String[] digits, String concat,List<String> container,String[] dir) {
    	String tempDigits = digits[pidIndex];
    	while(digits[pidIndex].isEmpty()&&pidIndex<digits.length-1){
    		tempDigits = digits[++pidIndex];
    	}
		if(concat.length()==maxLetterSize
				&&pidIndex == digits.length-1) {
			container.add(concat);
			return;
		}else {
			if(pidIndex!=digits.length-1) {
				if(subIndex == tempDigits.length()-1) {
					pidIndex++;
					subIndex =0;
				}else {
					subIndex ++;
				}
			}
			char[] letters = dir[Integer.parseInt(Character.toString(tempDigits.charAt(subIndex)))].toCharArray();
			for(char letter :letters) {
				loop(pidIndex,subIndex,maxLetterSize,digits, concat+Character.toString(letter), container,dir);
			}
		}
	}
    
}
