package com.eventhub.funciton;

import com.microsoft.azure.functions.BrokerAuthenticationMode;
import com.microsoft.azure.functions.BrokerProtocol;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.KafkaTrigger;

public class EventhubFunctionApplication {

    static  final String topic_name = "topic name";
    static  final String broker_list = "bootstrap service";
    static  final String hub_connectionString="hub connection string";

    @FunctionName("KafkaTrigger")
    public void runSingle (
            @KafkaTrigger(
                    name = "KafkaTrigger",
                    topic = topic_name,
                    brokerList=broker_list,
                    consumerGroup="$Default",
                    username = "$ConnectionString",
                    password =hub_connectionString,
                    authenticationMode= BrokerAuthenticationMode.PLAIN,
                    protocol = BrokerProtocol.SASLSSL,
                    dataType = "string"
            ) String kafka,
            final ExecutionContext context) {
        context.getLogger().info(kafka);
    }



}


