package com.yootk.action;

import com.yootk.common.action.abs.AbstractAction;
import com.yootk.common.annotation.Controller;
import com.yootk.common.annotation.RequestMapping;

@Controller
public class MyAction extends AbstractAction {
    @RequestMapping("/abc/a")
    public void add(){
        System.out.println("hello");
        super.print("hello");
    }

    @Override
    public String getUploadDir() {
        return null;
    }
}
