package io.woolford;


import io.woolford.database.entity.BacktestScenarioRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    BacktestTicker backtestTicker;

    @RequestMapping(value = "/scenario", params = {"ticker",
            "cash",
            "shares",
            "transactionCost",
            "transactionSize",
            "fallTrigger",
            "climbTrigger"})
    @ResponseBody
    public BacktestScenarioRecord getBacktestResult(@RequestParam("ticker") String ticker,
                                                    @RequestParam("cash") Double cash,
                                                    @RequestParam("shares") Integer shares,
                                                    @RequestParam("transactionCost") Double transactionCost,
                                                    @RequestParam("transactionSize") Integer transactionSize,
                                                    @RequestParam("fallTrigger") Double fallTrigger,
                                                    @RequestParam("climbTrigger") Double climbTrigger) {
        return backtestTicker.backtest(ticker, cash, shares, transactionCost, transactionSize, fallTrigger, climbTrigger);

    }
}