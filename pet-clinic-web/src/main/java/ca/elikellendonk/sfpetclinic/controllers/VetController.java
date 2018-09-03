package ca.elikellendonk.sfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {
  @RequestMapping({"/vets", "/vets/", "/vets.html"})
  public String index(Model model) {
    return "vets/index";
  }
}
