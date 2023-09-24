package com.stocktrackr.api.v100.controllers;


import com.stocktrackr.api.v100.enums.OrderType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/stocks")
public class StockControllers {

    @GetMapping(path = "/symbols")
    public void searchStockSymbols(@RequestParam(name = "like") String like) {}

    @PostMapping(path = "/subscribe")
    public void subscribeStock(@RequestBody String stockSymbol) {}

    @PostMapping(path = "/order")
    public void createOrder(@RequestBody String stockSymbol, @RequestBody int quantity, @RequestBody OrderType orderType,
                            @RequestBody boolean isMarketPriceOrder, @RequestBody boolean isTargetedHigh, @RequestBody float targetedPrice) {}

    @GetMapping(path = "/order")
    public void getOrders() {}

    @PutMapping(path = "/order/{orderID}/cancel")
    public void cancelOrder(@PathVariable String orderID) {}

    @PostMapping(path = "/alert")
    public void registerStockAlert() {}

    @PutMapping(path = "/alert/{alertID}")
    public void updateStockAlert(@PathVariable String alertID, @RequestBody(required = false) Float priceForAlert,
                                 @RequestBody(required = false) Boolean isGoDownAlert, @RequestBody(required = false) Boolean toDeactivate) {}

}
