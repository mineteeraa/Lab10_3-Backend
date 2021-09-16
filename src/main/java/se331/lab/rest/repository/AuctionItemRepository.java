package se331.lab.rest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import se331.lab.rest.entity.AuctionItem;

import java.util.List;

public interface AuctionItemRepository extends JpaRepository<AuctionItem, Long> {
    List<AuctionItem> findAll();

    Page<AuctionItem> findByTitle(String title, Pageable pageRequest);

    Page<AuctionItem> findByTitleContaining(String title, Pageable pageRequest);

    Page<AuctionItem> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageRequest);

    Page<AuctionItem> findByTitleContainingAndDescriptionContaining(String title, String description, Pageable pageRequest);

    Page<AuctionItem> findByTitleContainingOrDescriptionContainingOrOrganizer_NameContaining(String title, String description, String organizerName, Pageable pageRequest);

    Page<AuctionItem> findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrOrganizer_NameIgnoreCaseContaining(String title, String description, String organizerName, Pageable pageRequest);
}
