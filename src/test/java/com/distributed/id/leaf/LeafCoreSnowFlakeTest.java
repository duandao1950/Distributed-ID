package com.distributed.id.leaf;

import com.distributed.id.leaf.core.LeafCoreSnowflakeService;
import com.sankuai.inf.leaf.common.Result;
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
public class LeafCoreSnowFlakeTest {

    @Resource
    private LeafCoreSnowflakeService leafCoreSnowflakeService;

    @Test
    public void test_getResult() {
        for (int i = 0; i < 1000; i++) {
            Result result = leafCoreSnowflakeService.getId("test");
            System.out.println("LeafSnowFlakeTest.id:" + result.getId() + " status: " + result.getStatus());
        }
    }
}
