/**
 * This class defines a plot and the feild's holding the 
 * data to construct a plot 
 * @author William Batres
 *
 */
public class Plot {

	private int x;
	private int y;
	private int width;
	private int depth;
	
	
	/**
	 * No-arg Constructor, creates a Plot with x=0, y=0, width=1, depth=1
	 */
	public Plot()
	{
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;

	}
	
	/**
	 * Copy Constructor, creates a new object using the information 
	 * of the object passed to it.
	 * @param p the plot object  
	 */
	
	public Plot(Plot p)
	{
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	/**
	 * Parameterized Constructor that creates an objext using the 
	 * information passed in
	 * @param x  - horizontal coordinate of upper left corner
	 * @param y- vertical coordinate of upper left corner
	 * @param width  - horizontal size
	 * @param depth - vertical size
	 */
	
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * This Method will check if one plot overlaps another plot using the x and 
	 * y coordinates 
	 * @param plot Takes a plot object as a argument to compare 
	 * @return returns true if the two do overlap or false if not
	 */
	public boolean overlaps(Plot plot)
	{


		//plot coordinates--x
		int xLeftCoordinate_plot = plot.getX();
		int xRightCoordinate_plot = plot.getX()+ plot.getWidth();
		
		//plot coordinates--y
		int yTopCoordinate_plot = plot.y;
		int yBottomCoordinate_plot = plot.y + plot.depth;
		
		//this coordinates--x
		int xLeftCoordinate = this.x;
		int xRightCoordinate = this.x + this.width;
		
		//this coordinates--y
		int yTopCoordinate = this.y;
		int yBottomCoordinate = this.y + this.depth;
		if(xLeftCoordinate_plot == xLeftCoordinate && yBottomCoordinate_plot < yBottomCoordinate)
		{
			if(yTopCoordinate_plot >= yTopCoordinate && yTopCoordinate < yBottomCoordinate_plot)
				return true;
			else if(yTopCoordinate < yTopCoordinate_plot && yBottomCoordinate < yBottomCoordinate_plot)
			{
				return true;
			}
			return false;
		}
		else if(xLeftCoordinate_plot < xLeftCoordinate && xLeftCoordinate < xRightCoordinate_plot)
		{
			if(xLeftCoordinate_plot == xLeftCoordinate && xRightCoordinate_plot < xRightCoordinate )
				return true;
			if(yTopCoordinate_plot < yTopCoordinate && yTopCoordinate < yBottomCoordinate_plot)
				return true;
			else if(yTopCoordinate_plot > yTopCoordinate && yTopCoordinate_plot < yBottomCoordinate)
					return true;
			else if(yTopCoordinate_plot == yTopCoordinate && yTopCoordinate_plot == yBottomCoordinate)
					return true;
			else if(yTopCoordinate_plot > yTopCoordinate && yTopCoordinate_plot < yBottomCoordinate)
				return true;
			else				
					return false;
				
		}
		else if(xLeftCoordinate_plot == xLeftCoordinate && yBottomCoordinate_plot == yBottomCoordinate)
		{
				return true;
		}
		else if(xLeftCoordinate_plot == xLeftCoordinate && yTopCoordinate == yBottomCoordinate_plot)
		{
			return true;
		}
		else
		{
			if(xLeftCoordinate_plot < xRightCoordinate && xRightCoordinate < xRightCoordinate_plot)
			{
				if(yTopCoordinate_plot <= yTopCoordinate && yTopCoordinate <= yBottomCoordinate_plot)
					return true;
				else if(yTopCoordinate_plot > yTopCoordinate && yTopCoordinate_plot < yBottomCoordinate)
						return true;
					else
						return false;
					
			}
		}
	return false;
		
	}
	
	/**
	 * This method checks if two plots encompass one another meaning one being in 
	 * the other
	 * @param plot Takes a plot object as an argument that will be used to be compared
	 * @return Returns true if one does encompass another and false if not
	 */
	public boolean encompasses(Plot plot)
	{

		
		//plot coordinates--x
		int xLeftCoordinate_plot = plot.getX();
		int xRightCoordinate_plot = plot.getX()+ plot.getWidth();
		
		//plot coordinates--y
		int yTopCoordinate_plot = plot.y;
		int yBottomCoordinate_plot = plot.y + plot.depth;
		
		//this coordinates--x
		int xLeftCoordinate = this.x;
		int xRightCoordinate = this.x + this.width;
		
		//this coordinates--y
		int yTopCoordinate = this.y;
		int yBottomCoordinate = this.y + this.depth;
		
		
		if(xLeftCoordinate <= xLeftCoordinate_plot && xRightCoordinate >= xRightCoordinate_plot)
			return true;
		if(yTopCoordinate <= yTopCoordinate_plot && yBottomCoordinate >= xRightCoordinate_plot)
			return true;
		return false;
	}
	
	
	/**
	 * Gets the x coordinates of the current plot
	 * @return x coordinates
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinates of the corresponding plot
	 * @param x integer variable that gets assigned to the x coordinates
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y coordinates of the current plot
	 * @return y coordinates
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinates of the corresponding plot
	 * @param y integer variable that gets assigned to the x coordinates
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the width of the current plot
	 * @return width of the plot
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width value of the plot
	 * @param width Integer value of the width for the plot 
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Returns the value of depth for the plot 
	 * @return depth of the plot
	 */
	public int getDepth() {
		return depth;
	}

	/**
	 * Sets the depth value of the plot 
	 * @param depth integer value assigned to the depth of the plot
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
	/**
	 * To-String method that formats the information and data of the plot object
	 */
	@Override
	public String toString()
	{
		return "Upper left: " + "(" + this.x + "," + this.y + "); " 
				+ "Width: " + this.width + " " + "Depth: " + this.depth;
	}
	

}
