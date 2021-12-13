/**

 * 
 */
package test;

import org.junit.Assert;
import org.junit.Test;
import app.AdminApplication;



/**
 * @author Cesar Torres
 *
 */
public class AdminApplicationTest {

	/**
	 * Test method for {@link app.AdminApplication#main(java.lang.String[])}.
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testReadFromFile() {
		AdminApplication app = new AdminApplication();
		Assert.assertEquals("out.json", app.equals("out.json"));

		
	}
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testSaveToFile() {
		AdminApplication app = new AdminApplication();
		Assert.assertEquals("out.json", app.equals("out.json"));

		
	}
	@Test
	public void testChooseAction() {
		AdminApplication app = new AdminApplication();
		Assert.assertEquals("U","R", app.equals("U","R"));

		
	}
}
