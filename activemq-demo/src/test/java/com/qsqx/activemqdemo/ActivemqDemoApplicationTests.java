package com.qsqx.activemqdemo;

import com.qsqx.activemqdemo.enums.CCBBankCertEnum;
import com.qsqx.activemqdemo.utils.RandomUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class ActivemqDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
    }

    public static void main(String[] args) {
        System.out.println(RandomUtil.getStatementNumber());
    }
}
