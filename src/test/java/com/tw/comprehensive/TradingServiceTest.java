package com.tw.comprehensive;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

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

    @Test
    public void should_return_same_value_between_find_trade_and_find_by_id(){
        //given
        AuditService auditService = mock(AuditService.class);
        TradeRepository tradeRepository = mock(TradeRepository.class);
        TradingService tradingService = new TradingService(tradeRepository, auditService);
        Trade expectedTrade = new Trade("1" ,"2");
        doReturn(expectedTrade).when(tradeRepository).findById(any());

        //when
        Trade trade = tradingService.findTrade(anyLong());

        //then
        assertEquals(trade, expectedTrade);
    }

}