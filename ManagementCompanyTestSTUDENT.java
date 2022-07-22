
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ManagementCompanyTestSTUDENT {
	Property p1,p2,p3,p4,p5,p6;
	ManagementCompany mc;
	
	
	@Before
	public void setUp() throws Exception {
		mc = new ManagementCompany("William", "1324536", 5);
		
		p1 = new Property("Special Oaks", "ForestVale", 2367.00,"Billy Franks", 4,4,2,3);
		p2 = new Property("Waters Landing", "Treefalling", 7345.00, "Amber Lance", 5,4,1,1);
		p3 = new Property("Kings Tower", "Sliver Town", 3351.00, "Henry McMahon", 7,7,1,2);
		
		mc.addProperty(p1);
		mc.addProperty(p2);
		mc.addProperty(p3);
	}

	@After
	public void tearDown() {
		mc = null;
		p1=p2=p3=p4=p5=p6 = null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		p4 = new Property("Long Lands", "DalesVille", 2500.00, "Blake Wilson");
		p5 = new Property("Hill House", "Denver", 4500.00, "Ben Scotts", 6,1,2,2);
		p6 = new Property("Rose Cottage", "Three Lakes", 2050.00, "Luke Hems",3,1,1,1);

		assertEquals(mc.addProperty(p4),3,0);
		assertEquals(mc.addProperty(p5),4,0);
		assertEquals(mc.addProperty(p6),-1,0);
	}
 
	@Test
	public void testMaxRentProp() {
		assertEquals(mc.maxRentProp(),7345.00,0);
		
	}

	@Test
	public void testTotalRent() {
		assertEquals(mc.totalRent(),13063.00,0);
	}

 }