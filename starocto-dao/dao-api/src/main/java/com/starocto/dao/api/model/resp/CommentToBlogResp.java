package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 17:13
 * ---------------------------------------
 * Desc   : 消息评论（微博消息的一条评论）
 */
@Data
public class CommentToBlogResp implements Serializable {

    private static final long serialVersionUID = -1L;

    private long commentId;
    private long blogId;
    private long frontCommentId;
    private int userId;
    private int frontUserId;
    private String commentContent;
    private String commentTime;
}
