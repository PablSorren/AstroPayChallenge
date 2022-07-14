package com.dominio.astropay.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LocalController {

  @RequestMapping(value = "/")
  public String getHomePage() {
    return "index";
  }
}
