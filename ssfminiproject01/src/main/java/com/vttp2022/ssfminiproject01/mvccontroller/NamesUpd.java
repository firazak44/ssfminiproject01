package com.vttp2022.ssfminiproject01.mvccontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vttp2022.ssfminiproject01.mvcmodels.Results;
import com.vttp2022.ssfminiproject01.mvcservice.Redis;

@RestController
@RequestMapping(path = "/names", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class NamesUpd {

    private static final Logger logger = LoggerFactory.getLogger(NamesUpd.class);

    // @Autowired
    Redis service;

    @PostMapping
    public ResponseEntity<Results> createNameLists(@RequestBody Results nrs) {
        logger.info(" " + nrs.getDisplayName());
        int x = service.save(nrs);
        if (x > 0)
            nrs.setInsertCount(x);
        return ResponseEntity.ok(nrs);
    }

    @GetMapping(path = "/{nrsId}")
    public ResponseEntity<Results> getListById(@PathVariable String nrsId) {
        Results nrs = service.findById(nrsId);
        return ResponseEntity.ok(nrs);
    }

    @PutMapping(path = "/{nrsId}")
    public ResponseEntity<Results> updateList(@RequestBody Results nrs) {
        int nrsResult = service.update(nrs);
        if (nrsResult > 0)
            nrs.setUpdateCount(nrsResult);
        return ResponseEntity.ok(nrs);
    }
}
