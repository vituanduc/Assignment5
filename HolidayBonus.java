
public class HolidayBonus {
	
	
	/**
	 * Calculates the holiday bonus for each store
	 * @param data the two dimensional array of store sales
	 * @param high  bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store
	 */
	public static double[] calculateHolidayBonus(double[][] data, 
			double high, double low, double other) {
		
		//TwoDimRaggedArrayUtility rag = new TwoDimRaggedArrayUtility();
		double [] bonus = new  double [data.length];
		double [] maxInCol = new double [10];
		double [] minInCol = new double [10];
		/*
		for(int i= 0; i<10;i++) {
			maxInCol[i]=TwoDimRaggedArrayUtility.getHighestInColumn(data, i);
			minInCol[i]=TwoDimRaggedArrayUtility.getLowestInColumn(data, i);
		}*/
		
		for(int i = 0; i < data.length ;i++) {
			for(int j = 0; j< data[i].length ; j++) {
				if(data[i][j]<=0) {
					bonus[i]+=0;
				}else if(data[i][j]==TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					bonus[i]+=high;
				}else if(data[i][j]==TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
					bonus[i]+=low;
				}else {
					bonus[i]+=other;
				}				
			}	
		}
		
		return bonus;
	}

	/**
	 * Calculates the total holiday bonuses
	 * @param data the two dimensional array of store sales
	 * @param high  bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, 
			double high, double low, double other) {
		double [] bonus = calculateHolidayBonus(data, high, low, other);
		double total = 0;
		for(int i = 0; i < bonus.length ;i++) {
			total+=bonus[i];
		}
		
		return total;
		
	}
}
