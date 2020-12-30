package egovframework.thymleaf.Jw.service.impl;

import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper("Mapperj")
public interface Mapperj {
	List<Map<String, Object>> selectNotice(Map<String, String> param);
	int deleteNotice(Map<String, String> map);
	
	Map<String, Object> selectNoticeDetail(String param);

	int updateNotice(Map<String, String> param);

	int insertNotice(Map<String, String> param);

}
