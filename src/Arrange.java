package yourPackage;

import java.util.ArrayList;

public class Arrange {
	static ArrayList<Block> plane=new ArrayList<Block>();
	static int seatOfPassenger=1,maxPassengers=0;
	public static void addBlock(int row,int col)
	{
		plane.add(new Block(row,col));
	}
	public static int maxCapacity()
	{
		int maxiCapacity=0;
		for(int i=0;i<=(plane.size()-1);i++)
		{
			maxiCapacity+=plane.get(i).getMax();
		}
		return maxiCapacity;
	}
	public static void makeArrangements()
	{
		setAisle();
		setWindow();
		setMiddle();
		
	}
	public static void setAisle()
	{
		for (int ja = 0; ja < plane.size(); ja++) {
			for (int i = 0; i <= plane.get(ja).getRow(); i++)
			{
				for (int j = 0; j < plane.size(); j++) {
					for (int k = 0; k <= plane.get(j).getCol(); k++) {
						if (i <= plane.get(j).getRow() && plane.get(j).getCellValue(i, k) == 0) {
							if (j == 0 && k == plane.get(j).getCol()) {
								plane.get(j).setCellValue(i, k, seatOfPassenger++);
							} else if (j == (plane.size() - 1) && k == 0) {
								plane.get(j).setCellValue(i, 0, seatOfPassenger++);
							} else if ((j != 0 && j != (plane.size() - 1) && k == 0)
									|| (j != 0 && j != (plane.size() - 1) && k == plane.get(j).getCol())) {
								plane.get(j).setCellValue(i, k, seatOfPassenger++);
							}
						}
					}
				}
			}
		}
	}
	public static void setWindow()
	{
		for (int ja = 0; ja < plane.size(); ja++) {
			for (int i = 0; i <= plane.get(ja).getRow(); i++) {

				for (int j = 0; j < plane.size(); j++) {
					for (int k = 0; k <= plane.get(j).getCol(); k++) {
						if (i <= plane.get(j).getRow() && plane.get(j).getCellValue(i, k) == 0) {
							if ((k == 0 && j == 0) || (j == (plane.size() - 1) && k == plane.get(j).getCol())) {
								plane.get(j).setCellValue(i, k, seatOfPassenger++);
							}
						}
					}
				}
			}
		}
	}
	public static void setMiddle()
	{
		for (int ja = 0; ja < plane.size(); ja++) {
			for (int i = 0; i <= plane.get(ja).getRow(); i++) {
				for (int j = 0; j < plane.size(); j++) {
					for (int k = 0; k <= plane.get(j).getCol(); k++) {
						if (i <= plane.get(j).getRow() && plane.get(j).getCellValue(i, k) == 0) {
							if (k != 0 && k != plane.get(j).getCol()) {
								plane.get(j).setCellValue(i, k, seatOfPassenger++);
							}
						}
					}

				}
			}
		}
	}
	public static void displayFirst()
	{
		for (int k = 0; k < plane.size(); k++) {
			for (int i = 0; i <= plane.get(k).getRow(); i++) {
				for (int j = 0; j <= plane.get(k).getCol(); j++) {
					if (plane.get(k).getCellValue(i, j)<=maxPassengers) {
						System.out.print(" " + plane.get(k).getCellValue(i, j));
					}
					else 
						System.out.print(" X");
				}
				System.out.println();
			}
			System.out.println();
		}
	
	}
}
