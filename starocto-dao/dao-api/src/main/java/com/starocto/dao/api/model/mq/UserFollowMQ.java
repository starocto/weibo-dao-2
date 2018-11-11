package com.starocto.dao.api.model.mq;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 16:04
 * ---------------------------------------
 * Desc   : 关注好友或取消关注好友，异步
 */
@Data
public class UserFollowMQ implements Serializable {

    private static final long serialVersionUID = -1L;

    private int userId;
    private int followUserId;
    /**
     * 关注还是取消关注：true 关注  false 取消关注
     */
    private boolean follow;
}
