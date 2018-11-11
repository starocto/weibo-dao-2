package com.starocto.dao.api.service;

import com.starocto.dao.api.model.resp.*;

import java.util.List;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 12:32
 * ---------------------------------------
 * Desc   : 微博查询接口
 */
public interface WeiboQueryService {

    BlogCountResp queryBlogCount(long blogId);

    BlogInfoListResp queryBlogInfo(int userId);

    List<CommentToBlogResp> queryCommentToBlog(long blogId);

    List<UserFollowResp> queryUserFollow(int userId);

    List<UserFollowResp> queryFans(int followUserId);

    UserInfoResp queryUserInfo(int userId);

    UserOthersResp queryUserOthers(int userId);

    UserRegisterInfoResp queryUserRegisterInfo(String userName);
}
