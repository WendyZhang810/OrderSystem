package com.wendy.service.impl;

import com.wendy.mapper.CatalogMapper;
import com.wendy.pojo.Catalog;
import com.wendy.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {
    @Autowired
    private CatalogMapper catalogMapper;


    @Override
    public List<Catalog> getAll() {
        return catalogMapper.getAll();
    }
}
