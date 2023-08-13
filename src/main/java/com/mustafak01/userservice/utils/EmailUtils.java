package com.mustafak01.userservice.utils;

import com.mustafak01.userservice.consts.EmailMessageConstants;

public class EmailUtils {
    public static String getEmailMessage(String name, String host, String confirmationKey) {
        String verificationUrl = getVerificationUrl(host, confirmationKey);
        StringBuilder emailMessage = new StringBuilder();
        emailMessage.append(EmailMessageConstants.GREETING).append(name).append("\n\n");
        emailMessage.append(EmailMessageConstants.ACCOUNT_CREATED).append("\n\n");
        emailMessage.append(verificationUrl).append("\n\n");
        emailMessage.append(EmailMessageConstants.SUPPORT_TEAM);
        return emailMessage.toString();
    }

    private static String getVerificationUrl(String host, String confirmationKey) {
        StringBuilder verificationUrl = new StringBuilder();
        verificationUrl.append(host).append(EmailMessageConstants.VERIFICATION_URI).append(confirmationKey);
        return verificationUrl.toString();
    }
}
