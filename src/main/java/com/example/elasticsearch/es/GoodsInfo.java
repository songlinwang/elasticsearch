package com.example.elasticsearch.es;

import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @author wsl
 * @date 2019/9/24
 */
@Document(indexName = "goods", type = "goodsinfo")
public class GoodsInfo {
    private String id;
    private String name;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GoodsInfo(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }


    public GoodsInfo() {
    }
}
