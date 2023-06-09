package edu.sandbox.javamemorymodel.happensbefore;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SameThreadActionsHappensBeforeDemo {

    public static void main(String[] args) {
        // guarantee that 'a1' will be initialized before 'a2'
        var a1 = 1;
        var a2 = a1 + 2;
        log.info(">>>> same thread actions result = {}", a2);
    }
}
