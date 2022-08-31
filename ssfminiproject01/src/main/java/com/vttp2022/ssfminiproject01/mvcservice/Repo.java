package com.vttp2022.ssfminiproject01.mvcservice;

import com.vttp2022.ssfminiproject01.mvcmodels.Results;

public interface Repo {
    public int save(final Results nrs);
    public Results findById(final String nrsId);
    public int update(final Results nrs);
}
