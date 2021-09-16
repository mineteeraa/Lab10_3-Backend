package se331.lab.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;

public interface AuctionItemService {
    Integer getAuctionItemSize();

    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);

    AuctionItem getAuctionItem(Long id);

    AuctionItem save(AuctionItem auctionItem);

    Page<AuctionItem> getAuctionItems(String title, Pageable pageable);

    Page<AuctionItem> getAuctionItems(Integer amount, Pageable pageable);
}
