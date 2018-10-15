package com.starocto.dao.db.mapper;

import com.starocto.dao.db.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 12:50
 * ---------------------------------------
 * Desc   :
 */
public interface WeiboDataMapper {

    BlogCountDO selectBlogCountDO(@Param("blogId") long blogId);

    List<BlogInfoDO> selectBlogInfoDO(@Param("userId") int userId);

    List<CommentToBlogDO> selectCommentToBlogDO(@Param("blogId") long blogId);

    List<UserFollowDO> selectUserFollowDO(@Param("userId") int userId);

    List<UserFollowDO> selectFansDO(@Param("followUserId") int followUserId);

    UserInfoDO selectUserInfoDO(@Param("userId") int userId);

    UserOthersDO selectUserOthersDO(@Param("userId") int userId);

    UserRegisterInfoDO selectUserRegisterInfoDO(@Param("userName") String userName);

    void insertBlogCountDO(List<BlogCountDO> blogCountDO);

    void insertBlogInfoDO(List<BlogInfoDO> blogInfoDO);

    void insertCommentToBlogDO(List<CommentToBlogDO> commentToBlogDO);

    void insertUserFollowDO(List<UserFollowDO> userFollowDO);

    void insertUserInfoDO(List<UserInfoDO> userInfoDO);

    void insertUserOthersDO(List<UserOthersDO> userOthersDO);

    void insertUserRegisterInfoDO(List<UserRegisterInfoDO> userRegisterInfoDO);

    void updateUserFollowDO(List<UserFollowDO> userFollowDO);
}
