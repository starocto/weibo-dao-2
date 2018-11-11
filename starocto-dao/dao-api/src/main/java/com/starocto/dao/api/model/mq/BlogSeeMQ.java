package com.starocto.dao.api.model.mq;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 16:42
 * ---------------------------------------
 * Desc   : 观看，异步，这里只是给微博消息统计使用，没有建立观看历史的索引
 */
@Data
public class BlogSeeMQ implements Serializable {

    private static final long serialVersionUID = -1L;

    private long blogId;
    private int userId;
}
