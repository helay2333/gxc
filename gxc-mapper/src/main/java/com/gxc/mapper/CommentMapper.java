package com.gxc.mapper;

import com.gxc.my.mapper.MyMapper;
import com.gxc.pojo.Comment;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentMapper extends MyMapper<Comment> {
}