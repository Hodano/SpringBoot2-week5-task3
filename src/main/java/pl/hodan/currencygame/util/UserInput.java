package pl.hodan.currencygame.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class UserInput {
    private Scanner scanner;
    private Logger logger;

    public UserInput() {
        logger = LoggerFactory.getLogger(UserInput.class);
        scanner = new Scanner(System.in);
    }

    public double getUserInput() {
        double input = 0;
        try {
            input = scanner.nextDouble();
        } catch (InputMismatchException e) {
            logger.warn("Bad Format double");
        }
        return input;

    }
}
