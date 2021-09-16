package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;

public interface AuctionItemService {
    Integer getEventSize();

    Page<AuctionItem> getEvents(Integer pageSize, Integer page);

    AuctionItem getEvent(Long id);

    AuctionItem save(AuctionItem auctionItem);

    Page<AuctionItem> getEvents(String title, Pageable pageable);
}
