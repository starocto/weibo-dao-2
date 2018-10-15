package com.starocto.dao.db.model;

import lombok.Data;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 17:10
 * ---------------------------------------
 * Desc   : 消息统计（一条微博消息的一些统计数据）
 */
@Data
public class BlogCountDO {
    private long blogId;
    private int blogSeeNum;
    private int blogLikeNum;
    private int blogForwardNum;
    private int blogCommentNum;
}
