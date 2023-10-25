package org.example.controller;

import org.example.pojo.Clubs;
import org.example.pojo.PageBean;
import org.example.pojo.Players;
import org.example.service.ClubsService;
import org.example.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("players")
public class PlayersController {
    @Autowired
    private PlayersService playersService;
    @Autowired
    private ClubsService clubsService;
    @RequestMapping("select")
    public String select(HttpSession session, Model model, @RequestParam(value = "pname",required = false)String pname,
                         @RequestParam(value = "cid",required = false)Integer cid,
                         @RequestParam(value = "currPageNo",required = false,defaultValue = "1")Integer currPageNo){
        PageBean<Players> pageBean = playersService.select(pname,cid,currPageNo,2);
        model.addAttribute("pageBean",pageBean);
        List<Clubs> clubsList = clubsService.selectTiao();
        model.addAttribute("clubsList",clubsList);
        return "list";
    }
    @RequestMapping("toAdd")
    public String toAdd(Model model){
        List<Clubs> list = clubsService.selectTiao();
        model.addAttribute("list",list);
        return "add";
    }
    @RequestMapping("add")
    @ResponseBody
    public String add(Players players){
        int i = playersService.add(players);
        if(i==1){
            return "true";
        }else {
            return "false";
        }
    }
    @RequestMapping("delete")
    @ResponseBody
    public String delete(Integer pid){
        int i = playersService.delete(pid);
        if(i==1){
            return "true";
        }else {
            return "false";
        }
    }
}
