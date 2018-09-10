package com.htht.huoy.common.web;

import com.baomidou.mybatisplus.plugins.Page;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class CommonController {
    protected Page getPage(HttpServletRequest request){
        String start=request.getParameter("start");
        String l=request.getParameter("length");
        int size=StringUtils.isEmpty(l)?10:Integer.valueOf(l);

        int current=StringUtils.isEmpty(start)?1:(Integer.valueOf(start)/size+1);
        Page page=new Page<>();
        page.setCurrent(current);
        page.setSize(size);
        return page;

    }
}
