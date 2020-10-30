package com.amos.controller;

import com.amos.queryvo.DetailedBlog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.amos.queryvo.FirstPageBlog;
import com.amos.queryvo.RecommendBlog;
import com.amos.service.BlogService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author Amos
 * @date 2020-10-27 23:39
 */


@Controller
public class IndexController {
    @Autowired
    private BlogService blogService;

    /**
     * 分页查询博客列表
     * @param model
     * @param pageNum
     * @param attributes
     * @return
     */
    @GetMapping("/")
    public String index(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer
                        pageNum , RedirectAttributes attributes)
    {
        PageHelper.startPage(pageNum,10);
        List<FirstPageBlog> allFirstpageBlog = blogService.getAllFirstPageBlog();
        List<RecommendBlog> recommendBlogs = blogService.getRecommendedBlog();

        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstpageBlog);
        System.out.println("PageInfo:" + pageInfo);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("recommendedBlogs",recommendBlogs);
        return "index";
    }

    /**
     * 搜索博客
     * @param model
     * @param pageNum
     * @param query
     * @return
     */
    public String search(Model model,@RequestParam(defaultValue = "1" ,value = "pageNum") Integer pageNum,
                         @RequestParam String query)
    {
        PageHelper.startPage(pageNum,1000);
        List<FirstPageBlog> searchBlog = blogService.getSearchBlog(query);


        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlog);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("query",query);
        return "search";
    }

    public String blogMessages(Model model)

    {
        int blogTotal = blogService.getBlogTotal();
        int blogViewTotal = blogService.getBlogViewTotal();
        int blogCommentTotal = blogService.getBlogCommentTotal();
        int blogMessageTotal = blogService.getBlogMessageTotal();


        model.addAttribute("blogTotal",blogTotal);
        model.addAttribute("blogViewTotal",blogViewTotal);
        model.addAttribute("blogCommentTotal",blogCommentTotal);
        model.addAttribute("blogMessageTotal",blogMessageTotal);

        return "index::blogMessage";
    }


    /**
     * 跳转博客详情页面
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) throws NotFoundException {
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        model.addAttribute("blog", detailedBlog);
        return "blog";
    }
}














