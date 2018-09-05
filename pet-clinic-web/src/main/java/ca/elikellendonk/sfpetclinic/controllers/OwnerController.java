package ca.elikellendonk.sfpetclinic.controllers;

import ca.elikellendonk.sfpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/owners")
@Controller
public class OwnerController {
  private OwnerService ownerService;

  public OwnerController(OwnerService ownerService) {
    this.ownerService = ownerService;
  }

  @RequestMapping("")
  public String index(Model model) {
    model.addAttribute("owners", ownerService.findAll());

    return "owners/index";
  }

  @RequestMapping("/find")
  public String findOwner() {
    return "owners/findOwner";
  }
}
