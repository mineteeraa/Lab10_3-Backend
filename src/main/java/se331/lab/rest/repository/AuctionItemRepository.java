package se331.lab.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.AuctionItem;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    List<AuctionItem> findAll();

    Page<AuctionItem> findByDescription(String title, Pageable pageRequest);

    Page<AuctionItem> findByDescriptionContaining(String title, Pageable pageRequest);

    Page<AuctionItem> findByDescriptionContainingOrTypeContaining(String title, String description, Pageable pageRequest);

    Page<AuctionItem> findBySuccessfulBid_AmountLessThan (Integer amount, Pageable pageRequest);
}
