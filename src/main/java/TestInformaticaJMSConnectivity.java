import javax.naming.InitialContext;
import java.util.Properties;

public class TestInformaticaJMSConnectivity {
    public static void main(String a[]) throws Exception {
        TestInformaticaJMSConnectivity test = new TestInformaticaJMSConnectivity();
        test.testConnection();
        System.exit(0);
    }

    private void testConnection() throws Exception
    {
        Properties props = new Properties();
        props = new Properties();
        props.setProperty("java.naming.factory.initial",
                "com.sun.enterprise.naming.SerialInitContextFactory");
        props.setProperty("java.naming.factory.url.pkgs",
                "com.sun.enterprise.naming");
        props.setProperty("java.naming.factory.state",
                "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");
        props.setProperty("org.omg.CORBA.ORBInitialHost", "usxo-ditdapp00");
        props.setProperty("org.omg.CORBA.ORBInitialPort", "9810");
        props.setProperty("com.sun.corba.ee.transport.ORBTCPTimeouts",
                "500:30000:30:999999");
        props.setProperty("com.sun.jndi.ldap.connect.timeout", "500");
        // Create the initial context for remote JMS server
        InitialContext cntxt = new InitialContext(props);
        System.out.println("Context Created ");
        // JNDI Lookup for TopicConnectionFactory in remote JMS Provider
        Object obj = cntxt.lookup("siperian.sif.phors.jms.queue");
        System.out.println("Factory available");
        cntxt.close();
    }
}
