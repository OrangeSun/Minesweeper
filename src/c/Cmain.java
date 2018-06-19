package c;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Cmain {

	public static void main(String[]args) throws IOException{
		int[]start1=Img.start1();
		int[]start2=Img.start2();
		int[]start3=Img.start3();
		int[]start4=Img.start4();
		int[]start5=Img.start5();
		int[]start6=Img.start6();
		int[]start9=Img.start9();
		int[]start0=Img.start0();
		BufferedImage screenimg=Img.start();
		int[][] screen=Img.corArray2(screenimg);
		int[][]num = new int[11][11];
		int win=0;
		for(int times=0;times<15;times++) {
		num=Think.thinkimg(screen, num, start1, start2, start3, start4, start5, start6, start9, start0);
		num=Think.thinknum(num);
		int error=Img.click(num);
		send(num);
		if(error==8)break;
		if(error==6&&win==6)break;
		if(error==6)win=6;
		screenimg=Img.getscreen();
		screen=Img.corArray2(screenimg);
		}
	}
	private static void send(int[][] arr) {
		//二维数组输出矩阵
		for(int lvbu=0; lvbu<arr.length; lvbu++) {
			for(int diaochan=0; diaochan<arr[lvbu].length; diaochan++) {
	
				System.out.print(arr[lvbu][diaochan]+" ");
	
			}
			System.out.println();
		}
	}
}
