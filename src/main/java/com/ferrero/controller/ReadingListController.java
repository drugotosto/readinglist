package com.ferrero.controller;

import com.ferrero.model.Book;
import com.ferrero.model.User;
import com.ferrero.repository.ReadingListRepository;
import com.ferrero.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by drugo on 16/06/2017.
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    @Autowired
    private ReadingListRepository readingListRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/user/{reader}", method=RequestMethod.GET)
    public ModelAndView readersBooks(@PathVariable("reader") String reader) {
        ModelAndView mav = new ModelAndView("readingList");
        List<Book> readingList = readingListRepository.findByReader(reader);
        User user = userRepository.findByUsername(reader);
        if (readingList != null) {
            mav.addObject("books", readingList);
            mav.addObject("reader",user);
        }
        return mav;
    }

    @RequestMapping(value="/registerbook", method=RequestMethod.POST)
    public String addToReadingList(Book book) {
        readingListRepository.save(book);
        return "redirect:/profile/"+book.getReader();
    }

    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(){return "login";}

    @RequestMapping()
    public String home(){
        return "index";
    }

    @RequestMapping(value="/profile/{reader}", method=RequestMethod.GET)
    public ModelAndView showReaderProfile(@PathVariable("reader") String username){
        ModelAndView mav = new ModelAndView("profile");
        User user = userRepository.findByUsername(username);
        mav.addObject("reader" ,user);
        return mav;
    }

}