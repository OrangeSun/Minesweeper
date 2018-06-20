package fasterC;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Fcimg {
	//快速版，使用前请保证其他类的一些方法已经给快速版除掉了注释并给常规般加上了注释
	public static int[][] fthink(int[][]img,int[][]snum,int[] start1,int[] start2,int[] start3,int[] start4,int[] start5,int[] start6,int[] start9,int[] start0){
		int x=img.length;
		int y=img[1].length;
		System.out.println(":"+x+":"+y);
		int[][] num=new int[11][11];
		int numa=1;
		int numb=1;
		
		for(int p=0;p<x;p+=27) {
			numb=1;
			for(int q=0;q<y;q+=27) {
				int[] copy=new int[484];
				int copytimes=0;
				for(int xx=3;xx<25;xx++) {
					for(int yy=3;yy<25;yy++) {
						copy[copytimes]=img[p+xx][q+yy];
						copytimes++;
					}
				}
				num[numa][numb]=getnum(copy,start1, start2, start3, start4, start5, start6,start9, start0);
				numb++;
			}
			numa++;
		}
		return num;
		
	}
	private static int getnum(int[]arr, int[] start1, int[] start2, int[] start3, int[] start4, int[] start5,
			int[] start6, int[] start9, int[] start0) {
		int n9=c.Think.edit(arr,start9);
		if(n9<=20) {
			System.out.println("9#"+n9);
			return 9;
		}
		
		int n0=c.Think.edit(arr,start0);
		if(n0<=20) {
			System.out.println("0#");
			return 0;
		}
		
		int n1=c.Think.edit(arr,start1);
		if(n1<=20) {
			System.out.println("1#");
			return 1;
		}
		
		int n2=c.Think.edit(arr,start2);
		if(n2<=20) {
			System.out.println("2#");
			return 2;
		}
		
		int n3=c.Think.edit(arr,start3);
		if (n3<=20) {
			System.out.println("3#");
			return 3;
		}
		
		int n4=c.Think.edit(arr,start4);
		if(n4<=20) {
			System.out.println("4#");
			return 4;
		}
		
		int n5=c.Think.edit(arr,start5);
		if(n5<=20) {
			System.out.println("5#");
			return 5;
		}
		
		int n6=c.Think.edit(arr,start6);
		if(n6<=20) {
			System.out.println("6#");
			return 6;
		}
		//待完善
		n1+=5;
		n2+=2;
		n3-=3;
		
		if(n1<=n2&&n1<=n3&&n1<=n4&&n1<=n5&&n1<=n6&&n1<n9&&n1<n0) {
			System.out.println("1#:"+n1+"："+n2+":"+n3+":"+n4+":"+n5+":"+n6+":"+n0+":"+n9);
			return 1;
		}
		else if(n2<=n3&&n2<=n4&&n2<=n5&&n2<=n6&&n2<n9&&n2<n0) {
			System.out.println("2#:"+n1+"："+n2+":"+n3+":"+n4+":"+n5+":"+n6+":"+n0+":"+n9);
			return 2;
		}
		else if(n3<=n4&&n3<=n5&&n3<=n6&&n3<n9&&n3<n0) {
			System.out.println("3#:"+n1+"："+n2+":"+n3+":"+n4+":"+n5+":"+n6+":"+n0+":"+n9);
			return 3;
		}
		else if(n4<=n5&&n4<=n6&&n4<n9&&n4<n0) {
			System.out.println("4#:"+n1+"："+n2+":"+n3+":"+n4+":"+n5+":"+n6+":"+n0+":"+n9);
			return 4;
		}
		else if(n5<=n6&&n5<n9&&n5<n0) {
			System.out.println("5#:"+n1+"："+n2+":"+n3+":"+n4+":"+n5+":"+n6+":"+n0+":"+n9);
			return 5;
		}
		else if(n6<n9&&n6<n0) {
			System.out.println("6#:"+n1+"："+n2+":"+n3+":"+n4+":"+n5+":"+n6+":"+n0+":"+n9);
			return 6;
		}
		else if(n9<n0){
			System.out.println("9#:"+n1+"："+n2+":"+n3+":"+n4+":"+n5+":"+n6+":"+n0+":"+n9);
			return 9;
		}
		else {
			System.out.println("0#:"+n1+"："+n2+":"+n3+":"+n4+":"+n5+":"+n6+":"+n0+":"+n9);
			return 0;
			}
	}

	public static int[][]smImg(BufferedImage miao){
	//图片转二维数组
		
		int w=miao.getWidth();
		int h=miao.getHeight();
		//获取图像信息
		
		int[][] ret=new int[(h-9)/2][(w-9)/2];
		//长or宽-格子数（因为每个格子都剪掉了一个像素的边框）除以二（压缩）
		//下面是一种用数组来二值化并压缩的办法，java自带的压缩方法我弄不懂，这里只是简单的把图片分成一个个小正方形里的灰度值相加除以格子数，然后写进另一个数组变成一个个RGB值（这里是二值化后的01）。
		int xxx=0;
		for(int x=0;x<w;x+=55) {
			int yyy=0;
			for(int y=0;y<h;y+=55) {
				int xx=0;
				for(int p=1;p<55;p+=2) {
					int yy=0;
					for(int q=1;q<55;q+=2) {
						int col1=c.Img.getCor(miao.getRGB(q+y, p+x));
						int col2=c.Img.getCor(miao.getRGB(q+y+1, p+x));
						int col3=c.Img.getCor(miao.getRGB(q+y, p+x+1));
						int col4=c.Img.getCor(miao.getRGB(q+y+1, p+x+1));
						int color=(col1+col2+col3+col4)/4;
						
						if(color<150)ret[xxx+xx][yyy+yy]=0;
						else ret[xxx+xx][yyy+yy]=1;
						yy++;
					}
					xx++;
				}
				yyy+=27;
			}
			xxx+=27;
		}
		//灰度值小于150记0，否则记1
		return ret;
	}

	public static int[] start1() throws IOException {
		BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/fc1.jpg"));
		//请把训练图片移到这个file或修改file
		int[]number1=c.Img.corArray(num1);
		return number1;
	}
	public static int[] start2() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/fc2.jpg"));
	int[]number1=c.Img.corArray(num1);
	return number1;
}

    public static int[] start3() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/fc3.jpg"));
	int[]number1=c.Img.corArray(num1);;
	return number1;
}

    public static int[] start4() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/fc4.jpg"));
	int[]number1=c.Img.corArray(num1);
	return number1;
}

    public static int[] start5() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/fc5.jpg"));
	int[]number1=c.Img.corArray(num1);
	return number1;
}

    public static int[] start6() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/fc6.jpg"));
	int[]number1=c.Img.corArray(num1);
	return number1;
}

  /*  public static int[] start7() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/s7.jpg"));
	int[]number1=Eyes.corArray(num1);
	return number1;
}*/

    public static int[] start9() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/fc9.jpg"));
	int[]number1=c.Img.corArray(num1);
	return number1;
}
    public static int[] start0() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/fc11.jpg"));
	int[]number1=c.Img.corArray(num1);
	return number1;
}
}
