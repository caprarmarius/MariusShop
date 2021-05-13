/*package com.mariushop.mariushop.schedulers;

import com.mariushop.mariushop.dtos.EmailDTO;
import com.mariushop.mariushop.dtos.StockDTO;
import com.mariushop.mariushop.services.EmailService;
import com.mariushop.mariushop.services.StockService;
import com.mariushop.mariushop.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;


import java.util.List;

@Configuration
@Component
@EnableScheduling
@RequiredArgsConstructor
public class EmailSendingScheduler {

    private final EmailService emailService;
    private final UserService userService;
    private final StockService stockService;
    private List<StockDTO> stockList;


    public EmailDTO getEmailDTOData() {
        return EmailDTO.builder()
                .productId(6)
                .username("user")
                .build();
    }*/

//    @Scheduled(cron = "* * * */1 * *")
//    public void sendEmail() {
//        EmailDTO emailDTO = getEmailDTOData();
//        if (userService.findUserByUsername(emailDTO.getUsername()).getEmailAddress() != null) {
//            stockList = stockService.getAllStocks();
//
//            for (StockDTO stockDTO : stockList) {
//                if (stockDTO.getProductID().equals(emailDTO.getProductId()) && stockDTO.getQuantity() > 0) {
//                    emailService.sendEmail(emailDTO);
//                    return;
//                }
//            }
//        }
//    }
//}
