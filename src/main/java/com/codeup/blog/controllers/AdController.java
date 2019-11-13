//package com.codeup.blog.demo.controllers;
//
//import com.codeup.blog.demo.Ad;
//import com.codeup.blog.demo.Post;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//
//@Controller
//public class AdController {
//
//    ArrayList<Ad> adsList;
//
//    public AdController() {
//        adsList = new ArrayList<Ad>();
//
//        adsList.add(new Ad(1, "first ad", "new"));
//        adsList.add(new Ad(2, "second ad", "new"));
//        adsList.add(new Ad(3, "third ad", "used"));
//    }
//
//    @GetMapping("/ads")
//    public String index(Model viewModel){
//        viewModel.addAttribute("ads", adsList);
//
//        return "ads/index";
//    }
//
//    @GetMapping("/ads/{id}")
//    public String show(@PathVariable long id, Model viewModel){
//        viewModel.addAttribute("ad", adsList.get((int)id - 1));
//        return "ads/show";
//    }
//
//    @GetMapping("/ads/create")
//    public String showCreateForm(){
//        return "view the form for creating a ad";
//    }
//
//    @PostMapping("/ads/create")
//    @ResponseBody
//    public String create(@RequestParam String title, @RequestParam String body){
//        System.out.println("title = " + title);
//        System.out.println("body = " + body);
//        return "create a new ad";
//    }
//
//}


package com.codeup.blog.controllers;

        import com.codeup.blog.Ad;
        import com.codeup.blog.repositories.AdRepository;
        import com.codeup.blog.repositories.UserRepository;
        import com.codeup.blog.services.EmailService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.*;

@Controller
public class AdController {

    private final AdRepository adDao;
    private final UserRepository userDao;

    @Autowired
    EmailService emailService;

    public AdController(AdRepository adDao, UserRepository userDao, EmailService emailService) {
        this.adDao = adDao;
        this.userDao = userDao;
    }


    @GetMapping("/ads")
    public String index(Model viewModel){
        viewModel.addAttribute("ads", adDao.findAll());
        return "ads/index";
    }

    @GetMapping("/ads/{id}")
    public String show(@PathVariable long id, Model viewModel){
        viewModel.addAttribute("ad", adDao.getOne(id));
        return "ads/show";
    }

    @GetMapping("/ads/create")
    public String showCreateForm(){
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String create(@ModelAttribute Ad adToBeCreated, @RequestParam(name = "timeout") String timeout){
        System.out.println("timeout = " + timeout);
        adToBeCreated.setUser(userDao.getOne(1L));
        Ad savedAd = adDao.save(adToBeCreated);
        emailService.prepareAndSend(savedAd, "Ad created", "An Ad has been created, with the id of " + savedAd.getId());
        return "redirect:/ads/" + savedAd.getId();
    }

    @GetMapping("/ads/{id}/edit")
    public String edit(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("ad", adDao.getOne(id));
        return "ads/edit";
    }

    @PostMapping("/ads/{id}/edit")
    public String update(@PathVariable long id, @RequestParam String title, @RequestParam String description) {
        Ad oldAd = adDao.getOne(id);
        oldAd.setTitle(title);
        oldAd.setDescription(description);
        adDao.save(oldAd);
        return "redirect:/ads/" + id;
    }

    @PostMapping("/ads/{id}/delete")
    public String delete(@PathVariable long id) {
        adDao.deleteById(id);
        return "redirect:/ads";
    }


    // Repository Testing for JPA Lecture

//    @GetMapping("/ads/search")
//    @ResponseBody
//    public Ad search() {
//        return adDao.findByTitle("Gazella thompsonii");
//    }
//
//    @ResponseBody
//    @GetMapping("/list-ads")
//    public List<Ad> returnAds() {
//        return adDao.findAll();
//    }
//
//    @ResponseBody
//    @GetMapping("/ads/length")
//    public List<String> returnAdsByLength() {
//        return adDao.getAdsOfCertainTitleLength();
//    }
//
//    @ResponseBody
//    @GetMapping("/ads/length/native")
//    public List<String> returnAdsByLengthNative() {
//        return adDao.getAdsOfCertainTitleLengthNative();
//    }

}
