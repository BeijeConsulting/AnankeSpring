package it.beije.ananke.ecommerce.controller.restcontroller;

import it.beije.ananke.ecommerce.model.Chart;
import it.beije.ananke.ecommerce.repositories.ChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ChartRestController {

    @Autowired
    ChartRepository chartRepository;

    @GetMapping("/chart/{userId}")
    public List<Chart> getChar(@RequestParam Integer userId) {
        System.out.println("getting your chart");
        List<Chart> chart = chartRepository.findByUserId(userId);
        return chart;
    }
}
