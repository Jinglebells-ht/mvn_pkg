package hn.cch;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.File;

public class AppMain {

    private static Logger logger = LoggerFactory.getLogger(AppMain.class);


    public static final String USER_DIR = System.getProperty("user.dir");

    public static final String ETC_DIR = USER_DIR + File.separator + "etc";

    public static final String LOG_PATH = ETC_DIR + File.separator + "log.properties";

    public static final String BEAN_PATH = ETC_DIR + File.separator + "bean.xml";


    public static void main(String[] args) {


        PropertyConfigurator.configure(LOG_PATH);

        ApplicationContext ctx = new FileSystemXmlApplicationContext(BEAN_PATH);
        String[] beanNames = ctx.getBeanDefinitionNames();
        for (String beanName:beanNames) {
            logger.debug("new bean name : " + beanName);
        }
        // ctx.getBean("")


        System.out.println("mvn pkg");
        logger.info("mvn pkg");
    }
}
