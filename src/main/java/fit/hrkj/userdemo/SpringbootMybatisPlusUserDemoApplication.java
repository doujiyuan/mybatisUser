package fit.hrkj.userdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("fit/hrkj/userdemo/mapper")
public class SpringbootMybatisPlusUserDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisPlusUserDemoApplication.class, args);
    }

}
