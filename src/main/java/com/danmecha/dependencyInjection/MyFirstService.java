package com.danmecha.dependencyInjection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@PropertySource("classpath:custom.properties") //specify where the value annotation will home in on
//if I have numerous property files this is how it is done
//@PropertySources({
//        @PropertySource("classpath:custom.properties")
//})
public class MyFirstService {

    //using the environment bean
    private Environment environment;

    //using value to fetch a variable from the system env
    @Value("${my.name:Richard}")
    private String name;

    private MyFirstClass myFirstClass;

//    Field injection of a dependency
//    @Autowired
//    @Qualifier("bean1")


//    constructor injection
    @Autowired // this is optional if the constructor has just one argument
    private MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }


    public String tellAStory() {
        return "the dependency is saying : " + myFirstClass.getVar();
    }

    @Autowired
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public String getJavaVersion() {
        return "the dependency is saying : " + environment.getProperty("java.version");
    }
}
