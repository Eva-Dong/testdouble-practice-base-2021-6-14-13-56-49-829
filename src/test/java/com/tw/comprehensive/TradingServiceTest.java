package com.tw.comprehensive;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class TradingServiceTest {

    @Test
    public void should_call_log_new_trade_method_when_execute_create_trade(){
        //given
        AuditService auditService = mock(AuditService.class);
        TradeRepository tradeRepository = new TradeRepository();
        TradingService tradingService = new TradingService(tradeRepository, auditService);
        Trade trade = new Trade("1" ,"2");

        //when
        tradingService.createTrade(trade);

        //then
        verify(auditService).logNewTrade(trade);
    }

}