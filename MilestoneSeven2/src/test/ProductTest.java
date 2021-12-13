/**
 * 
 */
package test;

import org.junit.Test;


import app.Product;
import app.StoreFront;

/**
 * @author Cesar Torres
 *
 */
public class ProductTest {
	StoreFront app = new StoreFront();
	Product<Object> item = new Product<Object>();

	/**
	 * Test method for {@link app.Product#add(java.lang.Object)}.
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testMain() {
		item.setName("Nike");
		item.setDescription("Shoes");
		item.setQuantity((int) 2);
		item.setPrice((double) 2.00);

		
		Product<Object> newItem2 = new Product<Object>();
		equals(newItem2);
	}

}