package se331.lab.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import se331.lab.rest.dao.AuctionItemDao;
import se331.lab.rest.dao.BidDao;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Bid;

import javax.transaction.Transactional;

@Service
public class AuctionItemServiceImpl implements AuctionItemService {
    @Autowired
    AuctionItemDao eventDao;
    @Autowired
    BidDao organizerDao;

    @Override
    public Integer getEventSize() {
        return eventDao.getEventSize();
    }

    @Override
    public Page<AuctionItem> getEvents(Integer pageSize, Integer page) {
        return eventDao.getEvents(pageSize, page);
    }

    @Override
    public AuctionItem getEvent(Long id) {
        return eventDao.getEvent(id);
    }

    @Override
    @Transactional
    public AuctionItem save(AuctionItem auctionItem) {
        Bid bid = organizerDao.findById(auctionItem.getBid().getId()).orElse(null);
        auctionItem.setBid(bid);
        bid.getOwnAuctionItems().add(auctionItem);
        return eventDao.save(auctionItem);
    }

    @Override
    public Page<AuctionItem> getEvents(String title, Pageable pageable) {
        return eventDao.getEvent(title, pageable);
    }
}
