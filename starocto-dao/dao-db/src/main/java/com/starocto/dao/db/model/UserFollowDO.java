package com.starocto.dao.db.model;

import lombok.Data;

import java.sql.Date;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 16:52
 * ---------------------------------------
 * Desc   : 用户的关注人的信息
 */
@Data
public class UserFollowDO {
    private int followId;
    private int userId;
    private int followUserId;
    private boolean followIsFriend;
    private Date followTime;
}
