package com.vttp2022.ssfminiproject01.mvcservice;

import com.vttp2022.ssfminiproject01.mvcmodels.Lists;

public interface RedisSaveIntf {
    public void saveLists(String username , Lists model);
}
