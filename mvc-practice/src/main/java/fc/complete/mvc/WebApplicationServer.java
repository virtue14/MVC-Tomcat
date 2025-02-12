package fc.complete.mvc;

import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServer {

    public static final String WEBAPP_DIR_LOCATION = "webapps";
    private static final Logger log = LoggerFactory.getLogger(WebApplicationServer.class);
    public static final int PORT = 8080;

    public static void main(String[] args) throws Exception {

        // /WEB-INF/classes
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(PORT);

        tomcat.addWebapp("/", new File(WEBAPP_DIR_LOCATION).getAbsolutePath());
        log.info("configuring app with basedir: {}", new File("./").getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
