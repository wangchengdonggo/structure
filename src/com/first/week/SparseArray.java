package com.first.week;


/**
 * 〈稀疏数组〉
 *
 * @author PitterWang
 * @create 2019/11/18
 * @since 1.0.0
 */
public class SparseArray {


	public static void main(String[] args) {

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
		int sparse[][] = new int[count + 1][3];
		sparse[0][0] = 11;
		sparse[0][1] = 12;
		sparse[0][2] = count;


		int co = 1;
		for (int i = 0; i < chessboard.length ;i++ ){

			for(int j = 0 ; j < chessboard[i].length; j++){


				if(chessboard[i][j] != 0){
					sparse [co] [0] = i;
					sparse [co] [1] = j;
					sparse [co] [2] = chessboard[i][j];
					co ++;
				}
			}

		}


		System.out.println("-----------------稀疏数组---------------");

		SparseArray.sysChess(sparse);


		/***
		 * 稀疏数组转二维数组
		 * sparse[][]
		 */

		System.out.println("-------------稀疏数组转二维数组-------------------");

		int newRow = sparse[0][0];
		int newRelease = sparse[0][1];
		int num = sparse[0][2];
		int newChessboard[][] = new int[newRow][newRelease];


		for(int i = 1;i <= num;i++){
			newChessboard[sparse[i][0]][sparse[i][1]]=sparse[i][2];
		}


		SparseArray.sysChess(newChessboard);
	}


	/***
	 * 打印功能
	 * @param newChessboard
	 */
	public static void sysChess(int newChessboard[][] ){
		for(int row[] : newChessboard){

			for(int date : row){

				System.out.printf("%d\t", date);
			}
			System.out.println();
		}
	}




}

