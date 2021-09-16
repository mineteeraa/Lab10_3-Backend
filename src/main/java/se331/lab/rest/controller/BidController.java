package se331.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.rest.service.BidService;
import se331.lab.rest.util.LabMapper;

@RestController
public class BidController {
    @Autowired
    BidService bidService;
    @GetMapping("/bids")
    ResponseEntity<?> getBids(){
        return ResponseEntity.ok(LabMapper.INSTANCE.getBidDTO(bidService.getAllBid()));
    }
}
