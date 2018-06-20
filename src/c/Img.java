package c;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Img {
	private static Robot robot;
	public static BufferedImage start() {
		try {
			robot = new Robot();
			//robot.mouseMove(515, 210);
			//移动鼠标 常规
			robot.mouseMove(845, 540);
			//移动鼠标 快速
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			//点进窗口
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			//点一个格子，开始游戏。
			Thread.sleep(200);
			BufferedImage img=getscreen();
			return img;
		} catch (AWTException e) {
			e.printStackTrace();
			return null;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	public static BufferedImage getscreen() {
		BufferedImage img=robot.createScreenCapture(new Rectangle(435,130,495,495));
		return img;
	}
	public static int click(int[][]num) {
		int times=0;
		for(int x=0;x<num.length;x++) {
			for(int y=0;y<num[x].length;y++) {
				if(num[x][y]==8)return 8;
				if(num[x][y]==12) {
					times++;
					robot.mouseMove(415+y*55, 110+x*55);
					robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
					robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
					System.out.println((x)+":"+(y));
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
						return 8;
					}
				}
				
			}
		}
		if (times==0){
			for(int x=0;x<num.length;x++) {
				for(int y=0;y<num[x].length;y++) {
					if(num[x][y]==9) {
						robot.mouseMove(415+y*55, 110+x*55);
						robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
						robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
						System.out.println("没有安全的地方，随机点一个");
						return 0;
						}
					}
					
				}

		}
			
		return 0;
	}
    public static int getCor(int rgb) {
		
		//二值化一个像素		
		String str=Integer.toHexString(rgb);
		int r=Integer.parseInt(str.substring(2,4),16);
		int g=Integer.parseInt(str.substring(4,6),16);
		int b=Integer.parseInt(str.substring(6,8),16);
		Color c=new Color(rgb);
		
		//获取像素的RGB值		
		r=c.getRed();
		g=c.getGreen();
		b=c.getBlue();
		
		//扫雷专用灰化公式		
		int miaomiao=(r*67+g*20+b*13)/100;
		return (int)(miaomiao);
	}
public static int[][] corArray2(BufferedImage miao) {
		
		//图片转二维数组
		
		int w=miao.getWidth();
		int h=miao.getHeight();
		//获取图像信息
		
		int[][] ret=new int[h][w];
		//像素灰化并转为数字存入数组
		
		for(int p=0;p<h;p++) {
			for(int q=0;q<w;q++) {
				int color=getCor(miao.getRGB(q, p));
				if(color<150)ret[p][q]=0;
				else ret[p][q]=1;
			}
		}
		//灰度值小于150记0，否则记1
		return ret;
		
	}

	public static int[] corArray(BufferedImage srcImg) {
		//图片转一维数组
		
		int w=srcImg.getWidth();
		int h=srcImg.getHeight();
		int[]cor=new int[w*h];
		//获取图像信息
		
		int cornum=0;
		//像素灰化并转为数字存入数组
		for(int p=0; p<h; p++) {
		    	for(int q=0; q<w; q++) {
		    		
		    		int color = getCor(srcImg.getRGB(q,p));
		    		
		    		if(color<150)cor[cornum]=0;
		    		else cor[cornum]=1;
		    		
		    		cornum++;
		    	}
		    }
		//灰度值小于150记0，否则记1
		 return cor;
		
	}
	public static int[] start1() throws IOException {
		BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/c1.jpg"));
		//请把训练图片移到改file或修改file
		int[]number1=corArray(num1);
		return number1;
	}
    public static int[] start2() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/c2.jpg"));
	int[]number1=corArray(num1);
	return number1;
}

    public static int[] start3() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/c3.jpg"));
	int[]number1=corArray(num1);;
	return number1;
}

    public static int[] start4() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/c4.jpg"));
	int[]number1=corArray(num1);
	return number1;
}

    public static int[] start5() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/c5.jpg"));
	int[]number1=corArray(num1);
	return number1;
}

    public static int[] start6() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/c6.jpg"));
	int[]number1=corArray(num1);
	return number1;
}

  /*  public static int[] start7() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/s7.jpg"));
	int[]number1=Eyes.corArray(num1);
	return number1;
}*/

    public static int[] start9() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/c9.jpg"));
	int[]number1=corArray(num1);
	return number1;
}
    public static int[] start0() throws IOException {
	BufferedImage num1=ImageIO.read(new File("D:/Documents/Minesweeper OrangeSun/c11.jpg"));
	int[]number1=corArray(num1);
	return number1;
}

}
