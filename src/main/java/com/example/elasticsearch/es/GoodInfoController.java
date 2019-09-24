package com.example.elasticsearch.es;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wsl
 * @date 2019/9/24
 */
@RestController(value = "game")
public class GoodInfoController {

    @Autowired
    private GoodReposity goodReposity;

    @GetMapping(value = "/products/save")
    public String query() {
        GoodsInfo goodsInfo = new GoodsInfo(System.currentTimeMillis(),
                "商品"+System.currentTimeMillis(),"这是一个测试商品");
        goodReposity.save(goodsInfo);
        return "success";
    }
}
