/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javainuse.controllers;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.WebAsyncTask;

/**
 *
 * @author surajit.samui
 */
@Controller
public class MyWebController3 {

    @RequestMapping("/test3")
    public
    @ResponseBody
    WebAsyncTask<String> handleRequest (HttpServletRequest r) {
        System.out.println("asyncSupported: " + r.isAsyncSupported());
        System.out.println(Thread.currentThread().getName());

        Callable<String> callable = () -> {System.out.println(Thread.currentThread().getName());
            return "WebAsyncTask test";
        };
        ConcurrentTaskExecutor t = new ConcurrentTaskExecutor(Executors.newFixedThreadPool(1));
        return new WebAsyncTask<>(10000L, t, callable);
    }
}