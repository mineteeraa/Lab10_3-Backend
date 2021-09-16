package se331.lab.rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.lab.rest.entity.AuctionItem;

public interface AuctionItemDao {
    Integer getAuctionItemSize();

    Page<AuctionItem> getAuctionItems(Integer pageSize, Integer page);

    AuctionItem getAuctionItem(Long id);

    AuctionItem save(AuctionItem auctionItem);

    Page<AuctionItem> getAuctionItem(String name, Pageable page);

    Page<AuctionItem> getAuctionItem(Integer amount, Pageable page);
}
