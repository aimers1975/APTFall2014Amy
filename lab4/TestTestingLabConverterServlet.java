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

public void test_valid_temp_neg() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();

    String goodParam = "-3.14";
    Double celTempDouble = 100.0*(Double.parseDouble(goodParam) - 32.0)/180.0;
  DecimalFormat df = new DecimalFormat("#.##");
  String celTemp = df.format(celTempDouble);

    request.setupAddParameter("farenheitTemperature", goodParam);
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    System.out.println("Expected celcius temp: " + celTemp);
    assertEquals("<html><head><title>Temperature Converter Result</title>"
          + "</head><body><h2>" + goodParam + " Farenheit = " + celTemp + " Celsius "
          + "</h2>\r\n" + "<p><h3>The temperature in Austin is 451 degrees Farenheit</h3>\r\n</body></html>\r\n",response.getOutputStreamContents());
  }

public void test_valid_temp_0() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();

    String goodParam = "0";
    Double celTempDouble = 100.0*(Double.parseDouble(goodParam) - 32.0)/180.0;
  DecimalFormat df = new DecimalFormat("#.##");
  String celTemp = df.format(celTempDouble);

    request.setupAddParameter("farenheitTemperature", goodParam);
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    System.out.println("Expected celcius temp: " + celTemp);
    assertEquals("<html><head><title>Temperature Converter Result</title>"
          + "</head><body><h2>" + goodParam + " Farenheit = " + celTemp + " Celsius "
          + "</h2>\r\n" + "<p><h3>The temperature in Austin is 451 degrees Farenheit</h3>\r\n</body></html>\r\n",response.getOutputStreamContents());
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
    System.out.println("Expected celcius temp: " + celTemp);
    request.setupAddParameter("farenheitTemperature", goodParam);
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    assertEquals("<html><head><title>Temperature Converter Result</title>"
					+ "</head><body><h2>" + goodParam + " Farenheit = " + celTemp + " Celsius "
					+ "</h2>\r\n" + "<p><h3>The temperature in Austin is 451 degrees Farenheit</h3>\r\n</body></html>\r\n",response.getOutputStreamContents());
  }

  public void test_valid_temp_32() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();

    String goodParam = "32";
    Double celTempDouble = 100.0*(Double.parseDouble(goodParam) - 32.0)/180.0;
    DecimalFormat df = new DecimalFormat("#.#");
    String celTemp = df.format(celTempDouble);
    System.out.println("Expected celcius temp: " + celTemp);
    request.setupAddParameter("farenheitTemperature", goodParam);
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    assertEquals("<html><head><title>Temperature Converter Result</title>"
          + "</head><body><h2>" + goodParam + " Farenheit = " + celTemp + " Celsius "
          + "</h2>\r\n" + "<p><h3>The temperature in Austin is 451 degrees Farenheit</h3>\r\n</body></html>\r\n",response.getOutputStreamContents());
  }

  public void test_valid_temp_213() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();

    String goodParam = "213";
    Double celTempDouble = 100.0*(Double.parseDouble(goodParam) - 32.0)/180.0;
    DecimalFormat df = new DecimalFormat("#.#");
    String celTemp = df.format(celTempDouble);
    System.out.println("Expected celcius temp: " + celTemp);
    request.setupAddParameter("farenheitTemperature", goodParam);
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    assertEquals("<html><head><title>Temperature Converter Result</title>"
          + "</head><body><h2>" + goodParam + " Farenheit = " + celTemp + " Celsius "
          + "</h2>\r\n" + "<p><h3>The temperature in Austin is 451 degrees Farenheit</h3>\r\n</body></html>\r\n",response.getOutputStreamContents());
  }

  public void test_invalid_temp_7e52() throws Exception {
    TestingLabConverterServlet s = new TestingLabConverterServlet();
    MockHttpServletRequest request = 
      new MockHttpServletRequest();
    MockHttpServletResponse response = 
      new MockHttpServletResponse();

    String goodParam = "7E52";
    Double celTempDouble = 100.0*(Double.parseDouble(goodParam) - 32.0)/180.0;
    DecimalFormat df = new DecimalFormat("#.#");
    String celTemp = df.format(celTempDouble);
    System.out.println("Expected number format exception.");
    request.setupAddParameter("farenheitTemperature", goodParam);
    response.setExpectedContentType("text/html");
    s.doGet(request,response);
    response.verify();
    assertFalse(response.getOutputStreamContents().equals("<html><head><title>Temperature Converter Result</title>"
          + "</head><body><h2>" + goodParam + " Farenheit = " + celTemp + " Celsius "
          + "</h2>\r\n" + "<p><h3>The temperature in Austin is 451 degrees Farenheit</h3>\r\n</body></html>\r\n"));
  }
}