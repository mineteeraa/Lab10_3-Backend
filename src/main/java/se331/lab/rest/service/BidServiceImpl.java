package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.BidDao;
import se331.lab.rest.entity.Bid;

import java.util.List;

@Service
public class BidServiceImpl implements BidService {
    @Autowired
    BidDao bidDao;
    @Override
    public List<Bid> getAllBid() {
        return bidDao.getBid(Pageable.unpaged()).getContent();
    }

    @Override
    public Page<Bid> getBid(Integer page, Integer pageSize) {
        return bidDao.getBid(PageRequest.of(page,pageSize));
    }
}
