package se331.lab.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import se331.lab.rest.entity.AuctionItem;
import se331.lab.rest.entity.Bid;
import se331.lab.rest.repository.AuctionItemRepository;
import se331.lab.rest.repository.BidRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    AuctionItemRepository auctionItemRepository;
    @Autowired
    BidRepository bidRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        AuctionItem auc1, auc2, auc3, auc4, auc5;
        Bid bid1, bid2, bid3, bid4, bid5, bid6, bid7, bid8, bid9, bid10, bid11, bid12, bid13, bid14, bid15;
        bid1 = bidRepository.save(Bid.builder()
                .amount(160)
                .datetime(LocalDateTime.now())
                .build());
        bid2 = bidRepository.save(Bid.builder()
                .amount(200)
                .datetime(LocalDateTime.now())
                .build());
        bid3 = bidRepository.save(Bid.builder()
                .amount(380)
                .datetime(LocalDateTime.now())
                .build());
        bid4 = bidRepository.save(Bid.builder()
                .amount(190)
                .datetime(LocalDateTime.now())
                .build());
        bid5 = bidRepository.save(Bid.builder()
                .amount(290)
                .datetime(LocalDateTime.now())
                .build());
        bid6 = bidRepository.save(Bid.builder()
                .amount(490)
                .datetime(LocalDateTime.now())
                .build());
        bid7 = bidRepository.save(Bid.builder()
                .amount(110)
                .datetime(LocalDateTime.now())
                .build());
        bid8 = bidRepository.save(Bid.builder()
                .amount(240)
                .datetime(LocalDateTime.now())
                .build());
        bid9 = bidRepository.save(Bid.builder()
                .amount(500)
                .datetime(LocalDateTime.now())
                .build());
        bid10 = bidRepository.save(Bid.builder()
                .amount(340)
                .datetime(LocalDateTime.now())
                .build());
        bid11 = bidRepository.save(Bid.builder()
                .amount(570)
                .datetime(LocalDateTime.now())
                .build());
        bid12 = bidRepository.save(Bid.builder()
                .amount(760)
                .datetime(LocalDateTime.now())
                .build());
        bid13 = bidRepository.save(Bid.builder()
                .amount(530)
                .datetime(LocalDateTime.now())
                .build());
        bid14 = bidRepository.save(Bid.builder()
                .amount(880)
                .datetime(LocalDateTime.now())
                .build());
        bid15 = bidRepository.save(Bid.builder()
                .amount(1660)
                .datetime(LocalDateTime.now())
                .build());

        auc1 = auctionItemRepository.save(AuctionItem.builder()
                .description("Item 1")
                .type("Salmon")
                .build());

        auc2 = auctionItemRepository.save(AuctionItem.builder()
                .description("Item 2")
                .type("Electronic")
                .build());

        auc3 = auctionItemRepository.save(AuctionItem.builder()
                .description("Item 3")
                .type("Music Album")
                .build());

        auc4 = auctionItemRepository.save(AuctionItem.builder()
                .description("Item 4")
                .type("Kitchenware")
                .build());

        auc5 = auctionItemRepository.save(AuctionItem.builder()
                .description("Item 5")
                .type("Camera")
                .build());

        //Bid the auction item 1
        bid1.setItem(auc1);
        auc1.getBids().add(bid1);

        bid2.setItem(auc1);
        auc1.getBids().add(bid2);

        bid3.setItem(auc1);
        auc1.getBids().add(bid3);

        auc1.setSuccessfulBid(bid3);

        //Bid the auction item 2
        bid4.setItem(auc2);
        auc2.getBids().add(bid4);

        bid5.setItem(auc2);
        auc2.getBids().add(bid5);

        bid6.setItem(auc2);
        auc2.getBids().add(bid6);

        auc2.setSuccessfulBid(bid6);

        //Bid the auction item 3
        bid7.setItem(auc3);
        auc3.getBids().add(bid7);

        bid8.setItem(auc3);
        auc3.getBids().add(bid8);

        bid9.setItem(auc3);
        auc3.getBids().add(bid9);

        auc3.setSuccessfulBid(bid9);

        //Bid the auction item 4
        bid10.setItem(auc4);
        auc4.getBids().add(bid10);

        bid11.setItem(auc4);
        auc4.getBids().add(bid11);

        bid12.setItem(auc4);
        auc4.getBids().add(bid12);

        auc4.setSuccessfulBid(bid12);

        //Bid the auction item 5
        bid13.setItem(auc5);
        auc5.getBids().add(bid13);

        bid14.setItem(auc5);
        auc5.getBids().add(bid14);

        bid15.setItem(auc5);
        auc5.getBids().add(bid15);

        auc5.setSuccessfulBid(bid15);
    }
}
