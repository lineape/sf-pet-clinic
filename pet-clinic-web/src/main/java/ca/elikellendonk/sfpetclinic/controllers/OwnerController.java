package ca.elikellendonk.sfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
  @RequestMapping({"/owners", "/owners/", "/owners.html"})
  public String index(Model model) {
    return "owner-index";
  }
}
