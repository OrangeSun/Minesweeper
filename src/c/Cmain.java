package c;

import java.awt.image.BufferedImage;
import java.io.IOException;

import fasterC.Fcimg;

/*
 * @author OrangeSun
 * @version 0.1.666
*/

public class Cmain {

	public static void main(String[]args) throws IOException{
		/*int[]start1=Img.start1();
		int[]start2=Img.start2();
		int[]start3=Img.start3();
		int[]start4=Img.start4();
		int[]start5=Img.start5();
		int[]start6=Img.start6();
		int[]start9=Img.start9();
		int[]start0=Img.start0();*/
		//导入训练数据 初级 常规
		int[]start1=Fcimg.start1();
		int[]start2=Fcimg.start2();
		int[]start3=Fcimg.start3();
		int[]start4=Fcimg.start4();
		int[]start5=Fcimg.start5();
		int[]start6=Fcimg.start6();
		int[]start9=Fcimg.start9();
		int[]start0=Fcimg.start0();
		//导入训练数据 初级 快速
		
		BufferedImage screenimg=Img.start();
		//点击一个格子并截图 初级
		
		//int[][] screen=Img.corArray2(screenimg);
		//图像转二维数组 初级 常规
		int[][]screen=Fcimg.smImg(screenimg);
		//图像转二维数组 初级 快速
		
		int[][]num = new int[11][11];
		//建立画面上数字的二维数组，用0包围防止计算出错
		int win=0;
		//建立“赢了”变量
		
		for(int times=0;times<16;times++) {
			//循环16次1
			
		//num=Think.thinkimg(screen, num, start1, start2, start3, start4, start5, start6, start9, start0);
		//读取截屏图像信息，这个地方我没写好，需要耗费大量时间
		num=Fcimg.fthink(screen, num, start1, start2, start3, start4, start5, start6, start9, start0);
		//解决 快速版
		
		num=Think.thinknum(num);
		//分析局势
		int error=Img.click(num);
		//模拟点击
		send(num);
		//输出局势便于测试和装x
		if(error==8)break;
		//如果出错
		if(error==6&&win==6)break;
		if(error==6)win=6;
		//如果赢了
		screenimg=Img.getscreen();
		//没赢，截屏
		
		//int[][] screen=Img.corArray2(screenimg);
		//图像转二维数组 初级 常规
		screen=Fcimg.smImg(screenimg);
		//图像转二维数组 快速
		}
		
	}
	public static void send(int[][] arr) {
		//输出画面矩阵
		for(int lvbu=0; lvbu<arr.length; lvbu++) {
			for(int diaochan=0; diaochan<arr[lvbu].length; diaochan++) {
	
				System.out.print(arr[lvbu][diaochan]+" ");
	
			}
			System.out.println();
		}
	}
}
