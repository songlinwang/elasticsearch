package com.example.elasticsearch.es;


import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author wsl
 * @date 2019/9/24
 */
@Component
public interface GoodRepository extends ElasticsearchRepository<GoodsInfo, String> {

    GoodsInfo findByName(String name);

    GoodsInfo getGoodsInfoByName(String nameStr);
}
