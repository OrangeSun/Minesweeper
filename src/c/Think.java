package c;

public class Think {

	public static int[][] thinkimg(int[][]img,int[][]snum,int[] start1,int[] start2,int[] start3,int[] start4,int[] start5,int[] start6,int[] start9,int[] start0){
		int x=img.length;
		int y=img[1].length;
		int[][] num=new int[11][11];
		int numa=1;
		int numb=1;
		
		for(int p=0;p<x-55;p+=55) {
			numb=1;
			for(int q=0;q<y-55;q+=55) {
				int[] copy=new int[1936];
				int copytimes=0;
				for(int xx=8;xx<52;xx++) {
					for(int yy=8;yy<52;yy++) {
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
	
	public static int[][] thinknum(int[][]arr){
		arr=thinkBomm(arr);
		arr=thinkSalf(arr);
		System.out.println("思考结束");
		return arr;
	}

	private static int[][] thinkSalf(int[][] arr) {
		for(int x=0; x<arr.length; x++){
			for(int y=0; y<arr[x].length; y++) {
				if(arr[x][y]<9&&arr[x][y]>0) {
				//计算数字是否=附近雷数
				int found=0;
				if(arr[x+1][y]==10){
					found++;
				}
				if(arr[x+1][y+1]==10){
					found++;
				}
				if(arr[x][y+1]==10) {
					found++;
				}
				if(arr[x-1][y]==10) {
					found++;
				}
				if(arr[x-1][y-1]==10) {
					found++;
				}
				if(arr[x][y-1]==10) {
					found++;
				}
				if(arr[x-1][y+1]==10) {
					found++;
				}
				if(arr[x+1][y-1]==10) {
					found++;
				}
				if(arr[x][y]==found) {//如果数字=附近雷数，开其他格子（如果有）
					System.out.println("判定可点位置成功");
					if(arr[x+1][y]==9)arr[x+1][y]=12;
					
					if(arr[x+1][y+1]==9)arr[x+1][y+1]=12;
					
					if(arr[x][y+1]==9)arr[x][y+1]=12;
					
					if(arr[x-1][y]==9)arr[x-1][y]=12;
					
					if(arr[x-1][y-1]==9)arr[x-1][y-1]=12;
					
					if(arr[x][y-1]==9)arr[x][y-1]=12;
					
					if(arr[x-1][y+1]==9)arr[x-1][y+1]=12;
					
					if(arr[x+1][y-1]==9)arr[x+1][y-1]=12;
					
				else if(arr[x][y]<found) {//如果数字小于雷数
					System.out.println("Error ! 解析出错了，可能是图像分析失误！ ");
					Cmain.send(arr);
					arr[x][y]=8;
					return arr;
				}
			}
			}
			
		}
		}
		return arr;
	}

	private static int[][] thinkBomm(int[][] arr) {
		for(int x=0; x<arr.length; x++) {
			for(int y=0; y<arr[x].length; y++) {
				
				if(arr[x][y]<9&&arr[x][y]>0) {
					int mytry=0;
					//计算数字是否=剩余格数
					if(arr[x+1][y]==9||arr[x+1][y]==10){
						mytry+=1;
					}
					if(arr[x+1][y+1]==9||arr[x+1][y+1]==10){
						mytry+=1;
					}
					if(arr[x][y+1]==9||arr[x][y+1]==10) {
						mytry+=1;
					}
					if(arr[x-1][y]==9||arr[x-1][y]==10) {
						mytry+=1;
					}
					if(arr[x-1][y-1]==9||arr[x-1][y-1]==10) {
						mytry+=1;
					}
					if(arr[x][y-1]==9||arr[x][y-1]==10) {
						mytry+=1;
					}
					if(arr[x-1][y+1]==9||arr[x-1][y+1]==10) {
						mytry+=1;
					}
					if(arr[x+1][y-1]==9||arr[x+1][y-1]==10) {
						mytry+=1;
					}
					if(arr[x][y]==mytry) {//如果数字=剩余格数，记雷。
						System.out.println("判定雷成功");
						if(arr[x+1][y]==9){
							arr[x+1][y]=10;
						}
						
						if(arr[x+1][y+1]==9){
							arr[x+1][y+1]=10;
						}
						
						if(arr[x][y+1]==9) {
							arr[x][y+1]=10;
						}
						
						if(arr[x-1][y]==9) {
							arr[x-1][y]=10;
						}
						
						if(arr[x-1][y-1]==9) {
							arr[x-1][y-1]=10;
						}
						
						if(arr[x][y-1]==9) {
							arr[x][y-1]=10;
						}
						
						if(arr[x-1][y+1]==9) {
							arr[x-1][y+1]=10;
						}
						
						if(arr[x+1][y-1]==9) {
							arr[x+1][y-1]=10;
						}
						
					}
					if(arr[x][y]>mytry) {//如果数字比没打开的格子还多
						System.out.println("Error ! 解析出错了，可能是图像分析失误 ！");
						Cmain.send(arr);
						arr[x][y]=8;
					}
				}
				
			}
		}
		return arr;
	}

	private static int getnum(int[]arr, int[] start1, int[] start2, int[] start3, int[] start4, int[] start5,
			int[] start6, int[] start9, int[] start0) {
		int n9=edit(arr,start9);
		if(n9<=70) {
			System.out.println("9#");
			return 9;
		}
		
		int n0=edit(arr,start0);
		if(n0<=90) {
			System.out.println("0#");
			return 0;
		}
		
		int n1=edit(arr,start1);
		if(n1<=40) {
			System.out.println("1#");
			return 1;
		}
		
		int n2=edit(arr,start2);
		if(n2<=30) {
			System.out.println("2#");
			return 2;
		}
		
		int n3=edit(arr,start3);
		if (n3<=30) {
			System.out.println("3#");
			return 3;
		}
		
		int n4=edit(arr,start4);
		if(n4<=30) {
			System.out.println("4#");
			return 4;
		}
		
		int n5=edit(arr,start5);
		if(n5<=30) {
			System.out.println("5#");
			return 5;
		}
		
		int n6=edit(arr,start6);
		if(n6<=25) {
			System.out.println("6#");
			return 6;
		}
		n1+=35;
		n2-=30;
		n3-=20;
		n5-=20;
		
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

	public static int edit(int[] s1, int[] s2) {	
		double d[][];
		int n;
		int m;
		int i;
		int j;
		int s_i;
		int t_j;
		double cost;
		
		n=s1.length;
		m=s2.length;
		
		if(n==0)return m;
		if(m==0)return n;
		
		d=new double[n+1][m+1];
		
		for(i=0;i<=n;i++) {
			d[i][0]=i;
		}
		for(j=0;j<=m;j++) {
			d[0][j]=j;
		}
		
		for(i=1;i<=n;i++) {
			s_i=s1[i-1];
			for(j=1;j<=m;j++) {
				t_j=s2[j-1];
				
				if(s_i==t_j)cost=0;
				else cost=1;
				
				d[i][j]=Minimum(d[i-1][j]+1 , d[i][j-1]+1 , d[i-1][j-1]+cost );
			}
		}
		return (int) d[n-1][m-1];
	}

	private static double Minimum(double a, double b, double c) {
		double mi=a;
		if (b<mi)mi=b;
		if(c<mi)mi=c;
		return mi;
	}
}
