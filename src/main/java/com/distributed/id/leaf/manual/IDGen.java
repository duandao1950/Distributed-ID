package com.distributed.id.leaf.manual;


import com.distributed.id.leaf.manual.common.Result;

public interface IDGen {
    Result get(String key);
    boolean init();
}
