package com.distributed.id.leaf;

import com.distributed.id.leaf.manual.common.Result;
import com.distributed.id.leaf.manual.snowflake.SnowflakeService;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author zhoushu
 * @Date 2020/8/12
 * @Description
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SonwFlakeServiceTest {

    @Resource
    private SnowflakeService snowflakeService;

    @Test
    public void test_getResult() {
        for (int i = 0; i < 1000; i++) {
            Result result = snowflakeService.getId("test");
            System.out.println("LeafSnowFlakeTest.id:" + result.getId() + " status: " + result.getStatus());
        }
    }
}
