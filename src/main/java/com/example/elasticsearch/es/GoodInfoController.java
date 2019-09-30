package com.example.elasticsearch.es;

import static org.elasticsearch.index.query.QueryBuilders.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.elasticsearch.index.query.Operator;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.PageRequest.*;
import org.springframework.data.domain.Pageable;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wsl
 * @date 2019/9/24
 */
@RestController()
public class GoodInfoController {

    @Autowired
    private GoodRepository goodRepository;

    @GetMapping(value = "/products/save")
    public String save() {
        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis()+"",
                "大", "这是一款");
        goodRepository.save(goodsInfo);
        return "success";
    }

    @GetMapping(value = "/products/get")
    public String query() {
        GoodsInfo goodsInfo = goodRepository.getGoodsInfoByName("商品1569341307641");
        return JSONObject.toJSONString(goodsInfo);
    }

    @GetMapping(value = "/products/template/get")
    public String queryTemplate(@RequestParam String word) {
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        //Pageable pageable = new PageRequest(0,20,sort);

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery(word).defaultOperator(Operator.AND).minimumShouldMatch("50%")).withPageable(PageRequest.of(0, 20, sort)).build();
        List<GoodsInfo> list = goodRepository.search(searchQuery).getContent();
        /*for (GoodsInfo goodsInfo : list) {
            System.out.println(JSONObject.toJSON(goodsInfo));
        }*/
        return JSON.toJSON(list).toString();
    }
}
