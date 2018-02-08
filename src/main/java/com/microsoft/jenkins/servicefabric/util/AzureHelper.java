package com.microsoft.jenkins.servicefabric.util;

import com.microsoft.azure.management.Azure;
import com.microsoft.azure.util.AzureBaseCredentials;
import com.microsoft.azure.util.AzureCredentialUtil;
import com.microsoft.jenkins.azurecommons.core.AzureClientFactory;
import com.microsoft.jenkins.azurecommons.core.credentials.TokenCredentialData;

public final class AzureHelper {
    public static TokenCredentialData getToken(String credentialsId) {
        AzureBaseCredentials credentials = AzureCredentialUtil.getCredential2(credentialsId);
        if (credentials == null) {
            throw new IllegalStateException("Cannot find credentials with ID: " + credentialsId);
        }
        return TokenCredentialData.deserialize(credentials.serializeToTokenData());
    }

    public static Azure buildClient(String credentialsId) {
        TokenCredentialData token = getToken(credentialsId);
        return buildClient(token);
    }

    public static Azure buildClient(TokenCredentialData token) {
        return AzureClientFactory.getClient(token);
    }

    private AzureHelper() {
        // hide constructor
    }
}
