package boot.web;

import boot.oom.ArraySizeExceeds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/oom")
public class OomController {

    @RequestMapping("/arraySizeExceeds")
    public void arraySizeExceeds(){
        ArraySizeExceeds.test();
    }

    @RequestMapping("/createNativeThreads")
    public void createNativeThreads(){
        ArraySizeExceeds.test();
    }

    @RequestMapping("/gcOverrhead")
    public void gcOverrhead(){
        ArraySizeExceeds.test();
    }

    @RequestMapping("/heapSize")
    public void heapSize(){
        ArraySizeExceeds.test();
    }

}
