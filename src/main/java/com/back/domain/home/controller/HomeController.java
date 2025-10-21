package com.back.domain.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Controller
public class HomeController {

  @GetMapping("/")
  @ResponseBody
  public String main() {
    // 로컬 호스트 정보를 저장할 변수 초기화
    InetAddress localHost = null;

    try {
      localHost = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      throw new RuntimeException(e);
    }

    return "main(version : 1.0.2), hostname : %s".formatted(localHost.getHostName());
  }
}
