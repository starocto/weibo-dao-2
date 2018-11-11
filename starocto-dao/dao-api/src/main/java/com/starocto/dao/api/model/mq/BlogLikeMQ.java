package com.starocto.dao.api.model.mq;

import lombok.Data;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 16:51
 * ---------------------------------------
 * Desc   : 点赞或收藏，异步，这里只是给微博消息统计使用，没有建立点赞或收藏的索引
 */
@Data
public class BlogLikeMQ {

    private static final long serialVersionUID = -1L;

    private long blogId;
    private int userId;
    /**
     * 点赞还是取消点赞：true 点赞  false 取消点赞
     */
    private boolean like;
}
