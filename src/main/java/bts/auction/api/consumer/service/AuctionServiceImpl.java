package bts.auction.api.consumer.service;

import bts.auction.api.consumer.domain.Auction;
import bts.auction.api.consumer.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService {
    private final AuctionRepository auctionRepository;

    @Override
    public Flux<Auction> findAll() {
        return auctionRepository.findAll();
    }

    @Override
    public Mono<Auction> findByNftId(String nftid) {
        List<String> names = new ArrayList<>();
        Mono<Auction> autionFlux = auctionRepository.findByNftId(nftid).last();
        return autionFlux;
    }
}
