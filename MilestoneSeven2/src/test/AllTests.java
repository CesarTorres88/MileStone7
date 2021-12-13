package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import app.StoreFront;

@RunWith(Suite.class)
@SuiteClasses({ AdminApplicationTest.class, ProductTest.class, StoreFront.class})
public class AllTests {

}
