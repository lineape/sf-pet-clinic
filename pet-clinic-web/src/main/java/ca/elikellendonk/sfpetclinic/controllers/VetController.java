package ca.elikellendonk.sfpetclinic.controllers;

import ca.elikellendonk.sfpetclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {
  private VetService vetService;

  public VetController(VetService vetService) {
    this.vetService = vetService;
  }

  @RequestMapping("")
  public String index(Model model) {
    model.addAttribute("vets", vetService.findAll());

    return "vets/index";
  }
}
