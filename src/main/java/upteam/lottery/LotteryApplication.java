package upteam.lottery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author 周廷宇
 */
@ServletComponentScan(basePackages = "upteam.lottery.config")
@MapperScan("upteam.lottery.infra.mapper")
@ComponentScan(basePackages = {"upteam.lottery.config", "upteam.lottery.api", "upteam.lottery.app", "upteam.lottery.infra.repository", "upteam.lottery.infra.util"})
@SpringBootApplication
public class LotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryApplication.class, args);
    }

}

