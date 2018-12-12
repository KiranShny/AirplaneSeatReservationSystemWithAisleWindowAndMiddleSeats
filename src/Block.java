package incture.kiran;

public class Block {
	private int[][] block;
	private int max;
	private int row,col;

	public Block(int row,int col)
	{
		this.block=new int[row][col];
		this.row=row-1;
		this.col=col-1;
		this.max=(row)*(col);
	}
	
	public int getMax() {
		return max;
	}
	public int getRow() {
		return row;
	}
	public int getCol() {
		return col;
	}
	public void setCellValue(int row, int col, int val)
	{
		block[row][col]=val;
	}
	public int getCellValue(int row,int col)
	{
		return this.block[row][col];	
	}
}
