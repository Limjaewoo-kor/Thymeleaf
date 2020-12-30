package egovframework.thymleaf.Jw.service;

import java.util.List;
import java.util.Map;

public interface Servicej {

	List<Map<String, Object>> selectNotice(Map<String, String> param);

	int deleteNotice(Map<String, String> map);

	Map<String, Object> selectNoticeDetail(String param);

	int updateNotice(Map<String, String> param);

	int insertNotice(Map<String, String> param);

}
