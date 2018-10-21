package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 17:10
 * ---------------------------------------
 * Desc   : 消息统计（一条微博消息的一些统计数据）
 */
@Data
public class BlogCountResp implements Serializable {

    private static final long serialVersionUID = -1L;

    private long blogId;
    private int blogSeeNum;
    private int blogLikeNum;
    private int blogForwardNum;
    private int blogCommentNum;
}
