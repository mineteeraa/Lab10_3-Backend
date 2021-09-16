package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;

public interface AuctionItemDao {
    Integer getEventSize();

    Page<AuctionItem> getEvents(Integer pageSize, Integer page);

    AuctionItem getEvent(Long id);

    AuctionItem save(AuctionItem auctionItem);

    Page<AuctionItem> getEvent(String name, Pageable page);
}
