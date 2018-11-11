package com.starocto.dao.index.service;

import com.starocto.dao.api.model.mq.BlogInfoMQ;
import com.starocto.dao.api.model.mq.CommentToBlogMQ;
import com.starocto.dao.api.model.mq.UserOthersMQ;
import com.starocto.dao.api.model.req.UserRegisterInfoReq;
import com.starocto.dao.db.model.*;

import java.util.List;

/**
 * Author : zjx@.com
 * Date   : 2018/11/11
 * Time   : 17:04
 * ---------------------------------------
 * Desc   : 向数据库中写入数据
 */
public interface WeiboIndexService {

    void indexBlogCountDO(List<BlogCountDO> blogCountDO);

    void indexBlogInfoDO(List<BlogInfoMQ> blogInfoMQS);

    void indexCommentToBlogDO(List<CommentToBlogMQ> commentToBlogMQS);

    void indexUserFollowDO(List<UserFollowDO> userFollowDO);

    void indexUserInfoDO(List<UserInfoDO> userInfoDO);

    void indexUserOthersDO(List<UserOthersMQ> userOthersMQS);

    void indexUserRegisterInfoDO(List<UserRegisterInfoReq> userRegisterInfoReqs);

    void updateUserFollowDO(List<UserFollowDO> userFollowDO);
}
