package driverScripts.sample;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeSuite;

public class PriorityAnalyzer {
  @Test(priority=11)
  public void f() {
	  System.out.println("User in F");
  }
  @Test(priority=-8)
  public void c() {
	  System.out.println("User in C");
  }
  @Test(priority=101)
  public void a() {
	  System.out.println("User in A");
  }
  @Test(priority=120)
  public void b() {
	  System.out.println("User in B");
  }
  @BeforeSuite
  public void beforeSuite() {
  }

}
