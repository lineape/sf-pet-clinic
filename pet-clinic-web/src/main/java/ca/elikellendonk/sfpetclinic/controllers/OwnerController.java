package ca.elikellendonk.sfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
  @RequestMapping("")
  public String index(Model model) {
    return "owners/index";
  }
}
