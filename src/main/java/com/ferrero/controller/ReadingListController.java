package com.ferrero.controller;

import com.ferrero.model.Book;
import com.ferrero.repository.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping(value="/{reader}", method=RequestMethod.GET)
    public ModelAndView readersBooks(@PathVariable("reader") String reader) {
        ModelAndView mav = new ModelAndView("readingList");
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            mav.addObject("books", readingList);
        }
        return mav;
    }

    @RequestMapping(value="/{reader}", method=RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/{reader}";
    }
}