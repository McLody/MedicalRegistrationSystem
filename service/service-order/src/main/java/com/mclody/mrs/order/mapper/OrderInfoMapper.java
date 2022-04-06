package com.mclody.mrs.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mclody.mrs.model.order.OrderInfo;
import com.mclody.mrs.vo.order.OrderCountQueryVo;
import com.mclody.mrs.vo.order.OrderCountVo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    List<OrderCountVo> selectOrderCount(@Param("vo") OrderCountQueryVo orderCountQueryVo);
}

