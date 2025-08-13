package com.imam.moneymate.service.impl;

import com.imam.moneymate.entity.Profile;
import com.imam.moneymate.repository.ProfileRepository;
import com.imam.moneymate.service.EmailService;
import com.imam.moneymate.service.ExpenseService;
import com.imam.moneymate.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    private final ProfileRepository profileRepository;

    private final EmailService emailService;

    private final ExpenseService expenseService;

    @Value("${money.manager.frontend.url}")
    private String frontendUrl;

    @Scheduled(cron = "0 0 22 * * *", zone = "IST")
    public void sendDailyIncomeExpanseReminder() {
        log.info("Job started: sendDailyIncomeExpanseReminder()");
        List<Profile> profiles = profileRepository.findAll();
        for (Profile profile : profiles) {
            String body = "Hi" + profile.getFullName() + ", <br><br>"
                    + "This is a friendly reminder to add your income and expense for today money"
                    + "<a href=" + frontendUrl + " style='display:inline-block; padding: 10px 20px; background-color: 4CAF50> Go to Money Mate</a>"
                    + "<br><br> Best Regards, <br> Money mate team";
            emailService.sendEmail(profile.getEmail(), "Daily reminder: Add your Income and expense", body);
        }
    }
}
