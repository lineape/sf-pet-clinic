package ca.elikellendonk.sfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {
  @RequestMapping("")
  public String index(Model model) {
    return "vets/index";
  }
}
