package incture.kiran;

import java.util.Scanner;

public class Main {
	private static Scanner sc;

	public static void main(String[] args){
		int blocks, rows , cols, passengers;
		sc = new Scanner(System.in);
		System.out.println("Enter number of blocks in the Airplane");
		blocks=sc.nextInt();
		for(int i=1;i<=blocks;i++) {
			System.out.println("Enter the dimention of "+i+" block");
			System.out.println("Enter row");
			rows=sc.nextInt();
			System.out.println("Enter Columns");
			cols=sc.nextInt();
			Arrange.addBlock(rows, cols);
		}
		System.out.println("Enter total number of passengers.");
		passengers = sc.nextInt();
		Arrange.maxPassengers=passengers;
		if(passengers>Arrange.maxCapacity())
		{
			System.err.println("Number of passengers are exceeding the maximum possible passengers onboard\nSome passengers may get left out");
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Arrange.makeArrangements();
		Arrange.displayFirst();
	}

}
