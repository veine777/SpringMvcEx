package org.top.springmvcex;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {
    @GetMapping("")
    public String index(){
        return "index";
    }
    @GetMapping("time")
    //получение текущей даты
    public String time(Model model){
        String currentTime = LocalDateTime.now().toString();
        model.addAttribute("nowTime", currentTime);
        return "time";
    }
    @GetMapping("info")
    public String info(Model model){
        //получение текущей даты
        //текущая дата
        LocalDate currentDate = LocalDate.now();
        //формирование даты в формате дд мм гггг
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String formattedDate = currentDate.format(formatter);
        model.addAttribute("formattedDate", formattedDate);

        //получение ОС
        String osName = System.getProperty("os.name");
        model.addAttribute("osName", osName);

        //получение osVersion
        String osVersion = System.getProperty("os.version");
        model.addAttribute("osVersion", osVersion);

        //получение osArch
        String osArch = System.getProperty("os.arch");
        model.addAttribute("osArch", osArch);

        return "info";
    }


}
