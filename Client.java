import java.util.ArrayList;
import java.util.List;

public class Client {
	static Stack<List<Integer>> stack;
	
	public static void main(String[] args) {
		stack=new Stack<>();
		int[][] arr= {{1,2,5,3},{9,3,8,3},{7,8,2,9},{6,3,1,7}};
		int min=getMinWeight(arr,0,0,Integer.MAX_VALUE);
		while(!stack.isEmpty()) {
			List<Integer> temp=stack.pop();
			int newTemp=arr[temp.get(0)][temp.get(1)];
			if(newTemp<min) {
				int localMin=getMinWeight(arr,temp.get(0),temp.get(1),min);
				if(localMin<min)min=localMin;
			}
		}
		System.out.println(min);
	}
	
	public static int getMinWeight(int[][] arr,int rowNum,int colNum,int globalMinSoFar) {
		int minWeight=arr[rowNum][colNum];
		boolean hasReachedEnd=false;
		while(!hasReachedEnd) {
			int addRow=rowNum+1;
			int addCol=colNum+1;
			int addRowElement=Integer.MAX_VALUE,addColElement=Integer.MAX_VALUE;
			if(addRow<arr.length)addRowElement=arr[addRow][colNum];
			if(addCol<arr.length)addColElement=arr[rowNum][addCol];
			if(addRow>=arr.length && addCol>=arr.length)return minWeight;
			if(addRowElement<addColElement) {
				if(addRowElement>minWeight)minWeight=addRowElement;
				if(addColElement!=Integer.MAX_VALUE) {
					List<Integer> temp=new ArrayList<>();
					temp.add(0,rowNum);
					temp.add(1,addCol);
				}
				rowNum=addRow;
				if(minWeight>globalMinSoFar)return minWeight;
			}else {
				if(addColElement>minWeight)minWeight=addColElement;
				if(addRowElement!=Integer.MAX_VALUE) {
					List<Integer> temp=new ArrayList<>();
					temp.add(0,addRow);
					temp.add(1,colNum);
				}
				colNum=addCol;
				if(minWeight>globalMinSoFar)return minWeight;
			}
		}
	  return minWeight;	
	}
}
