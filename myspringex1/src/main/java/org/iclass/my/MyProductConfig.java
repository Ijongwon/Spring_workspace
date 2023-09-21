package org.iclass.my;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.iclass.my")   //해당패키지의 Component를 모두 bean으로 생성
public class MyProductConfig {

}
