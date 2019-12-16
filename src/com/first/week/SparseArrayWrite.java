package com.first.week;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈二维数组和稀疏数组保存与读取〉<br>
 * 〈〉
 *
 * @author PitterWang
 * @create 2019/11/24
 * @since 1.0.0
 */
public class SparseArrayWrite {

	public static void main(String[] args) {

		FileOutputStream outSTr = null;
		BufferedOutputStream Buff = null;
		File file = null;

		String savePath = "C:\\Users\\92588\\Desktop\\release\\save.txt";
		//定义了一个整型的二维数组，其中包含11个一维数组，每个一维数组可以存储12个整数
		int chessboard[][] = new int[11][12];
		chessboard[0][1] = 1;
		chessboard[1][0] = 2;
		chessboard[3][4] = 1;
		chessboard[5][6] = 1;
		chessboard[7][8] = 2;


		int count = 0;
		for(int row[]: chessboard){

			for(int date : row){

				System.out.printf("%d\t", date);
				if(date !=0 ){
					count ++;
				}
			}
			System.out.println();
		}


		System.out.printf("有个%d棋子\n", count);

		/***
		 * 二维数组转为稀疏数组
		 */

		try {

			file = new File(savePath);

			outSTr = new FileOutputStream(file);
			Buff = new BufferedOutputStream(outSTr);
			Buff.write((11+" "+12+" "+count+"\n").getBytes());

			int co = 1;
			for (int i = 0; i < chessboard.length ;i++ ){
				for(int j = 0 ; j < chessboard[i].length; j++){
					if(chessboard[i][j] != 0){
						Buff.write((i+" "+j+" "+chessboard[i][j]+"\n").getBytes());
						co ++;
					}
				}


			}
			Buff.flush();
			Buff.close();



		} catch (IOException e) {
			e.printStackTrace();
		}



		int newSpaChessboard[][] = SparseArrayWrite.ReadFileByLine(savePath);
		System.out.println("-----------------稀疏数组---------------");
		SparseArray.sysChess(newSpaChessboard);

		/***
		 * 稀疏数组转二维数组
		 * sparse[][]
		 */

		System.out.println("-------------稀疏数组转二维数组-------------------");

		int newRow = newSpaChessboard[0][0];
		int newRelease = newSpaChessboard[0][1];
		int num = newSpaChessboard[0][2];
		int newChessboard[][] = new int[newRow][newRelease];


		for(int i = 1;i <= num;i++){
			newChessboard[newSpaChessboard[i][0]][newSpaChessboard[i][1]]=newSpaChessboard[i][2];
		}


		SparseArray.sysChess(newChessboard);

	}


	/**
	 * 按行读取文件
	 */
	public static int[][] ReadFileByLine(String filename) {
		File file = new File(filename);
		InputStream is = null;
		Reader reader = null;
		BufferedReader bufferedReader = null;

		int cha[][] = null;
		try {
			is = new FileInputStream(file);
			reader = new InputStreamReader(is);
			bufferedReader = new BufferedReader(reader);
			String line = null;
			List<String> list = new ArrayList<>();
			//按行读取文件
			while ((line = bufferedReader.readLine()) != null) {
				list.add(line);
			}
			//定义读取要返回的稀疏数组
			cha = new int[list.size()][3];

			if(list !=null&& !list.isEmpty()){
				for(int j = 0;j<list.size();j++){
					String result [] = list.get(j).split(" ");
					for(int k = 0; k < result.length; k++){
						cha[j][k] = Integer.parseInt(result[k]);
						cha[j][k] = Integer.parseInt(result[k]);
						cha[j][k] = Integer.parseInt(result[k]);

					}
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != bufferedReader){
					bufferedReader.close();
				}
				if (null != reader){
					reader.close();

				}
				if (null != is){
					is.close();

				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return cha;
	}

}