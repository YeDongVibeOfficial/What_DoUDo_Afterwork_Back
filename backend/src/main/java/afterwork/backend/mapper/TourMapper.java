package afterwork.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import afterwork.backend.domain.TourDomain;

//mybatis 사용하기 위한 어노테이션
@Mapper
public interface TourMapper {
    void insertTourInfo(TourDomain tour);  // XML에서 구현된 SQL을 실행
    List<TourDomain> getAllTourInfo();
}
