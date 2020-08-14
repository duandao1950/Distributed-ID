package com.distributed.id.leaf.core;


import com.sankuai.inf.leaf.IDGen;
import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.ZeroIDGen;
import com.sankuai.inf.leaf.snowflake.SnowflakeIDGenImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LeafCoreSnowflakeService {
    private IDGen idGen;

    public LeafCoreSnowflakeService(@Value("${leaf.snowflake.enable}") boolean leafSnowflakeEnable,
            @Value("${leaf.snowflake.zk.address}") String leafSnowflakeZkAddress,
            @Value("${leaf.snowflake.zk.port}") int leafSnowflakeZkPort) throws InitException {
        if (leafSnowflakeEnable) {
            idGen = new SnowflakeIDGenImpl(leafSnowflakeZkAddress, leafSnowflakeZkPort);
            if (idGen.init()) {
                log.info("Snowflake Service Init Successfully");
            } else {
                throw new InitException("Snowflake Service Init Fail");
            }
        } else {
            idGen = new ZeroIDGen();
            log.info("Zero ID Gen Service Init Successfully");
        }
    }

    public Result getId(String key) {
        return idGen.get(key);
    }
}
