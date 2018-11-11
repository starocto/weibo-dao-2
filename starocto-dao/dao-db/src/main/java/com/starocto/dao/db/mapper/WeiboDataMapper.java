package com.starocto.dao.db.mapper;

import com.starocto.dao.db.model.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Author : zjx@.com
 * Date   : 2018/10/3
 * Time   : 12:50
 * ---------------------------------------
 * Desc   : 微博消息，突然发现这里其实是朋友圈的机制，即只能获取关注的人的消息。
 *          如果想处理"发现"页面的微博消息内容，需要selectBlogInfoDO()方法忽略入参userId才行，需要修改SQL语句。
 *          另外，需要添加 查询的开始时间和结束时间。
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

    List<UserRegisterInfoDO> selectAllUserRegisterInfoDO(@Param("userName") List<String> userName);

    void insertBlogCountDO(List<BlogCountDO> blogCountDO);

    void insertBlogInfoDO(List<BlogInfoDO> blogInfoDO);

    void insertCommentToBlogDO(List<CommentToBlogDO> commentToBlogDO);

    void insertUserFollowDO(List<UserFollowDO> userFollowDO);

    void insertUserInfoDO(List<UserInfoDO> userInfoDO);

    void insertUserOthersDO(List<UserOthersDO> userOthersDO);

    void insertUserRegisterInfoDO(List<UserRegisterInfoDO> userRegisterInfoDO);

    void updateUserFollowDO(List<UserFollowDO> userFollowDO);
}
