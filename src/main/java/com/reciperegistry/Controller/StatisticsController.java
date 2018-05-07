package com.reciperegistry.Controller;

import com.reciperegistry.Models.RecipeStatistics;
import com.reciperegistry.Service.CustomLogService;
import com.reciperegistry.Service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This class is responsible for statistics related Rest points.
 *
 * @author Szatmári Mihály
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    StatisticsService statisticsService;

    /**
     * Calls the {@link StatisticsService#getStatistics()} method from {@link StatisticsService}.
     *
     * @return the number of recipes grouped by tbe recipe categories
     */
    @GetMapping("get")
    public List<RecipeStatistics> getStatistics() {
        CustomLogService.controllerLog("statistics/get", "StatisticsController");

        return this.statisticsService.getStatistics();
    }
}
