package competition;

/**
 * Competitor class.
 */
public class Competitor {

	/** the competitor name*/
	private String name;
	/** the competitor current points*/
	private int point;

	/** constructor
	 * @param name {String} the competitor name.
	 */
	public Competitor(String name){
		this.name = name;
		this.point = 0;
	}

	/** return the name of the competitor.
	 * @return {String} competitor's name.
	*/
	public String toString() {
		return this.name;
	}

	/** return the name of the competitor.
	 * @return {String} competitor's name.
	*/
	public String getName() {
		return this.name;
	}

	/** return the number of point of the competitor.
	 * @return {String} the number of point of the competitor..
	*/
	public int getPoint(){
		return this.point;
	}

	/** increse the number of point of the competitor.
	* @param point {point} the points to add to the current.
	*/
	public void addPoint(int point){
		this.point += point;
	}

	/** check if the competitor is equals to another object.
	 * two competitor are equals, if they have the same name.
	 * so we will assume each competitor has an unique name.
	 * @param {Object} object to compare with.
	*/
	public boolean equals(Object o){
		Competitor object_to_competitor;
		if (!(o instanceof Competitor)){
			return false;
		}

		object_to_competitor = (Competitor) o;
		return object_to_competitor.getName() == this.name;

	}
}
