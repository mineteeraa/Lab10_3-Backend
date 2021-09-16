package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import se331.lab.rest.entity.Bid;

import java.util.List;

public interface BidService {
    List<Bid> getAllOrganizer();
    Page<Bid> getOrganizer(Integer page, Integer pageSize);
}
