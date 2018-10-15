package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.util.Date;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 17:13
 * ---------------------------------------
 * Desc   : 消息评论（微博消息的一条评论）
 */
@Data
public class CommentToBlogResp {
    private long commentId;
    private long blogId;
    private long frontCommentId;
    private int userId;
    private int frontUserId;
    private String commentContent;
    private Date commentTime;
}
