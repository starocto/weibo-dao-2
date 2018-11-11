package com.starocto.dao.api.model.mq;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 16:11
 * ---------------------------------------
 * Desc   : 生产一条消息评论，异步存储
 */
@Data
public class CommentToBlogMQ implements Serializable {

    private static final long serialVersionUID = -1L;

    private long blogId;
    private long frontCommentId;
    private int userId;
    private int frontUserId;
    private String commentContent;
    private String commentTime;
}
