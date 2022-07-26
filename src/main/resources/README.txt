-- How to test RibbonJT applications --

The following endpoints are available for testing:

http://localhost:9090/invoke

For an explanation behind the applications:

1) Take the "name" value in the @RibbonClient annotation of this application's rest controller class.

2) Take the value in the @RequestMapping annotation of the other application's rest controller class.

3) Within the rest controller class of this application, call the RestTemplate object's .getForObject() method.

4) "template.getForObject("http://<service-name>/<endpoint-mapping>/<endpoint-uri>", String.class)"
    Where <service-name> is the value from Step 1.
    Where <endpoint-mapping> is the value from Step 2.
    Where <endpoint-uri> is the specific endpoint URI you want to call, from the other applications.
    This will map this application's controller methods to the endpoints of the other applications.

5) In the properties file, make sure you configure the settings for <service-name>.
    Ensure that a list of servers is provided for load-balancing purposes.

6) Run multiple instances of the other application in parallel, then test the endpoints.