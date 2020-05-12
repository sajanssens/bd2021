package com.example.cdi.producers;

import com.example.cdi.greeters.qualifiers.MaxNumber;
import com.example.cdi.greeters.qualifiers.RandomNumber;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import java.util.Random;

@Singleton
public class NumberProducer {

    private final int maxNumber = 100;
    private Random random = new Random();

    @Produces @RandomNumber int next() { return random.nextInt(maxNumber); }

    @Produces @MaxNumber int getMaxNumber() { return maxNumber; }
}
