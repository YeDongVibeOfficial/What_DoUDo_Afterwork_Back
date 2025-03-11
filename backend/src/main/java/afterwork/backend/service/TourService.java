package afterwork.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import afterwork.backend.domain.TourDomain;
import afterwork.backend.mapper.TourMapper;

@Service
public class TourService {
    private final TourMapper tourMapper;

    public TourService(TourMapper tourMapper) {
        this.tourMapper = tourMapper;
    }

    @Transactional
    public void saveTourInfo(TourDomain tourDTO) {
        tourMapper.insertTourInfo(tourDTO);
    }

    public List<TourDomain> getAllTourInfo() {
        return tourMapper.getAllTourInfo();
    }
}
