package bts.auction.api.consumer.service;

import bts.auction.api.consumer.domain.Auction;
import bts.auction.api.consumer.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final AuctionRepository auctionRepository;

    @KafkaListener(topics = "auction", groupId = "auction-group_id", containerFactory = "auctionKafkaListenerFactory")
    public void consume(Auction auction){
        auctionRepository.save(auction).subscribe();
        System.out.println("Consumed message : " + "\n{\n"
                + "\tnft_id: " + auction.getNft_id() + ", \n"
                + "\temail: " + auction.getEmail() + ", \n"
                + "\tauction_price: " + auction.getAuctionPrice() + "\n}");
    }
}
