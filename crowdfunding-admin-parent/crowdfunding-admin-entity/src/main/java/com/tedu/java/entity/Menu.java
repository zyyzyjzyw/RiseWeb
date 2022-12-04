package com.tedu.java.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private Integer id;
    // 父节点id
    private Integer pid;
    // 节点名称
    private String name;
    //节点附带的URL地址，是将来要跳转的地址
    private String url;

    private String icon;
    //存储子节点的集合，初始化是为了避免空指针异常
    private List<Menu> children = new ArrayList<>();
    // 控制节点是否默认打开装，设置为true,表示默认打开
    private Boolean open = true;
}