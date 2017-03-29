package com.lawyee.myrecycle;

/**
 * All rights Reserved, Designed By www.lawyee.com
 *
 * @version V 1.0 xxxxxxxx
 * @Title: MyRecycle
 * @Package com.lawyee.myrecycle
 * @Description: $todo$
 * @author: YFL
 * @date: 2017/3/29 20:39
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2017 www.lawyee.com Inc. All rights reserved.
 * 注意：本内容仅限于北京法意科技有限公司内部传阅，禁止外泄以及用于其他的商业目
 */

public class Fruit {
    private String name;
    private int imageid;

    public Fruit(String name, int imagerid) {
        this.name = name;
        this.imageid = imagerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageid() {
        return imageid;
    }

    public void setImageid(int imageid) {
        this.imageid = imageid;
    }
}
