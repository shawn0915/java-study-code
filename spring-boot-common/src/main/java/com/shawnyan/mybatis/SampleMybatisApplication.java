//package com.shawnyan.mybatis;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
///**
// * @author shawnyan
// * @date 2017/11/16 下午3:48
// */
//@SpringBootApplication
//public class SampleMybatisApplication implements CommandLineRunner {
//
//    private final CityMapper cityMapper;
//
//    public SampleMybatisApplication(CityMapper cityMapper) {
//        this.cityMapper = cityMapper;
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(SampleMybatisApplication.class, args);
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(this.cityMapper.findByState("CA"));
//    }
//
//}
