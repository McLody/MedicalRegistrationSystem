package com.mclody.mrs.cmn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mclody.mrs.model.cmn.Dict;
import com.mclody.mrs.model.hosp.HospitalSet;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface DictService extends IService<Dict> {

    List<Dict> findChlidData(Long id);

    void exportData(HttpServletResponse response);

    void importDictData(MultipartFile file);
}
