package se331.lab.rest.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.repository.AuctionItemRepository;

@Repository
@Profile("db")
public class AuctionItemDaoDbImpl implements AuctionItemDao {
    @Autowired
    AuctionItemRepository auctionItemRepository;

    @Override
    public Page<AuctionItem> getEvent(String title, Pageable page) {
        return auctionItemRepository.findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrOrganizer_NameIgnoreCaseContaining(title, title, title, page);
    }

    @Override
    public Integer getEventSize() {
        return Math.toIntExact(auctionItemRepository.count());
    }

    @Override
    public Page<AuctionItem> getEvents(Integer pageSize, Integer page) {
        return auctionItemRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public AuctionItem getEvent(Long id) {
        return auctionItemRepository.findById(id).orElse(null);
    }

    @Override
    public AuctionItem save(AuctionItem auctionItem) {
        return auctionItemRepository.save(auctionItem);
    }
}