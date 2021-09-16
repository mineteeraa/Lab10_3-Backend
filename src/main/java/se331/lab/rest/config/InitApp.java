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

@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    AuctionItemRepository auctionItemRepository;
    @Autowired
    BidRepository bidRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Bid org1,org2,org3;
        org1 = bidRepository.save(Bid.builder()
                .name("CAMT").build());
        org2 = bidRepository.save(Bid.builder()
                .name("CMU").build());
        org3 = bidRepository.save(Bid.builder()
        .name("ChiangMai").build());
        AuctionItem tempAuctionItem;
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempAuctionItem.setBid(org1);
        org1.getOwnAuctionItems().add(tempAuctionItem);
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petAllowed(false)
                .build());
        tempAuctionItem.setBid(org1);
        org1.getOwnAuctionItems().add(tempAuctionItem);
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempAuctionItem.setBid(org2);
        org2.getOwnAuctionItems().add(tempAuctionItem);
        tempAuctionItem = auctionItemRepository.save(AuctionItem.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempAuctionItem.setBid(org3);
        org3.getOwnAuctionItems().add(tempAuctionItem);
    }
}
