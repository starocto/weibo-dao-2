package com.starocto.dao.api.model.resp;

import lombok.Data;

import java.io.Serializable;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 16:52
 * ---------------------------------------
 * Desc   : 用户的关注人的信息
 */
@Data
public class UserFollowResp implements Serializable {

    private static final long serialVersionUID = -1L;

    private int followId;
    private int userId;
    private int followUserId;
    private boolean followIsFriend;
    private String followTime;
}
