package com.mclody.mrs.hosp.service;

import com.mclody.mrs.model.hosp.Department;
import com.mclody.mrs.vo.hosp.DepartmentQueryVo;
import com.mclody.mrs.vo.hosp.DepartmentVo;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    void save(Map<String, Object> paramMap);

    Page<Department> selectPage(Integer page, Integer limit, DepartmentQueryVo departmentQueryVo);

    void remove(String hoscode, String depcode);

    List<DepartmentVo> findDeptTree(String hoscode);

    String getDepName(String hoscode, String depcode);

    Department getDepartment(String hoscode, String depcode);
}
