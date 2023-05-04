package vsu.cs.tech;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import vsu.cs.tech.configuration.DumbConfig;
import vsu.cs.tech.service.DataService;

@Configuration
@ComponentScan(basePackageClasses = {DumbConfig.class, DataService.class})
public class TechApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(TechApplication.class);
        DataService data = context.getBean(DataService.class);
        data.insertData();
        data.printTable();
//        data.printIndexes();
//        data.printSubjectByDesc();
    }

}
