package afterwork.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import afterwork.backend.dto.TourDTO;

//mybatis 사용하기 위한 어노테이션
@Mapper
public interface TourMapper {
    // 데이터 삽입 (자동 증가하는 ID 사용)
    @Insert("INSERT INTO tour_info (plcode, plTitle, plAddrBasic, plAddrDetail, plTel, plImg, plMapX, plMapY) " +
            "VALUES (#{plcode}, #{plTitle}, #{plAddrBasic}, #{plAddrDetail}, #{plTel}, #{plImg}, #{plMapX}, #{plMapY})")
    @Options(useGeneratedKeys = true, keyProperty = "id")  // 자동 생성된 id 값 매핑
    void insertTourInfo(TourDTO tourDTO);

    // 모든 데이터 조회
    @Select("SELECT id, plcode, plTitle, plAddrBasic, plAddrDetail, plTel, plImg, plMapX, plMapY FROM tour_info")
    List<TourDTO> getAllTourInfo();
}
