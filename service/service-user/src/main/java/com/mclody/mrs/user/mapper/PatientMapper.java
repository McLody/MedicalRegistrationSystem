package com.mclody.mrs.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mclody.mrs.model.user.Patient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper extends BaseMapper<Patient> {
}

