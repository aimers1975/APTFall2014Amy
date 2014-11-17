import junit.framework.*;
import com.mockobjects.servlet.*;
import java.io.*;
import java.text.DecimalFormat;


public class TestTestingLabConverterServlet extends TestCase {
	
	public void test_invalid_parameter() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();

    System.out.println("Running sample test");


    String badParam = "boo!";
    request.setupAddParameter("farenheitTemperature", badParam);
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    assertEquals("<html><head><title>Bad Temperature</title>" + "</head><body><h2>Need to enter a valid temperature!" + "Got a NumberFormatException on " 
					+ badParam
					+ "</h2></body></html>\r\n",response.getOutputStreamContents());
  }

  public void test_null_temp() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();


    request.setupAddParameter("dummyParameter", "0");
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    assertEquals("<html><head><title>No Temperature</title>"
					+ "</head><body><h2>Need to enter a temperature!"
					+ "</h2></body></html>\r\n",response.getOutputStreamContents());
  }

  public void test_valid_temp() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();

    String goodParam = "50";
    Double celTempDouble = 100.0*(Double.parseDouble(goodParam) - 32.0)/180.0;
	DecimalFormat df = new DecimalFormat("#.##");
	String celTemp = df.format(celTempDouble);

    request.setupAddParameter("farenheitTemperature", goodParam);
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    assertEquals("<html><head><title>Temperature Converter Result</title>"
					+ "</head><body><h2>" + goodParam + " Farenheit = " + celTemp + " Celsius "
					+ "</h2>\r\n" + "<p><h3>The temperature in Austin is 451 degrees Farenheit</h3>\r\n</body></html>\r\n",response.getOutputStreamContents());
  }
}