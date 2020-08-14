package com.distributed.id.leaf.manual.snowflake;

import com.distributed.id.leaf.manual.IDGen;
import com.distributed.id.leaf.manual.common.Result;
import com.distributed.id.leaf.manual.common.ZeroIDGen;
import com.distributed.id.leaf.manual.snowflake.exception.InitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class LeafSnowflakeService {
    private IDGen idGen;

    public LeafSnowflakeService(@Value("${leaf.snowflake.enable}") boolean leafSnowflakeEnable,
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
