package com.newcoder.zhike;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ZhikeApplicationTests {

    @Test
    void contextLoads() {
        System.out.println(StringUtils.isBlank("  o"));
    }

}
