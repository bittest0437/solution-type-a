package problem04;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;

public class Main {
	  static int strike =0; //스트라이크 변수 선언
	  static int ball = 0; //볼 변수 선언
	  static int out = 0; //볼 변수 선언 
	  static int usercount = 1;
	  public static void main (String[] args) throws java.lang.Exception
	  {
		long start = System.currentTimeMillis();
		File file = new File("/Users/bit/git/solution-type-a/baseballgame.txt");
	    int computer[] = new int[3]; //컴퓨터가 정한 값
	    int user[] = new int[3]; //유저가 정한 값
	    int seq = 0;
	    
	    Random random = new Random();

	    while(computer[0] == 0){
	      computer[0] = random.nextInt(10);
	    }
	    
	    while(computer[0] == computer[1] || computer[1] == 0){
	      computer[1] = random.nextInt(10);
	    }

	    while(computer[0] == computer[2] || computer[1] == computer[2] || computer[2] == 0){
	      computer[2] = random.nextInt(10);
	    }
	     
	    Scanner s= new Scanner(System.in);
	     
	    while(strike < 3){ 
	    	seq ++;
	    	System.out.print("> ");
	    	int num1 =s.nextInt();
	        
	        while(num1 >=1000 || num1 <= 111){
	          System.out.println("error: 1~9사이에 입력 하세요.");
	          num1=s.nextInt();
	        }
	        
	        user[0] = num1 / 100;
	        user[1] = num1 / 10 % 10;
	        user[2] = num1 % 10;
	      
	      for(int i = 0; i< 3; i++){
	        for(int j=0; j<3; j++){
	          if(computer[i] == user[j]){
	            if(i==j){
	              strike+=1;
	            }else{  
	              ball+=1;
	            }
	            
	          }
	          
	        }
	      }
	      
	      if(strike+ball == 0) {
	    	  out = 3;
	      }else if(strike+ball == 1) {
	    	  out = 2;
	      }else if (strike + ball == 2) {
	    	  out = 1;
	      }else {
	    	  out = 0;
	      }
	   
	      if(strike == 3){
	    	System.out.println(seq + " - S:"+strike+", B:"+ball+", O:"+out);
	    	strike=0;
		    ball=0;
		    out=0;
		    long end = System.currentTimeMillis();
		    System.out.println((end-start) / 1000.0);
		    System.out.println("(종료)");
		    
		    try {
		    	FileWriter fw = new FileWriter(file, true);
		    	fw.write(": 숫자="+computer[0]+computer[1]+computer[2]+"시행횟수="+seq+", 시간="+((end-start)/1000.0) +"\n");
		    	fw.close();
		    }catch (Exception e) {
		    	e.printStackTrace();
		    }
		    System.exit(0); //무한루프 탈출하여 종료!
	      }else{
	    	System.out.println(seq + " - S:"+strike+", B:"+ball+", O:"+out);
	        strike=0;
	        ball=0;
	        out=0;
	      }
	    }
	  }

}