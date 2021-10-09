package bts.auction.api.consumer.controller;

import bts.auction.api.consumer.domain.Auction;
import bts.auction.api.consumer.service.AuctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
@Slf4j
@Api(value = "Auction Consumer Controller")
@RequiredArgsConstructor
@RestController
public class AuctionController {
    private final AuctionService auctionService;

    @ApiOperation(value = "모든 NFT의 경매 매수 참여 정보 조회")
    @GetMapping("auction/{nftid}")
    public Mono<Auction> consumedMessage(@PathVariable String nftid) {
        log.info("[Consumer - AuctionController] {"+nftid+"}의 최고 희망매수입찰가 반환");
        return auctionService.findByNftId(nftid);
    }

}
